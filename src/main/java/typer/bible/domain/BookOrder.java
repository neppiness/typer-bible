package typer.bible.domain;

import java.util.HashMap;

public class BookOrder {

    final static int lastIndex = BookName.values().length - 1;

    static HashMap<BookName, BookName> prevOrder;
    static HashMap<BookName, BookName> nextOrder;

    public static BookName getPrevBookName(BookName bookName) {
        if (prevOrder == null) initPrevOrder();
        return prevOrder.get(bookName);
    }

    public static BookName getNextBookName(BookName bookName) {
        if (nextOrder == null) initNextOrder();
        return nextOrder.get(bookName);
    }

    private static void initPrevOrder() {
        prevOrder = new HashMap<>();
        for (int i = 1; i <= lastIndex; i++)
            prevOrder.put(BookName.values()[i], BookName.values()[i - 1]);
        prevOrder.put(BookName.values()[0], BookName.values()[lastIndex]);
    }

    private static void initNextOrder() {
        nextOrder = new HashMap<>();
        for (int i = 0; i < lastIndex; i++)
            nextOrder.put(BookName.values()[i], BookName.values()[i + 1]);
        nextOrder.put(BookName.values()[lastIndex], BookName.values()[0]);
    }
}
