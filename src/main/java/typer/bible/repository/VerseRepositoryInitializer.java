package typer.bible.repository;

import typer.bible.domain.Book;
import typer.bible.domain.Testimony;
import typer.bible.domain.Verse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VerseRepositoryInitializer {

    static final String oldTestimonyFilePath = "bible-text/old/";
    static final String newTestimonyFilePath = "bible-text/new/";
    static final String txtFileExtension = ".txt";

    static InputStream inputStream;
    static InputStreamReader inputStreamReader;
    static HashMap<Integer, Verse> store = new HashMap<>();
    static int sequence = 1;

    private static List<String> getBookFilePaths() {
        List<String> bookFilePaths = new ArrayList<>();
        for (Book book : Book.values()) {
            String number = getNumberStringInFormat(book);
            String bookFilePath = concatenateBookPath(book, number);
            bookFilePaths.add(bookFilePath);
        }
        return bookFilePaths;
    }

    private static String getNumberStringInFormat(Book book) {
        String number = String.valueOf(book.bookNumber);
        if (number.length() == 1) number = '0' + number;
        return number;
    }

    private static String concatenateBookPath(Book book, String number) {
        if (book.testimony == Testimony.OLD)
            return oldTestimonyFilePath + number + book + txtFileExtension;
        return newTestimonyFilePath + number + book + txtFileExtension;
    }

    BufferedReader getBufferedReaderForBook(String bookFilePath) {
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            inputStream = classLoader.getResourceAsStream(bookFilePath);
            inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new BufferedReader(inputStreamReader);
    }

    void save(Verse verse) {
        store.put(sequence++, verse);
    }

    void saveVerses(BufferedReader br) throws IOException {
        while (br.ready()) save(new Verse(br.readLine()));
    }

    VerseRepositoryInitializer() throws IOException {
        List<String> bookFilePaths = getBookFilePaths();
        for (String bookFilePath : bookFilePaths) {
            BufferedReader br = getBufferedReaderForBook(bookFilePath);
            saveVerses(br);
        }
    }

    HashMap<Integer, Verse> getStoreInstance() {
        return store;
    }
}
