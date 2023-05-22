package typer.bible.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class BookOrderTest {

    final static int lastIndex = BookName.values().length - 1;
    final static HashMap<BookName, BookName> prevOrder = BookOrder.getPrevOrder();
    final static HashMap<BookName, BookName> nextOrder = BookOrder.getNextOrder();

    @Test
    void getPrevOrder() {
        for (int i = 1; i <= lastIndex; i++) {
            BookName bookName = BookName.values()[i];
            BookName prevBookName = BookName.values()[i - 1];
            Assertions.assertThat(prevBookName).isEqualTo(prevOrder.get(bookName));
            System.out.print(prevBookName.toString() + "은 ");
            System.out.println(bookName.toString() + "의 이전 경입니다.");
        }
        Assertions.assertThat(BookName.REVELATION).isEqualTo(prevOrder.get(BookName.GENESIS));
        System.out.print(BookName.REVELATION.toString() + "은 ");
        System.out.println(BookName.GENESIS.toString() + "의 이전 경입니다.");
    }

    @Test
    void getNextOrder() {
        for (int i = 0; i < lastIndex; i++) {
            BookName bookName = BookName.values()[i];
            BookName nextBookName = BookName.values()[i + 1];
            Assertions.assertThat(nextBookName).isEqualTo(nextOrder.get(bookName));
            System.out.print(nextBookName.toString() + "은 ");
            System.out.println(bookName.toString() + "의 다음 경입니다.");
        }
        Assertions.assertThat(BookName.GENESIS).isEqualTo(nextOrder.get(BookName.REVELATION));
        System.out.print(BookName.GENESIS.toString() + "은 ");
        System.out.println(BookName.REVELATION.toString() + "의 다음 경입니다.");
    }
}