package typer.bible.domain;

import java.util.HashMap;

public class Bible {
    static HashMap<BookName, Book> store;

    public static void init(HashMap<BookName, Book> store_) throws IllegalCallerException {
        if (store != null) throw new IllegalCallerException();
        store = store_;
    }

    public static Book findBookByName(BookName bookName) {
        return store.get(bookName);
    }
}
