package typer.bible.repository;

import typer.bible.domain.Book;
import typer.bible.domain.Verse;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class MemoryVerseRepository implements VerseRepository {

    static final HashMap<Integer, Verse> store = new HashMap<>();

    MemoryVerseRepository() {
        initialize();
    }

    @Override
    public void initialize() {
        // TODO: implement method to get files and save verses to store
    }

    @Override
    public Optional<Verse> findById(int id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Verse> findByChapter(int chapterNo) {
        // TODO: implement method
        return null;
    }

    @Override
    public List<Verse> findByBookName(Book bookName) {
        // TODO: implement method
        return null;
    }
}
