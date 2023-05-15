package typer.bible.repository.util;

import org.junit.jupiter.api.Test;
import typer.bible.domain.Book;
import typer.bible.domain.BookName;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.*;

class TextParserTest {

    final static HashMap<BookName, Book> bible = new HashMap<>();
    static List<String> rawTexts = new ArrayList<>();

    @Test
    void textParserFieldTest() {
        String testInput = "창29:24 라반이 또 그의 여종 실바를 그의 딸 레아에게 시녀로 주었더라";
        TextParser textParser = new TextParser(testInput);
        assertThat(textParser.getBookName()).isEqualTo(BookName.GENESIS);
        assertThat(textParser.getChapterNo()).isEqualTo(29);
        assertThat(textParser.getVerseNo()).isEqualTo(24);
        assertThat(textParser.getText()).isEqualTo("라반이 또 그의 여종 실바를 그의 딸 레아에게 시녀로 주었더라");
    }

    @Test
    void regexAltPatternMatchTest() {
        String testInput = "삼하2:어떤 사람이 다윗에게 말하여 이르되 사울을 장사한 사람은 길르앗 야베스 사람들이니이다 하매";
        Pattern altPattern = Pattern.compile("([0-9]+:)");
        Matcher matcher = altPattern.matcher(testInput);
        assertThat(matcher.find()).isTrue();
    }

    @Test
    void textParserAltPatternFieldTest() {
        String testInput = "삼하2:어떤 사람이 다윗에게 말하여 이르되 사울을 장사한 사람은 길르앗 야베스 사람들이니이다 하매";
        TextParser textParser = new TextParser(testInput);
        assertThat(textParser.getBookName()).isEqualTo(BookName.SAMUEL2);
        assertThat(textParser.getChapterNo()).isEqualTo(2);
        assertThat(textParser.getVerseNo()).isEqualTo(0);
        assertThat(textParser.getText()).isEqualTo("어떤 사람이 다윗에게 말하여 이르되 사울을 장사한 사람은 "
                + "길르앗 야베스 사람들이니이다 하매");
    }

    @Test
    void allBibleTextsParsingTest() throws IOException {
        for (BookName bookName : BookName.values()) {
            String bookFilePath = PathResolver.resolvePath(bookName);
            BufferedReader br = TextReader.get(bookFilePath);
            rawTexts.addAll(getRawTexts(br));
        }
        for (String rawText : rawTexts) {
            new TextParser(rawText);
        }
    }

    private static List<String> getRawTexts(BufferedReader br) throws IOException {
        List<String> rawTexts = new ArrayList<>();
        while (br.ready()) rawTexts.add(br.readLine());
        return rawTexts;
    }
}