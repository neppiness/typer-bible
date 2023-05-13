package typer.bible.repository;

import typer.bible.domain.Book;
import typer.bible.domain.BookName;

import java.util.List;

public interface VerseRepository {

    Book findBook(BookName bookName);
    List<String> findBookTexts(BookName bookName);
    List<String> findChapterTexts(BookName bookName, int chapterNo);
    String findVerseText(BookName bookName, int chapterNo, int verseNo);
}
