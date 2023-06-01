package typer.bible.repository.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import typer.bible.domain.Chapter;
import typer.bible.domain.Verse;
import typer.bible.domain.util.VerseDTO;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ChapterDividerTest {

    static List<Chapter> setChapters, divideResult;
    static List<VerseDTO> verseDTOs;

    static List<String> rawTexts = List.of(
            "룻1:1 <엘리멜렉과 그 가족의 모압 이주> 사사들이 치리하던 때에 그 땅에 흉년이 드니라 유다 베들레헴에 한 사람이 그의 " +
                    "아내와 두 아들을 데리고 모압 지방에 가서 거류하였는데",
            "룻2:1 <룻이 보아스를 만나다> 나오미의 남편 엘리멜렉의 친족으로 유력한 자가 있으니 그의 이름은 보아스더라",
            "룻3:1 <룻이 보아스와 가까워지다> 룻의 시어머니 나오미가 그에게 이르되 내 딸아 내가 너를 위하여 안식할 곳을 구하여 " +
                    "너를 복되게 하여야 하지 않겠느냐",
            "룻4:1 <룻이 보아스와 결혼하다> 보아스가 성문으로 올라가서 거기 앉아 있더니 마침 보아스가 말하던 기업 무를 자가 " +
                    "지나가는지라 보아스가 그에게 이르되 아무개여 이리로 와서 앉으라 하니 그가 와서 앉으매"
    );

    static List<String> verseFullTexts = List.of(
            "<엘리멜렉과 그 가족의 모압 이주> 사사들이 치리하던 때에 그 땅에 흉년이 드니라 유다 베들레헴에 한 사람이 그의 " +
                    "아내와 두 아들을 데리고 모압 지방에 가서 거류하였는데",
            "<룻이 보아스를 만나다> 나오미의 남편 엘리멜렉의 친족으로 유력한 자가 있으니 그의 이름은 보아스더라",
            "<룻이 보아스와 가까워지다> 룻의 시어머니 나오미가 그에게 이르되 내 딸아 내가 너를 위하여 안식할 곳을 구하여 " +
                    "너를 복되게 하여야 하지 않겠느냐",
            "<룻이 보아스와 결혼하다> 보아스가 성문으로 올라가서 거기 앉아 있더니 마침 보아스가 말하던 기업 무를 자가 " +
                    "지나가는지라 보아스가 그에게 이르되 아무개여 이리로 와서 앉으라 하니 그가 와서 앉으매"
    );

    @BeforeAll
    static void beforeAll() {
        setChapters = new ArrayList<>();
        verseDTOs = TextParser.convertToVerseDTOs(rawTexts);
        verseDTOs.forEach(verseDTO -> {
            setChapters.add(
                    new Chapter(verseDTO.getChapterNo(), List.of(verseDTO.toVerse()))
            );
        });
    }

    @Test
    void divideTest() {
        divideResult = ChapterDivider.divide(verseDTOs);
        int chapterNo = 1;
        for (Chapter chapter : divideResult) {
            assertThat(chapter.getChapterNo()).isEqualTo(chapterNo);
            Verse verse = chapter.getVerses().get(0);
            String verseFullText = verseFullTexts.get(chapterNo - 1);
            verse.getTexts().forEach(
                    text -> {
                        assertThat(verseFullText.indexOf(text)).isNotEqualTo(-1);
                        System.out.println("text = " + text);
                    }
            );
            chapterNo++;
        }
    }
}