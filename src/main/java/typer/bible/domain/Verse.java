package typer.bible.domain;

import lombok.Getter;

import java.util.List;

@Getter
public class Verse {

    final int verseNo;
    final List<String> texts;

    final static StringBuilder sb = new StringBuilder();

    public Verse(int verseNo, List<String> texts) {
        this.verseNo = verseNo;
        this.texts = texts;
    }

    @Override
    public String toString() {
        sb.setLength(0);
        sb.append(this.verseNo).append("절:");
        for (String text : texts) sb.append(' ').append(text);
        return sb.toString();
    }
}