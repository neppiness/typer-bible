package typer.bible.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import typer.bible.domain.BookName;
import typer.bible.domain.Verse;
import typer.bible.repository.MemoryBibleRepository;

import java.util.List;

@Controller
@RequestMapping("/verse")
public class VerseController {

    MemoryBibleRepository memoryBibleRepository = new MemoryBibleRepository();

    @GetMapping("/{bookName}")
    public String getVersesByBookName(@PathVariable String bookName, Model model) {
        BookName foundBookName = findBookName(bookName);
        List<Verse> verses = memoryBibleRepository.getVerses(foundBookName);
        model.addAttribute("verses", verses);
        return "basic/form";
    }

    @GetMapping("/{bookName}/{chapterNo}")
    public String getVersesByBookAndChapterNo(
            @PathVariable String bookName,
            @PathVariable int chapterNo,
            Model model) {
        BookName foundBookName = findBookName(bookName);
        List<Verse> verses = memoryBibleRepository.getVerses(foundBookName, chapterNo);
        model.addAttribute("verses", verses);
        return "basic/form";
    }

    @GetMapping("/{bookName}/{chapterNo}/{verseNo}")
    public String getVerseById(
            @PathVariable String bookName,
            @PathVariable int chapterNo,
            @PathVariable int verseNo,
            Model model) {
        BookName foundBookName = findBookName(bookName);
        List<Verse> verses = memoryBibleRepository.getVerses(foundBookName, chapterNo, verseNo);
        model.addAttribute("verses", verses);
        return "basic/form";
    }

    private BookName findBookName(String bookNameInString) {
        for (BookName book : BookName.values())
            if (book.toString().equals(bookNameInString.toUpperCase()))
                return book;
        return null;
    }
}
