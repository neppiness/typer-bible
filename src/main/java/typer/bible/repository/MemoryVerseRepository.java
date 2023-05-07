package typer.bible.repository;

import typer.bible.domain.Book;
import typer.bible.domain.Verse;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class MemoryVerseRepository implements VerseRepository {

    static HashMap<Integer, Verse> store = new HashMap<>();
    static int sequence = 1;

    @Override
    public void save(Verse verse) {
        store.put(sequence++, verse);
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
