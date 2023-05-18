package typer.bible.repository.util;

import typer.bible.domain.Book;
import typer.bible.domain.BookName;
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
        List<Verse> verses = TextParser.convertToVerses(rawTexts);
        List<List<Verse>> chapters = divideVersesIntoChapters(verses);
        return new Book(bookName, chapters);
    }

    private static List<String> getRawTexts(BufferedReader br) throws IOException {
        List<String> rawTexts = new ArrayList<>();
        while (br.ready()) rawTexts.add(br.readLine());
        return rawTexts;
    }

    private static List<List<Verse>> divideVersesIntoChapters(List<Verse> verses) {
        int noOfChapters = getNoOfChapter(verses);
        List<List<Verse>> chapters = initChapters(noOfChapters);
        for (Verse verse : verses) {
            List<Verse> chapter = chapters.get(verse.getChapterNo() - 1);
            chapter.add(verse);
        }
        return chapters;
    }

    private static int getNoOfChapter(List<Verse> verses) {
        Verse lastVerse = verses.get(verses.size() - 1);
        return lastVerse.getChapterNo();
    }

    private static List<List<Verse>> initChapters(int noOfChapters) {
        List<List<Verse>> chapters = new ArrayList<>();
        for (int i = 0; i < noOfChapters; i++)
            chapters.add(new ArrayList<>());
        return chapters;
    }
}
