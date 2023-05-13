package typer.bible.repository;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import typer.bible.domain.BookName;
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

@Slf4j
public class VerseRepositoryInitializer {

    static final String oldTestimonyFilePath = "bible-text/old/";
    static final String newTestimonyFilePath = "bible-text/new/";
    static final String txtFileExtension = ".txt";

    static InputStream inputStream;
    static InputStreamReader inputStreamReader;
    static int sequence = 1;

    static HashMap<Integer, Verse> store;

    private VerseRepositoryInitializer() throws IOException {
        List<String> bookFilePaths = getBookFilePaths();
        for (String bookFilePath : bookFilePaths) {
            BufferedReader br = getBufferedReaderForBook(bookFilePath);
            saveVerses(br);
        }
    }

    static List<String> getBookFilePaths() {
        List<String> bookFilePaths = new ArrayList<>();
        for (BookName bookName : BookName.values()) {
            String bookFilePath = bookPathResolver(bookName);
            bookFilePaths.add(bookFilePath);
        }
        return bookFilePaths;
    }

    static String bookPathResolver(BookName bookName) {
        String number = String.valueOf(bookName.bookNumber);
        if (number.length() == 1) number = '0' + number;
        if (bookName.testimony == Testimony.OLD)
            return oldTestimonyFilePath + number + bookName + txtFileExtension;
        return newTestimonyFilePath + number + bookName + txtFileExtension;
    }

    BufferedReader getBufferedReaderForBook(String bookFilePath) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            inputStream = classLoader.getResourceAsStream(bookFilePath);
            inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        } catch (Exception e) {
            Logger logger = LoggerFactory.getLogger(VerseRepositoryInitializer.class);
            logger.error(e.getMessage());
            throw new IOException(e);
        }
        return new BufferedReader(inputStreamReader);
    }

    void saveVerses(BufferedReader br) throws IOException {
        while (br.ready())
            store.put(sequence++, new Verse(br.readLine()));
    }

    public static HashMap<Integer, Verse> getStoreInstance() throws IOException {
        if (store == null) {
            store = new HashMap<>();
            new VerseRepositoryInitializer();
        }
        return store;
    }
}
