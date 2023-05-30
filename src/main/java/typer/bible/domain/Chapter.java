package typer.bible.domain;

import java.util.List;

public class Chapter {

    final List<Verse> verses;
    final int chapterNo;

    public Chapter(int chapterNo_, List<Verse> verses_) {
        this.chapterNo = chapterNo_;
        this.verses = verses_;
    }

    public int getChapterNo() {
        return this.chapterNo;
    }
    public List<Verse> getVerses() {
        return this.verses;
    }
}
