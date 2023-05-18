package typer.bible.repository.util;

import typer.bible.domain.BookName;
import typer.bible.domain.Verse;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {

    private BookName bookName;
    private int chapterNo, verseNo = 0;
    private String text;

    private final String rawInput;
    private Matcher matcher;

    static Pattern normalPattern = Pattern.compile("([0-9]+:[0-9]+)");
    static Pattern altPattern = Pattern.compile("([0-9]+:)");
    static String colon = ":";

    private TextParser(String rawInput_) {
        this.rawInput = rawInput_;
        initMatcher();
        initBookName();
        initChapterAndVerseNumbers();
        initText();
    }

    public static List<Verse> convertToVerses(List<String> rawTexts) {
        List<Verse> verses = new ArrayList<>();
        for (String rawText : rawTexts) {
            TextParser parsedText = new TextParser(rawText);
            Verse verse = new Verse(
                    parsedText.bookName, parsedText.chapterNo,
                    parsedText.verseNo, parsedText.text
            );
            verses.add(verse);
        }
        return verses;
    }

    private void initMatcher() {
        this.matcher = normalPattern.matcher(this.rawInput);
        boolean isNormalPatternFound = this.matcher.find();
        if (isNormalPatternFound && isValidStartIndex()) return;

        this.matcher = altPattern.matcher(this.rawInput);
        if (this.matcher.find() && isValidStartIndex()) return;
        throw new IllegalArgumentException("파싱할 수 없는 구문입니다: " + this.rawInput);
    }

    private boolean isValidStartIndex() {
        return (this.matcher.start() == 1 || this.matcher.start() == 2);
    }

    private void initBookName() {
        String bookNameInString = this.rawInput.substring(0, matcher.start());
        this.bookName = BookNameResolver.get(bookNameInString);
    }

    private void initChapterAndVerseNumbers() {
        String numbers = this.rawInput.substring(matcher.start(), matcher.end());
        String[] splitNumbers = numbers.split(colon);
        this.chapterNo = Integer.parseInt(splitNumbers[0]);
        if (splitNumbers.length == 2) {
            this.verseNo = Integer.parseInt(splitNumbers[1]);
        }
    }

    private void initText() {
        int textStartingIndex = matcher.end();
        if (this.rawInput.charAt(textStartingIndex) == ' ') textStartingIndex++;
        this.text = this.rawInput.substring(textStartingIndex);
    }
}
