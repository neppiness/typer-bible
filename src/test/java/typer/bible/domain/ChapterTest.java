package typer.bible.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ChapterTest {

    static List<List<String>> malachiChapter4Texts = List.of(
            List.of("<여호와께서 정하신 날> 만군의 여호와가 이르노라 보라 용광로 불 같은 날이 이르리니 교만한 자와 악을 행하는",
                    "자는 다 지푸라기 같을 것이라 그 이르는 날에 그들을 살라 그 뿌리와 가지를 남기지 아니할 것이로되"),
            List.of("내 이름을 경외하는 너희에게는 공의로운 해가 떠올라서 치료하는 광선을 비추리니 너희가 나가서 외양간에서 나온",
                    "송아지 같이 뛰리라"),
            List.of("또 너희가 악인을 밟을 것이니 그들이 내가 정한 날에 너희 발바닥 밑에 재와 같으리라 만군의 " +
                    "여호와의 말이니라"),
            List.of("너희는 내가 호렙에서 온 이스라엘을 위하여 내 종 모세에게 명령한 법 곧 율례와 법도를 기억하라"),
            List.of("보라 여호와의 크고 두려운 날이 이르기 전에 내가 선지자 엘리야를 너희에게 보내리니"),
            List.of("그가 아버지의 마음을 자녀에게로 돌이키게 하고 자녀들의 마음을 그들의 아버지에게로 돌이키게 하리라 돌이키지",
                    "아니하면 두렵건대 내가 와서 저주로 그 땅을 칠까 하노라 하시니라")
    );

    static Chapter malachiChapter4;

    @BeforeAll
    static void beforeAll() {
        List<Verse> verses = new ArrayList<>();
        int verseNo = 1;
        for (List<String> texts : malachiChapter4Texts)
            verses.add(new Verse(verseNo++, texts));
        malachiChapter4 = new Chapter(4, verses);
    }

    @Test
    void getChapterNo() {
        assertThat(malachiChapter4.getChapterNo()).isEqualTo(4);
    }

    @Test
    void getVerses() {
        List<Verse> verses = malachiChapter4.getVerses();
        for (int index = 0; index < 6; index++) {
            List<String> text = malachiChapter4Texts.get(index);
            Verse verse = verses.get(index);
            assertThat(verse.getTexts()).isEqualTo(text);
        }
    }

    @Test
    void printVerses() {
        List<Verse> verses = malachiChapter4.getVerses();
        verses.forEach(verse -> System.out.println(verse.toString()));
    }
}