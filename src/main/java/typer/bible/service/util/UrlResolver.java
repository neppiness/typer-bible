package typer.bible.service.util;

import typer.bible.domain.Book;
import typer.bible.domain.BookName;
import typer.bible.domain.BookOrder;
import typer.bible.repository.MemoryBibleRepository;

import java.util.HashMap;

public class UrlResolver {

    final static String prefix = "verse/";
    final static HashMap<BookName, Book> bible = MemoryBibleRepository.getBibleInstance();

    public static String getPrevUrl(BookName bookName) {
        BookName prevBookName = BookOrder.getPrevBookName(bookName);
        return resolveUrl(prevBookName);
    }

    public static String getPrevUrl(BookName bookName, int chapterNo) {
        if (chapterNo == 1) {
            BookName prevBookName = BookOrder.getPrevBookName(bookName);
            Book prevBook = bible.get(prevBookName);
            int prevBookNoOfChapters = prevBook.getNoOfChapters();
            return resolveUrl(prevBookName, prevBookNoOfChapters);
        }
        return resolveUrl(bookName, chapterNo - 1);
    }

    public static String getNextUrl(BookName bookName) {
        BookName nextBookName = BookOrder.getNextBookName(bookName);
        return resolveUrl(nextBookName);
    }

    public static String getNextUrl(BookName bookName, int chapterNo) {
        Book curBook = bible.get(bookName);
        int prevBookNoOfChapters = curBook.getNoOfChapters();
        if (chapterNo == prevBookNoOfChapters) {
            BookName nextBookName = BookOrder.getNextBookName(bookName);
            return resolveUrl(nextBookName, 1);
        }
        return resolveUrl(bookName, chapterNo + 1);
    }

    private static String resolveUrl(BookName bookName) {
        return prefix + bookName.toString().toLowerCase();
    }

    private static String resolveUrl(BookName bookName, int chapterNo) {
        return prefix + bookName.toString().toLowerCase() + '/' + chapterNo;
    }
}
