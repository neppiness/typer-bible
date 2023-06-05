package typer.bible.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import typer.bible.domain.Book;
import typer.bible.domain.BookName;
import typer.bible.domain.Chapter;
import typer.bible.domain.Testimony;
import typer.bible.repository.MemoryBibleRepository;
import typer.bible.service.util.ChapterIdResolver;
import typer.bible.service.util.UrlResolver;

import java.util.ArrayList;
import java.util.List;

import static typer.bible.service.util.BookFinder.findBookName;

@Controller
@RequestMapping("/verse")
public class VerseController {

    final static MemoryBibleRepository memoryBibleRepository = MemoryBibleRepository.getInstance();

    @GetMapping("")
    public String getNavigationPage(Model model) {
        List<BookName> oldTestimonyBookNames = new ArrayList<>();
        List<BookName> newTestimonyBookNames = new ArrayList<>();

        for (BookName bookName : BookName.values()) {
            if (bookName.testimony.equals(Testimony.OLD))
                oldTestimonyBookNames.add(bookName);
            else newTestimonyBookNames.add(bookName);
        }
        model.addAttribute("oldTestimonyBookNames", oldTestimonyBookNames);
        model.addAttribute("newTestimonyBookNames", newTestimonyBookNames);
        return "navigator";
    }

    @PostMapping("")
    public String getNavigationPageWithQueryParams(
            @RequestParam String bookName,
            @RequestParam int chapterNo) {
        return "redirect:verse/" + bookName.toLowerCase() + '/' + chapterNo;
    }

    @GetMapping("/{bookNameInString}/{chapterNo}")
    public String getChapter(
            @PathVariable String bookNameInString,
            @PathVariable int chapterNo,
            Model model,
            RedirectAttributes redirectAttrs) {
        BookName foundBookName = findBookName(bookNameInString);
        try {
            Book book = memoryBibleRepository.getBook(foundBookName);
            Chapter foundChapter = book.getChapter(chapterNo);
            if (foundChapter == null) throw new IllegalArgumentException();
        } catch(Exception e) {
            return redirectToNavigator(redirectAttrs);
        }
        processGetChapter(model, foundBookName, chapterNo);
        return "basic/typing";
    }

    private void processGetChapter(Model model, BookName bookName, int chapterNo) {
        Chapter chapter = memoryBibleRepository.getChapter(bookName, chapterNo);
        String chapterId = ChapterIdResolver.get(bookName, chapter.getChapterNo());
        model.addAttribute("chapterId", chapterId);
        model.addAttribute("chapter", chapter);
        model.addAttribute("prevUrl", UrlResolver.getPrevUrl(bookName, chapterNo));
        model.addAttribute("nextUrl", UrlResolver.getNextUrl(bookName, chapterNo));
    }

    private String redirectToNavigator(RedirectAttributes redirectAttrs) {
        redirectAttrs.addFlashAttribute("message", "잘못된 접근입니다.");
        return "redirect:/verse";
    }
}