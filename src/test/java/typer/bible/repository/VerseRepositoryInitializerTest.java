package typer.bible.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import typer.bible.domain.Verse;

import java.io.IOException;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.*;

class VerseRepositoryInitializerTest {

    static HashMap<Integer, Verse> store;

    @BeforeAll
    static void beforeAll() throws IOException {
        store = VerseRepositoryInitializer.getStoreInstance();
    }

    @Test
    void lastVerseTest() {
        int lastId = store.size();
        String lastVerseText = store.get(lastId).getText();
        assertThat(lastVerseText).isEqualTo("계22:21 주 예수의 은혜가 모든 자들에게 있을지어다 아멘");
    }
}