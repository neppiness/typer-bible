package typer.bible.repository.util;

import typer.bible.domain.Verse;

import java.util.ArrayList;
import java.util.List;

public class VerseCollector {
    public static List<Verse> getVerses(List<String> rawTexts) {
        List<Verse> verses = new ArrayList<>();
        for (String rawText : rawTexts) {
            TextParser parsedText = new TextParser(rawText);
            Verse verse = new Verse(
                    parsedText.getBookName(), parsedText.getChapterNo(),
                    parsedText.getVerseNo(), parsedText.getText()
            );
            verses.add(verse);
        }
        return verses;
    }
}
