package typer.bible.repository;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import typer.bible.domain.Book;
import typer.bible.domain.BookName;
import typer.bible.domain.Chapter;
import typer.bible.repository.util.VerseRepositoryInitializer;

import java.util.HashMap;
import java.util.List;

@Slf4j
public class MemoryVerseRepository implements VerseRepository {

    static HashMap<BookName, Book> store; // Newly Updated one

    public MemoryVerseRepository() {
        try {
            if (store == null) store = VerseRepositoryInitializer.getStoreInstance();
        } catch (Exception e) {
            Logger logger = LoggerFactory.getLogger(MemoryVerseRepository.class);
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book findBook(BookName bookName) {
        return store.get(bookName);
    }

    @Override
    public List<String> findBookTexts(BookName bookName) {
        Book foundBook = findBook(bookName);
        return foundBook.getAllVerses();
    }

    @Override
    public List<String> findChapterTexts(BookName bookName, int chapterNo) {
        Book foundBook = findBook(bookName);
        Chapter foundChapter = foundBook.findChapterByNo(chapterNo);
        return foundBook.getAllVerses();
    }

    @Override
    public String findVerseText(BookName bookName, int chapterNo, int verseNo) {
        Book foundBook = findBook(bookName);
        Chapter foundChapter = foundBook.findChapterByNo(chapterNo);
        return foundChapter.findVerseByNo(verseNo).getText();
    }
}