package typer.bible.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ChapterTest {

    static List<String> genesisFirstThreeVerses = new ArrayList<>(Arrays.asList(
            "창1:1 <천지 창조> 태초에 하나님이 천지를 창조하시니라",
            "창1:2 땅이 혼돈하고 공허하며 흑암이 깊음 위에 있고 하나님의 영은 수면 위에 운행하시니라",
            "창1:3 하나님이 이르시되 빛이 있으라 하시니 빛이 있었고"
    ));
    static List<Verse> verses = new ArrayList<>();
    static Chapter chapter;

    @BeforeAll
    static void beforeAll() {
        for (int verseNo = 1; verseNo <= 3; verseNo++) {
            verses.add(new Verse(BookName.GENESIS, 1, verseNo,
                    genesisFirstThreeVerses.get(verseNo - 1) ));
        }
        chapter = new Chapter(verses);
    }

    @Test()
    void findVerseByNoTest() {
        Verse thirdVerse = verses.get(2);
        Verse foundVerse = chapter.findVerseByNo(3);
        assertThat(thirdVerse).isEqualTo(foundVerse);
    }

    @Test
    void getAllVersesTest() {
        List<String> foundTexts = chapter.getAllVerses();
        for (int i = 0; i < 3; i++) {
            String foundText = foundTexts.get(i);
            String genesisText = genesisFirstThreeVerses.get(i);
            assertThat(foundText).isEqualTo(genesisText);

            System.out.println("foundText = " + foundText);
            System.out.println("genesisText = " + genesisText);
            System.out.println();
        }
    }
}