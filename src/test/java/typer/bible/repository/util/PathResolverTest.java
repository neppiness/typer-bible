package typer.bible.repository.util;

import org.junit.jupiter.api.Test;
import typer.bible.domain.BookName;
import typer.bible.domain.Testimony;

import static org.assertj.core.api.Assertions.*;

class PathResolverTest {
    static String[] oldTestimonyPaths = new String[]{
            "bible-text/old/01GENESIS.txt", "bible-text/old/02EXODUS.txt", "bible-text/old/03LEVITICUS.txt",
            "bible-text/old/04NUMBERS.txt", "bible-text/old/05DEUTERONOMY.txt", "bible-text/old/06JOSHUA.txt",
            "bible-text/old/07JUDGES.txt", "bible-text/old/08RUTH.txt", "bible-text/old/09SAMUEL1.txt",
            "bible-text/old/10SAMUEL2.txt", "bible-text/old/11KINGS1.txt", "bible-text/old/12KINGS2.txt",
            "bible-text/old/13CHRONICLES1.txt", "bible-text/old/14CHRONICLES2.txt", "bible-text/old/15EZRA.txt",
            "bible-text/old/16NEHEMIAH.txt", "bible-text/old/17ESTHER.txt", "bible-text/old/18JOB.txt",
            "bible-text/old/19PSALMS.txt", "bible-text/old/20PROVERBS.txt", "bible-text/old/21ECCLESIASTES.txt",
            "bible-text/old/22SONGOFSOLOMON.txt", "bible-text/old/23ISAIAH.txt", "bible-text/old/24JEREMIAH.txt",
            "bible-text/old/25LAMENTATIONS.txt", "bible-text/old/26EZEKIEL.txt", "bible-text/old/27DANIEL.txt",
            "bible-text/old/28HOSEA.txt", "bible-text/old/29JOEL.txt", "bible-text/old/30AMOS.txt",
            "bible-text/old/31OBADIAH.txt", "bible-text/old/32JONAH.txt", "bible-text/old/33MICAH.txt",
            "bible-text/old/34NAHUM.txt", "bible-text/old/35HABAKKUK.txt", "bible-text/old/36ZEPHANIAH.txt",
            "bible-text/old/37HAGGAI.txt", "bible-text/old/38ZECHARIAH.txt", "bible-text/old/39MALACHI.txt"
    };

    static String[] newTestimonyPaths = new String[]{
            "bible-text/new/01MATTHEW.txt", "bible-text/new/02MARK.txt", "bible-text/new/03LUKE.txt",
            "bible-text/new/04JOHN.txt", "bible-text/new/05ACTS.txt", "bible-text/new/06ROMANS.txt",
            "bible-text/new/07CORINTHIANS1.txt", "bible-text/new/08CORINTHIANS2.txt",
            "bible-text/new/09GALATIANS.txt", "bible-text/new/10EPHESIANS.txt",
            "bible-text/new/11PHILIPPIANS.txt", "bible-text/new/12COLOSSIANS.txt",
            "bible-text/new/13THESSALONIANS1.txt", "bible-text/new/14THESSALONIANS2.txt",
            "bible-text/new/15TIMOTHY1.txt", "bible-text/new/16TIMOTHY2.txt", "bible-text/new/17TITUS.txt",
            "bible-text/new/18PHILEMON.txt", "bible-text/new/19HEBREWS.txt", "bible-text/new/20JAMES.txt",
            "bible-text/new/21PETER1.txt", "bible-text/new/22PETER2.txt", "bible-text/new/23JOHN1.txt",
            "bible-text/new/24JOHN2.txt", "bible-text/new/25JOHN3.txt", "bible-text/new/26JUDE.txt",
            "bible-text/new/27REVELATION.txt"
    };

    @Test
    void getPathTestForOldTestimony() {
        for (BookName bookName : BookName.values()) {
            if (bookName.testimony.equals(Testimony.NEW)) continue;
            int idx = bookName.bookNumber - 1;
            String answer = oldTestimonyPaths[idx];
            assertThat(PathResolver.getPath(bookName)).isEqualTo(answer);
        }
    }

    @Test
    void getPathTestForNewTestimony() {
        for (BookName bookName : BookName.values()) {
            if (bookName.testimony.equals(Testimony.OLD)) continue;
            int idx = bookName.bookNumber - 1;
            String answer = newTestimonyPaths[idx];
            assertThat(PathResolver.getPath(bookName)).isEqualTo(answer);
        }
    }
}