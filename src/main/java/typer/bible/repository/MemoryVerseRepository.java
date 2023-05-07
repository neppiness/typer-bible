package typer.bible.repository;

import typer.bible.domain.Book;
import typer.bible.domain.Verse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class MemoryVerseRepository implements VerseRepository {

    static HashMap<Integer, Verse> store;

    MemoryVerseRepository() {
        try {
            store = new VerseRepositoryInitializer().getStoreInstance();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
