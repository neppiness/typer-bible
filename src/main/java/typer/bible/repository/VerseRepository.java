package typer.bible.repository;

import typer.bible.domain.BookName;
import typer.bible.domain.Verse;

import java.util.List;

public interface VerseRepository {

    List<Verse> getVerses(BookName bookName);
    List<Verse> getVerses(BookName bookName, int chapterNo);
    List<Verse> getVerses(BookName bookName, int chapterNo, int verseNo);
}
