package typer.bible.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import typer.bible.domain.BookName;
import typer.bible.domain.Chapter;
import typer.bible.repository.MemoryBibleRepository;
import typer.bible.service.util.ChapterIdResolver;
import typer.bible.service.util.UrlResolver;

@Controller
@RequestMapping("/verse")
public class VerseController {

    final static MemoryBibleRepository memoryBibleRepository = MemoryBibleRepository.getInstance();

    @GetMapping("/{bookNameInString}/{chapterNo}")
    public String getChapter(
            @PathVariable String bookNameInString,
            @PathVariable int chapterNo,
            Model model) {
        BookName foundBookName = findBookName(bookNameInString);
        if (foundBookName == null) return "index";
        addAttributeToModel(model, foundBookName, chapterNo);
        return "basic/typing";
    }

    private void addAttributeToModel(Model model, BookName bookName, int chapterNo) {
        Chapter chapter = memoryBibleRepository.getChapter(bookName, chapterNo);
        String chapterId = ChapterIdResolver.get(bookName, chapter.getChapterNo());
        model.addAttribute("chapterId", chapterId);
        model.addAttribute("chapter", chapter);
        model.addAttribute("prevUrl", UrlResolver.getPrevUrl(bookName, chapterNo));
        model.addAttribute("nextUrl", UrlResolver.getNextUrl(bookName, chapterNo));
    }

    private BookName findBookName(String givenBookName) {
        for (BookName bookName : BookName.values()) {
            String bookNameToString = bookName.toString();
            String givenBookNameToUpperCase = givenBookName.toUpperCase();
            if (bookNameToString.equals(givenBookNameToUpperCase)) return bookName;
        }
        return null;
    }
}
