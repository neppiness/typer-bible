package typer.bible.repository;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import typer.bible.domain.BookName;
import typer.bible.domain.Verse;
import typer.bible.repository.util.VerseRepositoryInitializer;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Slf4j
public class MemoryVerseRepository implements VerseRepository {

    static HashMap<Integer, Verse> store;

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
    public Optional<Verse> findById(int id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Verse> findByChapter(int chapterNo) {
        // TODO: implement method
        return null;
    }

    @Override
    public List<Verse> findByBookName(BookName bookName) {
        // TODO: implement method
        return null;
    }
}
