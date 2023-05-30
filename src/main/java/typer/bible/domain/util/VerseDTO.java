package typer.bible.domain.util;

import lombok.Getter;
import typer.bible.domain.BookName;
import typer.bible.domain.Verse;
import typer.bible.service.util.ChapterIdResolver;

import java.util.List;

@Getter
public class VerseDTO {

    final BookName bookName;
    final int chapterNo, verseNo;
    final List<String> texts;

    final static StringBuilder sb = new StringBuilder();

    public VerseDTO(BookName bookName, int chapterNo, int verseNo, List<String> texts) {
        this.bookName = bookName;
        this.chapterNo = chapterNo;
        this.verseNo = verseNo;
        this.texts = texts;
    }

    public Verse toVerse() {
        return new Verse(this.verseNo, this.texts);
    }

    @Override
    public String toString() {
        sb.setLength(0);
        sb.append(ChapterIdResolver.get(this.bookName, this.chapterNo)).append(' ')
                .append(this.verseNo).append("절:");
        for (String text : texts) sb.append(' ').append(text);
        return sb.toString();
    }
}