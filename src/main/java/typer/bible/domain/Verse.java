package typer.bible.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Verse {

    Long id;
    BookName bookName;
    int chapterNo, verseNo;
    String text;

    public Verse(BookName bookName, int chapterNo, int verseNo, String text) {
        this.bookName = bookName;
        this.chapterNo = chapterNo;
        this.verseNo = verseNo;
        this.text = text;
    }
}
