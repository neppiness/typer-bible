package typer.bible.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.*;

class VerseTest {

    static Verse daniel_3_8, psalms_150_6, randomVerseNo1;

    static List<String> daniel_3_8_texts
            = List.of("<다니엘의 세 친구> 그 때에 어떤 갈대아 사람들이 나아와 유다 사람들을 참소하니라");
    static List<String> psalms_150_6_texts
            = List.of("호흡이 있는 자마다 여호와를 찬양할지어다 할렐루야");
    static List<String> randomTexts
            = List.of("매일", "당신을", "두렵게", "만드는 일을", "하나씩 하라.");

    @BeforeAll
    static void beforeAll() {
        daniel_3_8 = new Verse(8, daniel_3_8_texts);
        psalms_150_6 = new Verse(6, psalms_150_6_texts);
        randomVerseNo1 = new Verse(1, randomTexts);
    }

    @Test
    void verseConstructorTest1() {
        assertThat(daniel_3_8.getVerseNo()).isEqualTo(8);
        assertThat(daniel_3_8.getTexts())
                .isEqualTo(List.of("<다니엘의 세 친구> 그 때에 어떤 갈대아 사람들이 나아와 유다 사람들을 참소하니라"));
    }

    @Test
    void verseConstructorTest2() {
        assertThat(psalms_150_6.getVerseNo()).isEqualTo(6);
        assertThat(psalms_150_6.getTexts())
                .isEqualTo(List.of("호흡이 있는 자마다 여호와를 찬양할지어다 할렐루야"));
    }

    @Test
    void verseConstructorTest3() {
        assertThat(randomVerseNo1.getVerseNo()).isEqualTo(1);
        assertThat(randomVerseNo1.getTexts())
                .isEqualTo(List.of("매일", "당신을", "두렵게", "만드는 일을", "하나씩 하라."));
    }

    @Test
    void toStringTest1() {
        String daniel_3_8InString = daniel_3_8.toString();
        assertThat(daniel_3_8InString)
                .isEqualTo("8절: <다니엘의 세 친구> 그 때에 어떤 갈대아 사람들이 " +
                        "나아와 유다 사람들을 참소하니라");
        System.out.println(daniel_3_8InString);
    }

    @Test
    void toStringTest2() {
        String psalms_150_6InString = psalms_150_6.toString();
        assertThat(psalms_150_6InString)
                .isEqualTo("6절: 호흡이 있는 자마다 여호와를 찬양할지어다 할렐루야");
        System.out.println(psalms_150_6InString);
    }

    @Test
    void toStringTest3() {
        String randomVerseNo1InString = randomVerseNo1.toString();
        assertThat(randomVerseNo1InString)
                .isEqualTo("1절: 매일 당신을 두렵게 만드는 일을 하나씩 하라.");
        System.out.println(randomVerseNo1InString);
    }
}