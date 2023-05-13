package typer.bible.repository.util;

import typer.bible.domain.Verse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class VerseRepositoryInitializer {

    static final String oldTestimonyFilePath = "bible-text/old/";
    static final String newTestimonyFilePath = "bible-text/new/";
    static final String txtFileExtension = ".txt";

    static int sequence = 1;
    static HashMap<Integer, Verse> store;

    private VerseRepositoryInitializer() throws IOException {
        List<String> bookFilePaths = BookFilePathResolver.getPaths();
        for (String path : bookFilePaths) {
            BufferedReader br = ReaderForBible.getReader(path);
            saveVerses(br);
        }
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
