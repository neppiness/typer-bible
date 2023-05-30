package typer.bible.repository.util;

import org.junit.jupiter.api.Test;
import typer.bible.domain.Book;
import typer.bible.domain.BookName;
import typer.bible.domain.Chapter;
import typer.bible.domain.Verse;
import typer.bible.domain.util.VerseDTO;
import typer.bible.repository.MemoryBibleRepository;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.*;

class TextParserTest {

    final static MemoryBibleRepository memoryBibleRepository = MemoryBibleRepository.getInstance();

    static String normalPatternInput
            = "창29:24 라반이 또 그의 여종 실바를 그의 딸 레아에게 시녀로 주었더라";
    static String altPatternInput
            = "삼하2:어떤 사람이 다윗에게 말하여 이르되 사울을 장사한 사람은 길르앗 야베스 사람들이니이다 하매";
    static String problematicInput
            = "눅23:계명을 <살아나시다(마 28:1-10; 막 16:1-8; 요 20:1-10)> 따라 안식일에 쉬더라";
    static String invalidInput
            = "창세기29:12 그에게 자기가 그의 아버지의 생질이요 리브가의 아들 됨을 말하였더니 라헬이 달려가서 그 아버지에게 알리매";

    static Pattern normalPattern = Pattern.compile("([0-9]+:[0-9]+)");
    static Pattern altPattern = Pattern.compile("([0-9]+:)");

    @Test
    void regexNormalPatternMatchTest() {
        Matcher matcher = normalPattern.matcher(normalPatternInput);
        assertThat(matcher.find()).isTrue();
    }

    @Test
    void regexAltPatternMatchTest() {
        Matcher matcher = altPattern.matcher(altPatternInput);
        assertThat(matcher.find()).isTrue();
    }

    @Test
    void setNormalPatternInputConversionTest() {
        List<VerseDTO> verseDTOS = TextParser.convertToVerseDTOs(List.of(normalPatternInput));
        VerseDTO verseDTO = verseDTOS.get(0);
        assertThat(verseDTO.getBookName()).isEqualTo(BookName.GENESIS);
        assertThat(verseDTO.getChapterNo()).isEqualTo(29);
        assertThat(verseDTO.getVerseNo()).isEqualTo(24);
        assertThat(verseDTO.getTexts()).isEqualTo(List.of("라반이 또 그의 여종 실바를 그의 딸 레아에게 시녀로 주었더라"));
    }

    @Test
    void altPatternInputConversionTest() {
        List<VerseDTO> verseDTOS = TextParser.convertToVerseDTOs(List.of(altPatternInput));
        VerseDTO verseDTO = verseDTOS.get(0);
        assertThat(verseDTO.getBookName()).isEqualTo(BookName.SAMUEL2);
        assertThat(verseDTO.getChapterNo()).isEqualTo(2);
        assertThat(verseDTO.getVerseNo()).isEqualTo(0);
        assertThat(verseDTO.getTexts()).isEqualTo(
                List.of("어떤 사람이 다윗에게 말하여 이르되 사울을 장사한 사람은 길르앗 야베스 사람들이니이다 하매")
        );
    }

    @Test
    void problematicInputConversionTest() {
        List<VerseDTO> verseDTOS = TextParser.convertToVerseDTOs(List.of(problematicInput));
        VerseDTO verseDTO = verseDTOS.get(0);
        assertThat(verseDTO.getBookName()).isEqualTo(BookName.LUKE);
        assertThat(verseDTO.getChapterNo()).isEqualTo(23);
        assertThat(verseDTO.getVerseNo()).isEqualTo(0);
        assertThat(verseDTO.getTexts()).isEqualTo(List.of(
                "계명을 <살아나시다(마 28:1-10; 막 16:1-8; 요 20:1-10)> 따라 안식일에", "쉬더라")
        );
    }

    @Test
    void allTextLengthTest() {
        String maxLengthText = null;
        int maxLength = 0;
        for (BookName bookName : BookName.values()) {
            Book foundBook = memoryBibleRepository.getBook(bookName);
            String foundText = getLongestText(foundBook);
            if (maxLengthText == null) maxLengthText = foundText;
            if (maxLengthText.length() < foundText.length()) maxLengthText = foundText;
        }
        if (maxLengthText != null)
            System.out.println(maxLengthText);
    }

    String getLongestText(Book book) {
        int maxChapterNo = book.getNoOfChapters();
        String maxLengthText = null;
        int maxLength = 0;
        for (int no = 1; no <= maxChapterNo; no++) {
            Chapter chapter = book.getChapter(no);
            for (Verse verse : chapter.getVerses()) {
                for (String text : verse.getTexts()) {
                    assertThat(text.length()).isLessThanOrEqualTo(TextParser.characterNoLimit);
                    if (maxLength >= text.length()) continue;
                    maxLength = text.length();
                    maxLengthText = text;
                }
            }
        }
        return maxLengthText;
    }

    @Test
    void invalidInputConversionTest() {
        assertThatThrownBy(() -> TextParser.convertToVerseDTOs(List.of(invalidInput)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
