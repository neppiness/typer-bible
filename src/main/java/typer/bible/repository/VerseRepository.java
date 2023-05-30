package typer.bible.repository;

import typer.bible.domain.Book;
import typer.bible.domain.BookName;
import typer.bible.domain.Chapter;
import typer.bible.domain.Verse;

import java.util.List;

public interface VerseRepository {

    Chapter getChapter(BookName bookName, int chapterNo);
    Book getBook(BookName bookName);
}
