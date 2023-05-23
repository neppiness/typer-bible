package typer.bible.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.*;

class VerseTest {

    static Verse daniel_3_8, psalms_150_6;

    static List<String> daniel_3_8_texts
            = List.of("<다니엘의 세 친구> 그 때에 어떤 갈대아 사람들이 나아와 유다", "사람들을 참소하니라");
    static List<String> psalms_150_6_texts
            = List.of("호흡이 있는 자마다 여호와를 찬양할지어다 할렐루야");

    @BeforeAll
    static void beforeAll() {
        daniel_3_8 = new Verse(BookName.DANIEL, 3, 8, daniel_3_8_texts);
        psalms_150_6 = new Verse(BookName.PSALMS, 150, 6, psalms_150_6_texts);
    }

    @Test
    void VerseConstructorTest1() {
        assertThat(daniel_3_8.getBookName()).isEqualTo(BookName.DANIEL);
        assertThat(daniel_3_8.getChapterNo()).isEqualTo(3);
        assertThat(daniel_3_8.getVerseNo()).isEqualTo(8);
        assertThat(daniel_3_8.getVerseId()).isEqualTo("3장 8절");
        assertThat(daniel_3_8.getTexts())
                .isEqualTo(daniel_3_8_texts);
    }

    @Test
    void VerseConstructorTest2() {
        assertThat(psalms_150_6.getBookName()).isEqualTo(BookName.PSALMS);
        assertThat(psalms_150_6.getChapterNo()).isEqualTo(150);
        assertThat(psalms_150_6.getVerseNo()).isEqualTo(6);
        assertThat(psalms_150_6.getVerseId()).isEqualTo("150편 6절");
        assertThat(psalms_150_6.getTexts())
                .isEqualTo(List.of("호흡이 있는 자마다 여호와를 찬양할지어다 할렐루야"));
    }

    @Test
    void toStringTest1() {
        System.out.println(daniel_3_8.toString());
        System.out.println(psalms_150_6.toString());
    }
}