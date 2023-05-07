package typer.bible.repository;

import typer.bible.domain.Book;
import typer.bible.domain.Verse;

import java.util.List;

public interface VerseRepository {

    Verse findById(int id);
    List<Verse> findByChapter(int chapterNo);
    List<Verse> findByBookName(Book bookName);
}
