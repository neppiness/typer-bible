package typer.bible.repository;

import typer.bible.domain.BookName;
import typer.bible.domain.Verse;

import java.util.List;
import java.util.Optional;

public interface VerseRepository {

    Optional<Verse> findById(int id);
    List<Verse> findByChapter(int chapterNo);
    List<Verse> findByBookName(BookName bookName);
}
