package typer.bible.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import typer.bible.domain.BookName;
import typer.bible.domain.Verse;
import typer.bible.repository.MemoryBibleRepository;
import typer.bible.service.util.UrlResolver;

import java.util.List;

@Controller
@RequestMapping("/verse")
public class VerseController {

    MemoryBibleRepository memoryBibleRepository = new MemoryBibleRepository();

    @GetMapping("/{bookName}")
    public String getVersesByBookName(@PathVariable String bookName, Model model) {
        BookName foundBookName = findBookName(bookName);
        if (foundBookName == null) foundBookName = BookName.GENESIS;
        List<Verse> verses = memoryBibleRepository.getVerses(foundBookName);
        model.addAttribute("bookName", foundBookName.inKorean);
        model.addAttribute("verses", verses);
        model.addAttribute("prevUrl", UrlResolver.getPrevUrl(foundBookName));
        model.addAttribute("nextUrl", UrlResolver.getNextUrl(foundBookName));
        return "basic/typing";
    }

    @GetMapping("/{bookName}/{chapterNo}")
    public String getVersesByBookAndChapterNo(
            @PathVariable String bookName,
            @PathVariable int chapterNo,
            Model model) {
        BookName foundBookName = findBookName(bookName);
        if (foundBookName == null) foundBookName = BookName.GENESIS;
        List<Verse> verses = memoryBibleRepository.getVerses(foundBookName, chapterNo);
        model.addAttribute("bookName", foundBookName.inKorean);
        model.addAttribute("verses", verses);
        model.addAttribute("prevUrl", UrlResolver.getPrevUrl(foundBookName, chapterNo));
        model.addAttribute("nextUrl", UrlResolver.getNextUrl(foundBookName, chapterNo));
        return "basic/typing";
    }

    private BookName findBookName(String bookNameInString) {
        for (BookName book : BookName.values())
            if (book.toString().equals(bookNameInString.toUpperCase()))
                return book;
        return null;
    }
}
