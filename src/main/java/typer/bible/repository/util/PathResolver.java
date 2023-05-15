package typer.bible.repository.util;

import typer.bible.domain.BookName;
import typer.bible.domain.Testimony;

public class PathResolver {
    static final String oldTestimonyFilePath = "bible-text/old/";
    static final String newTestimonyFilePath = "bible-text/new/";
    static final String txtFileExtension = ".txt";

    public static String getPath(BookName bookName) {
        String number = String.valueOf(bookName.bookNumber);
        if (number.length() == 1) number = '0' + number;
        if (bookName.testimony == Testimony.OLD)
            return oldTestimonyFilePath + number + bookName + txtFileExtension;
        return newTestimonyFilePath + number + bookName + txtFileExtension;
    }
}
