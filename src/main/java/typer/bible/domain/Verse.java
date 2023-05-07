package typer.bible.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Verse {

    Long id; String text;

    /* TO BE UPDATED
    Book bookName;
    int chapterNo, verseNo;
     */

    public Verse(String text_) { this.text = text_; }
}
