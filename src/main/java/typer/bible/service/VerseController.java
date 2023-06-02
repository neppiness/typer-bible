package typer.bible.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        BookName foundBookName = findBookName(bookName);
        if (foundBookName == null) return "index";
        return "redirect:verse/" + foundBookName.toString().toLowerCase() + '/' + chapterNo;
    }

    @GetMapping("/{bookNameInString}/{chapterNo}")
    public String getChapter(
            @PathVariable String bookNameInString,
            @PathVariable int chapterNo,
            Model model) {
        BookName foundBookName = findBookName(bookNameInString);
        if (foundBookName == null) return "index";
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
}