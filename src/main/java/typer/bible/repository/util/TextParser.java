package typer.bible.repository.util;

import typer.bible.domain.BookName;
import typer.bible.domain.util.VerseDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {

    public final static int characterNoLimit = 54;

    private BookName bookName;
    private int chapterNo, verseNo = 0;
    private final List<String> texts = new ArrayList<>();

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
        initTexts();
    }

    public static List<VerseDTO> convertToVerseDTOs(List<String> rawTexts) {
        List<VerseDTO> verseDTOs = new ArrayList<>();
        for (String rawText : rawTexts) {
            TextParser parsedText = new TextParser(rawText);
            VerseDTO verseDTO = new VerseDTO(
                    parsedText.bookName, parsedText.chapterNo,
                    parsedText.verseNo, parsedText.texts
            );
            verseDTOs.add(verseDTO);
        }
        return verseDTOs;
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

    private void initTexts() {
        StringTokenizer st = new StringTokenizer(getText());
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreElements()) {
            String nextToken = st.nextToken();
            if (sb.length() + nextToken.length() >= characterNoLimit) {
                this.texts.add(sb.toString());
                sb.setLength(0);
            }
            if (sb.length() != 0) sb.append(' ');
            sb.append(nextToken);
        }
        this.texts.add(sb.toString());
    }

    private String getText() {
        int textStartingIndex = matcher.end();
        if (this.rawInput.charAt(textStartingIndex) == ' ') textStartingIndex++;
        return this.rawInput.substring(textStartingIndex);
    }
}
