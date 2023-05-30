package typer.bible.service.util;

import typer.bible.domain.BookName;

public class ChapterIdResolver {

    final static StringBuilder sb = new StringBuilder();

    public static String get(BookName bookName, int chapterNo) {
        sb.setLength(0);
        String chapterUnit = "장";
        if (bookName.equals(BookName.PSALMS)) chapterUnit = "편";
        sb.append(bookName.inKorean).append(' ').append(chapterNo).append(chapterUnit);
        return sb.toString();
    }
}
