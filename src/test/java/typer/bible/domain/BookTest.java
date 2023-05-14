package typer.bible.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BookTest {

    static List<String> genesisFirstThreeChapterFirstVerses = new ArrayList<>(Arrays.asList(
            "창1:1 <천지 창조> 태초에 하나님이 천지를 창조하시니라",
            "창2:1 천지와 만물이 다 이루어지니라",
            "창3:1 <사람의 불순종과 하나님의 심판 선언> 그런데 뱀은 여호와 하나님이 지으신 들짐승 중에 가장 간교하니라 "
                    + "뱀이 여자에게 물어 이르되 하나님이 참으로 너희에게 동산 모든 나무의 열매를 먹지 말라 하시더냐"
    ));
    static List<Chapter> chapters = new ArrayList<>();
    static Book book;

    @BeforeAll
    static void beforeAll() {
        for (int i = 1; i <= 3; i++) {
            Verse verse = new Verse(BookName.GENESIS, i, 1, genesisFirstThreeChapterFirstVerses.get(i - 1));
            List<Verse> verses = new ArrayList<>();
            verses.add(verse);
            chapters.add(new Chapter(verses));
        }
        book = new Book(BookName.GENESIS, chapters);
    }

    @Test
    void initTest() {
        assertThat(book.noOfChapters).isEqualTo(chapters.size());
    }

    @Test
    void findChapterByNoTest() {
        for (int noOfChapter = 1; noOfChapter <= 3; noOfChapter++) {
            Chapter foundChapter = book.findChapterByNo(noOfChapter);
            assertThat(foundChapter).isEqualTo(chapters.get(noOfChapter - 1));
        }
    }

    @Test
    void getAllVersesTest() {
        List<String> allVersesInBook = book.getAllVerses();
        for (int idx = 0; idx < 3; idx++) {
            String text = allVersesInBook.get(idx);
            assertThat(text).isEqualTo(genesisFirstThreeChapterFirstVerses.get(idx));
        }
    }
}