package typer.bible.service;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import typer.bible.domain.BookName;
import typer.bible.repository.MemoryVerseRepository;

@Controller
public class VerseController {

    MemoryVerseRepository memoryVerseRepository = new MemoryVerseRepository();

    @GetMapping("/verseId/{id}")
    public String getVerseById(@PathVariable int id) {
        return memoryVerseRepository.findById(id).get().getText();
    }

    @GetMapping("/{bookName}/{chapterNo}")
    public String getVersesByBookAndChapterNo(@PathVariable String bookName, @PathVariable int chapterNo) {
        BookName foundBookName = BookName.GENESIS;
        for (BookName book : BookName.values()) {
            if (!book.toString().equals(bookName.toUpperCase()))
                continue;
            foundBookName = book;
        }
        return foundBookName + ": " + chapterNo + "장";
    }
}
