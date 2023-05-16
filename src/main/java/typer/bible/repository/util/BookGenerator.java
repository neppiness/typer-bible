package typer.bible.repository.util;

import typer.bible.domain.Book;
import typer.bible.domain.BookName;
import typer.bible.domain.Chapter;
import typer.bible.domain.Verse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookGenerator {

    public static Book getBook(BookName bookName) throws IOException {
        String bookFilePath = PathResolver.getPath(bookName);
        BufferedReader br = TextReader.get(bookFilePath);
        List<String> rawTexts = getRawTexts(br);
        List<Verse> allChapterVerses = VerseCollector.getVerses(rawTexts);
        List<Chapter> chapters = divideVersesIntoChapters(allChapterVerses);
        return new Book(bookName, chapters);
    }

    private static List<String> getRawTexts(BufferedReader br) throws IOException {
        List<String> rawTexts = new ArrayList<>();
        while (br.ready()) rawTexts.add(br.readLine());
        return rawTexts;
    }

    private static List<Chapter> divideVersesIntoChapters(List<Verse> allChapterVerses) {
        List<Chapter> returnValue = new ArrayList<>();
        List<Verse> verses = new ArrayList<>();
        int tempChapterNo = 1;

        for (Verse verse : allChapterVerses) {
            int currentChapterNo = verse.getChapterNo();
            if (currentChapterNo > tempChapterNo) {
                tempChapterNo++;
                returnValue.add(new Chapter(verses));
                verses.clear();
            }
            verses.add(verse);
        }
        returnValue.add(new Chapter(verses));
        return returnValue;
    }
}
