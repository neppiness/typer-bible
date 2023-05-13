package typer.bible.domain;

import java.util.ArrayList;
import java.util.List;

public class Chapter {
    List<Verse> verses;
    int noOfVerses;

    Chapter(List<Verse> verses_) {
        this.verses = new ArrayList<>(verses_);
        this.noOfVerses = this.verses.size();
    }

    public Verse findByVerseNo(int verseNo) {
        Verse foundVerse = verses.get(verseNo - 1);
        if (foundVerse == null) foundVerse = verses.get(0);
        return foundVerse;
    }
}
