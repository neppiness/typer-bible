package typer.bible.repository.util;

import org.junit.jupiter.api.Test;
import typer.bible.domain.BookName;
import typer.bible.domain.Verse;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class VerseCollectorTest {

    List<String> textInNormalPattern = List.of("삼하2:3 또 자기와 함께 한 추종자들과 그들의 가족들을 다윗이 다 데리고" +
            " 올라가서 헤브론 각 성읍에 살게 하니라");

    List<String> textInAltPattern = List.of("삼하2:어떤 사람이 다윗에게 말하여 이르되 사울을 장사한 사람은 길르앗 야베스" +
            " 사람들이니이다 하매");

    @Test
    void getVersesWithNormalPatternTest() {
        List<Verse> verses = VerseCollector.getVerses(textInNormalPattern);
        for (Verse verse : verses) {
            assertThat(verse.getBookName()).isEqualTo(BookName.SAMUEL2);
            assertThat(verse.getChapterNo()).isEqualTo(2);
            assertThat(verse.getVerseNo()).isEqualTo(3);
            assertThat(verse.getText()).isEqualTo("또 자기와 함께 한 추종자들과 그들의 가족들을 다윗이 다 데리고" +
                    " 올라가서 헤브론 각 성읍에 살게 하니라");
        }
    }

    @Test
    void getsVersesWithAltPatternTest() {
        List<Verse> verses = VerseCollector.getVerses(textInAltPattern);
        for (Verse verse : verses) {
            assertThat(verse.getBookName()).isEqualTo(BookName.SAMUEL2);
            assertThat(verse.getChapterNo()).isEqualTo(2);
            assertThat(verse.getVerseNo()).isEqualTo(0);
            assertThat(verse.getText()).isEqualTo("어떤 사람이 다윗에게 말하여 이르되 사울을 장사한 사람은 길르앗" +
                    " 야베스 사람들이니이다 하매");
        }
    }
}