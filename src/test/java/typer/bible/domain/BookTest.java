package typer.bible.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BookTest {

    static List<BookName> bookNames = List.of(BookName.GENESIS, BookName.GENESIS, BookName.GENESIS);
    static List<Integer> chapterNos = List.of(1, 2, 3);
    static List<Integer> verseNos = List.of(1, 1, 1);

    static List<List<String>> texts = List.of(
            List.of("<천지 창조> 태초에 하나님이 천지를 창조하시니라"),
            List.of("천지와 만물이 다 이루어지니라"),
            List.of("<사람의 불순종과 하나님의 심판 선언> 그런데 뱀은 여호와 하나님이 지으신 들짐승 중에 가장",
                    "간교하니라 뱀이 여자에게 물어 이르되 하나님이 참으로 너희에게 동산 모든 나무의 열매를 먹지 말라",
                    "하시더냐")
    );

    static List<Chapter> chapters;
    static Book book;

    @BeforeAll
    static void beforeAll() {
        chapters = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            List<Verse> verses = new ArrayList<>();
            verses.add(new Verse(1, texts.get(i)));
            chapters.add(new Chapter(i + 1, verses));
        }
        book = new Book(BookName.GENESIS, chapters);
    }

    @Test
    void getChapterTest() {
        for (int index = 0; index < 3; index++) {
            Chapter foundChapter = book.getChapter(index + 1);
            Verse verseOfFoundChapter = foundChapter.getVerses().get(0);
            assertThat(verseOfFoundChapter.getVerseNo()).isEqualTo(verseNos.get(index));
            assertThat(verseOfFoundChapter.getTexts()).isEqualTo(texts.get(index));
        }
    }

    @Test
    void getNoOfChapters() {
        int noOfChapters = book.getNoOfChapters();
        assertThat(noOfChapters).isEqualTo(3);
    }
}