package typer.bible.repository.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ReaderForBible {

    static InputStream inputStream;
    static InputStreamReader inputStreamReader;

    public static BufferedReader getReader(String bookFilePath) throws IOException {
        ClassLoader classLoader = ReaderForBible.class.getClassLoader();
        inputStream = classLoader.getResourceAsStream(bookFilePath);
        if (inputStream == null) throw new IOException();
        inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        return new BufferedReader(inputStreamReader);
    }
}
