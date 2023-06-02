package typer.bible.service.util;

import typer.bible.domain.BookName;

public class BookFinder {

    public static BookName findBookName(String givenBookName) {
        for (BookName bookName : BookName.values()) {
            String bookNameToString = bookName.toString();
            String givenBookNameToUpperCase = givenBookName.toUpperCase();
            if (bookNameToString.equals(givenBookNameToUpperCase)) return bookName;
        }
        return null;
    }
}
