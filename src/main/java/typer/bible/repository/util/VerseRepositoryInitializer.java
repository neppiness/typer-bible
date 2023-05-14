package typer.bible.repository.util;

import typer.bible.domain.Book;
import typer.bible.domain.BookName;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class VerseRepositoryInitializer {

    static final String oldTestimonyFilePath = "bible-text/old/";
    static final String newTestimonyFilePath = "bible-text/new/";
    static final String txtFileExtension = ".txt";

    static int sequence = 1;
    static HashMap<BookName, Book> store;

    private VerseRepositoryInitializer() throws IOException {
        List<String> bookFilePaths = PathResolver.getPaths();
        for (String path : bookFilePaths) {
            BufferedReader br = TextReader.get(path);
            saveVerses(br);
        }
    }

    void saveVerses(BufferedReader br) throws IOException {
        while (br.ready()) {
//            store.put(sequence++, new Verse(br.readLine()));
        }
    }

    public static HashMap<BookName, Book> getStoreInstance() throws IOException {
        if (store == null) {
            store = new HashMap<>();
            new VerseRepositoryInitializer();
        }
        return store;
    }
}
