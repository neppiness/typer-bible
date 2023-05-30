package typer.bible.repository.util;

import typer.bible.domain.*;
import typer.bible.domain.util.VerseDTO;

import java.io.IOException;
import java.util.List;

public class BookGenerator {

    public static Book getBook(BookName bookName) throws IOException {
        String bookFilePath = PathResolver.getPath(bookName);
        List<String> rawTexts = TextReader.getRawTexts(bookFilePath);
        List<VerseDTO> verseDTOs = TextParser.convertToVerseDTOs(rawTexts);
        List<Chapter> chapters = ChapterDivider.divide(verseDTOs);
        return new Book(bookName, chapters);
    }
}