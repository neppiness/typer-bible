package typer.bible.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class VerseTest {

    static Verse daniel_3_8, psalms_150_6;

    @BeforeAll
    static void beforeAll() {
        daniel_3_8 = new Verse(
                BookName.DANIEL, 3, 8,
                "<다니엘의 세 친구> 그 때에 어떤 갈대아 사람들이 나아와 유다 사람들을 참소하니라"
        );

        psalms_150_6 = new Verse(
                BookName.PSALMS, 150, 6,
                "호흡이 있는 자마다 여호와를 찬양할지어다 할렐루야"
        );
    }

    @Test
    void VerseConstructorTest1() {
        assertThat(daniel_3_8.getBookName()).isEqualTo(BookName.DANIEL);
        assertThat(daniel_3_8.getChapterNo()).isEqualTo(3);
        assertThat(daniel_3_8.getChapterUnit()).isEqualTo("장");
        assertThat(daniel_3_8.getVerseNo()).isEqualTo(8);
        assertThat(daniel_3_8.getText())
                .isEqualTo("<다니엘의 세 친구> 그 때에 어떤 갈대아 사람들이 나아와 유다 사람들을 참소하니라");
    }

    @Test
    void VerseConstructorTest2() {
        assertThat(psalms_150_6.getBookName()).isEqualTo(BookName.PSALMS);
        assertThat(psalms_150_6.getChapterNo()).isEqualTo(150);
        assertThat(psalms_150_6.getChapterUnit()).isEqualTo("편");
        assertThat(psalms_150_6.getVerseNo()).isEqualTo(6);
        assertThat(psalms_150_6.getText())
                .isEqualTo("호흡이 있는 자마다 여호와를 찬양할지어다 할렐루야");
    }

    @Test
    void getChapterUnitTest1() {
        for (BookName bookName : BookName.values()) {
            if (bookName == BookName.PSALMS) continue;
            Verse verse = new Verse(bookName, 1, 1, "text to test");
            assertThat(verse.getChapterUnit()).isEqualTo("장");
        }
    }
    @Test
    void getChapterUnitTest2() {
        Verse verse = new Verse(BookName.PSALMS, 1, 1, "text to test");
        assertThat(verse.getChapterUnit()).isEqualTo("편");
    }

    @Test
    void toStringTest1() {
        System.out.println(daniel_3_8.toString());
        System.out.println(psalms_150_6.toString());
    }
}