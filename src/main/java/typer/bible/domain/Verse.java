package typer.bible.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Verse {

    Long id;
    Book bookName;
    int chapterNo, verseNo;
    String text;
}
