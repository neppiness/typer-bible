package typer.bible.repository;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import typer.bible.domain.Book;
import typer.bible.domain.BookName;
import typer.bible.domain.Verse;
import typer.bible.repository.util.BookGenerator;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Slf4j
public class MemoryBibleRepository implements VerseRepository {

    final static HashMap<BookName, Book> bible = new HashMap<>();

    public MemoryBibleRepository() {
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
    public List<Verse> getVerses(BookName bookName) {
        Book book = getBook(bookName);
        return book.getAllVerses();
    }

    @Override
    public List<Verse> getVerses(BookName bookName, int chapterNo) {
        Book book = getBook(bookName);
        return book.find(chapterNo);
    }

    @Override
    public List<Verse> getVerses(BookName bookName, int chapterNo, int verseNo) {
        Book book = getBook(bookName);
        return book.find(chapterNo, verseNo);
    }

    private Book getBook(BookName bookName) {
        return bible.get(bookName);
    }
}