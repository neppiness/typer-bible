package typer.bible.domain;

import lombok.Getter;

@Getter
public class Verse {

    final BookName bookName;
    final int chapterNo, verseNo;
    final String text;

    public Verse(BookName bookName, int chapterNo, int verseNo, String text) {
        this.bookName = bookName;
        this.chapterNo = chapterNo;
        this.verseNo = verseNo;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Verse{" +
                "bookName=" + bookName +
                ", chapterNo=" + chapterNo +
                ", verseNo=" + verseNo +
                ", text='" + text + '\'' +
                '}';
    }
}
