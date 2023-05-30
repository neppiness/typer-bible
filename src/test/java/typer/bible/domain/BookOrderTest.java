package typer.bible.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BookOrderTest {

    final static int lastIndex = BookName.values().length - 1;

    @Test
    void getPrevOrder() {
        for (int i = 1; i <= lastIndex; i++) {
            BookName bookName = BookName.values()[i];
            BookName prevBookName = BookName.values()[i - 1];
            Assertions.assertThat(prevBookName).isEqualTo(BookOrder.getPrev(bookName));
            System.out.print(prevBookName.toString() + "은 ");
            System.out.println(bookName.toString() + "의 이전 경입니다.");
        }
        Assertions.assertThat(BookName.REVELATION).isEqualTo(BookOrder.getPrev(BookName.GENESIS));
        System.out.print(BookName.REVELATION.toString() + "은 ");
        System.out.println(BookName.GENESIS.toString() + "의 이전 경입니다.");
    }

    @Test
    void getNextOrder() {
        for (int i = 0; i < lastIndex; i++) {
            BookName bookName = BookName.values()[i];
            BookName nextBookName = BookName.values()[i + 1];
            Assertions.assertThat(nextBookName).isEqualTo(BookOrder.getNext(bookName));
            System.out.print(nextBookName.toString() + "은 ");
            System.out.println(bookName.toString() + "의 다음 경입니다.");
        }
        Assertions.assertThat(BookName.GENESIS).isEqualTo(BookOrder.getNext(BookName.REVELATION));
        System.out.print(BookName.GENESIS.toString() + "은 ");
        System.out.println(BookName.REVELATION.toString() + "의 다음 경입니다.");
    }
}