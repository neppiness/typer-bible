package typer.bible.repository;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import typer.bible.domain.Book;
import typer.bible.domain.BookName;
import typer.bible.domain.Chapter;
import typer.bible.repository.util.BookGenerator;

import java.io.IOException;
import java.util.HashMap;

@Slf4j
public class MemoryBibleRepository implements VerseRepository {

    private static MemoryBibleRepository instance;
    final private static HashMap<BookName, Book> bible = new HashMap<>();

    private MemoryBibleRepository() {
        try {
            for (BookName bookName : BookName.values())
                bible.put(bookName, BookGenerator.getBook(bookName));
        } catch (IOException e) {
            Logger logger = LoggerFactory.getLogger(MemoryBibleRepository.class);
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Chapter getChapter(BookName bookName, int chapterNo) {
        Book book = bible.get(bookName);
        return book.getChapter(chapterNo);
    }

    @Override
    public Book getBook(BookName bookName) {
        return bible.get(bookName);
    }

    public static MemoryBibleRepository getInstance() {
        if (instance == null) instance = new MemoryBibleRepository();
        return instance;
    }
}