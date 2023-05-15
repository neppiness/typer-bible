package typer.bible.domain;

import java.util.ArrayList;
import java.util.List;

public class Chapter {
    List<Verse> verses;
    int noOfVerses;

    public Chapter(List<Verse> verses_) {
        this.verses = new ArrayList<>(verses_);
        this.noOfVerses = this.verses.size();
    }

    public Verse findVerseByNo(int verseNo) {
        Verse foundVerse = verses.get(verseNo - 1);
        if (foundVerse == null) foundVerse = verses.get(0);
        return foundVerse;
    }

    public List<String> getAllVerses() {
        List<String> returnValue = new ArrayList<>();
        for (Verse verse : this.verses) returnValue.add(verse.getText());
        return returnValue;
    }
}
