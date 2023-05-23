package typer.bible.domain;

import lombok.Getter;

import java.util.List;

@Getter
public class Verse {

    final static StringBuilder sb = new StringBuilder();

    final BookName bookName;
    final int chapterNo, verseNo;
    final List<String> texts;
    final String verseId;

    public Verse(BookName bookName, int chapterNo, int verseNo, List<String> texts) {
        this.bookName = bookName;
        this.chapterNo = chapterNo;
        this.verseNo = verseNo;
        this.texts = texts;
        this.verseId = setVerseId();
    }

    private String setVerseId() {
        sb.setLength(0);
        String chapterUnit = "장";
        if (bookName == BookName.PSALMS) chapterUnit = "편";
        sb.append(this.chapterNo).append(chapterUnit);
        if (verseNo != 0) sb.append(' ').append(this.verseNo).append("절");
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.bookName.inKorean).append(' ')
                .append(this.verseId).append(": ");
        for (String text : texts) sb.append(text);
        return sb.toString();
    }
}