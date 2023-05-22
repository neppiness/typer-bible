package typer.bible.domain;

import lombok.Getter;

@Getter
public class Verse {

    final BookName bookName;
    final int chapterNo, verseNo;
    final String text;
    final String chapterUnit;

    public Verse(BookName bookName, int chapterNo, int verseNo, String text) {
        this.bookName = bookName;
        this.chapterNo = chapterNo;
        this.verseNo = verseNo;
        this.text = text;
        if (bookName == BookName.PSALMS) this.chapterUnit = "편";
        else this.chapterUnit = "장";
    }

    @Override
    public String toString() {
        return this.bookName.inKorean + " "
                + this.chapterNo + this.chapterUnit + " "
                + this.verseNo + "절: "
                + this.text;
    }
}