package typer.bible.repository.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TextReader {

    static InputStream inputStream;
    static InputStreamReader inputStreamReader;

    public static List<String> getRawTexts(String bookFilePath) throws IOException {
        List<String> rawTexts = new ArrayList<>();
        BufferedReader br = getReader(bookFilePath);
        while (br.ready()) rawTexts.add(br.readLine());
        return rawTexts;
    }

    private static BufferedReader getReader(String bookFilePath) throws IOException {
        ClassLoader classLoader = TextReader.class.getClassLoader();
        inputStream = classLoader.getResourceAsStream(bookFilePath);
        if (inputStream == null) throw new IOException();
        inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        return new BufferedReader(inputStreamReader);
    }
}
