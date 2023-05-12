package typer.bible.service;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import typer.bible.domain.Book;
import typer.bible.repository.MemoryVerseRepository;

@RestController
public class VerseController {

    MemoryVerseRepository memoryVerseRepository = new MemoryVerseRepository();

    @GetMapping("/verseId/{id}")
    public String getVerseById(@PathVariable int id) {
        return memoryVerseRepository.findById(id).get().getText();
    }

    @GetMapping("/{bookName}/{chapterNo}")
    public String getVersesByBookAndChapterNo(@PathVariable String bookName, @PathVariable int chapterNo) {
        Book foundBook = Book.GENESIS;
        for (Book book : Book.values()) {
            if (!book.toString().equals(bookName.toUpperCase()))
                continue;
            foundBook = book;
        }
        return foundBook + ": " + chapterNo + "장";
    }
}
