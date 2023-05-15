package typer.bible.repository.util;

import lombok.Getter;
import typer.bible.domain.BookName;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
public class TextParser {

    private BookName bookName;
    private int chapterNo, verseNo = 0;
    private String text;

    private final String rawInput;
    private Matcher matcher;

    static Pattern noPattern = Pattern.compile("([0-9]+:[0-9]+)");
    static Pattern altPattern = Pattern.compile("([0-9]+:)");
    static String colon = ":";

    TextParser(String rawInput_) {
        this.rawInput = rawInput_;
        this.matcher = noPattern.matcher(this.rawInput);
        boolean isNoPatternFound = this.matcher.find();
        if (!isNoPatternFound) {
            this.matcher = altPattern.matcher(this.rawInput);
            if (!this.matcher.find())
                throw new IllegalArgumentException("파싱할 수 없는 구문입니다:" + this.rawInput);
            System.out.println(rawInput_); // 부가 패턴에 걸리는 구문 확인
        }
        init(isNoPatternFound);
    }

    private void init(boolean isNoPatternFound) {
        initBookName();
        initText();
        if (isNoPatternFound) { initChapterAndVerseNumbers(); return; }
        initChapterNo();
    }

    private void initBookName() {
        String bookNameInString = this.rawInput.substring(0, matcher.start());
        this.bookName = BookNameResolver.get(bookNameInString);
    }

    private void initChapterAndVerseNumbers() {
        String numbers = this.rawInput.substring(matcher.start(), matcher.end());
        String[] splitNumbers = numbers.split(colon);
        this.chapterNo = Integer.parseInt(splitNumbers[0]);
        this.verseNo = Integer.parseInt(splitNumbers[1]);
    }

    private void initChapterNo() {
        String numbers = this.rawInput.substring(matcher.start(), matcher.end());
        String[] splitNumbers = numbers.split(colon);
        this.chapterNo = Integer.parseInt(splitNumbers[0]);
    }

    private void initText() {
        int textStartingIndex = matcher.end();
        if (this.rawInput.charAt(textStartingIndex) == ' ') textStartingIndex++;
        this.text = this.rawInput.substring(textStartingIndex);
    }
}
