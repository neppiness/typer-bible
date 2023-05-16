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
    public Book findBook(BookName bookName) {
        return bible.get(bookName);
    }

    @Override
    public List<String> findBookTexts(BookName bookName) {
        Book foundBook = findBook(bookName);
        return foundBook.getAllVerseTexts();
    }

    @Override
    public List<String> findChapterTexts(BookName bookName, int chapterNo) {
        Book foundBook = findBook(bookName);
        Chapter foundChapter = foundBook.findChapterByNo(chapterNo);
        return foundChapter.getAllVerseTexts();
    }

    @Override
    public String findVerseText(BookName bookName, int chapterNo, int verseNo) {
        Book foundBook = findBook(bookName);
        Chapter foundChapter = foundBook.findChapterByNo(chapterNo);
        return foundChapter.findVerseByNo(verseNo).getText();
    }
}