package typer.bible.service.util;

import org.junit.jupiter.api.Test;
import typer.bible.domain.BookName;

import static org.assertj.core.api.Assertions.*;

class UrlResolverTest {

    @Test
    void prevUrlUsingBookName() {
        BookName bookName = BookName.PSALMS;
        String prevUrl = UrlResolver.getPrevUrl(bookName);
        String intendedUrl = "verse/job";
        assertThat(prevUrl).isEqualTo(intendedUrl);
    }

    @Test
    void prevUrlUsingBookName2() {
        BookName bookName = BookName.GENESIS;
        String prevUrl = UrlResolver.getPrevUrl(bookName);
        String intendedUrl = "verse/revelation";
        assertThat(prevUrl).isEqualTo(intendedUrl);
    }

    @Test
    void prevUrlUsingBookNameAndChapterNo() {
        BookName bookName = BookName.PSALMS;
        String prevUrl = UrlResolver.getPrevUrl(bookName, 1);
        String intendedUrl = "verse/job/42";
        assertThat(prevUrl).isEqualTo(intendedUrl);
    }

    @Test
    void prevUrlUsingBookNameAndChapterNo2() {
        BookName bookName = BookName.GENESIS;
        String prevUrl = UrlResolver.getPrevUrl(bookName);
        String intendedUrl = "verse/revelation";
        assertThat(prevUrl).isEqualTo(intendedUrl);
    }

    @Test
    void nextUrlUsingBookName() {
        BookName bookName = BookName.PHILIPPIANS;
        String nextUrl = UrlResolver.getNextUrl(bookName);
        String intendedUrl = "verse/colossians";
        assertThat(nextUrl).isEqualTo(intendedUrl);
    }

    @Test
    void nextUrlUsingBookName2() {
        BookName bookName = BookName.REVELATION;
        String nextUrl = UrlResolver.getNextUrl(bookName);
        String intendedUrl = "verse/genesis";
        assertThat(nextUrl).isEqualTo(intendedUrl);
    }

    @Test
    void nextUrlUsingBookNameAndChapterNo() {
        BookName bookName = BookName.PHILIPPIANS;
        String nextUrl = UrlResolver.getNextUrl(bookName, 4);
        String intendedUrl = "verse/colossians/1";
        assertThat(nextUrl).isEqualTo(intendedUrl);
    }

    @Test
    void nextUrlUsingBookNameAndChapterNo2() {
        BookName bookName = BookName.REVELATION;
        String nextUrl = UrlResolver.getNextUrl(bookName, 22);
        String intendedUrl = "verse/genesis/1";
        assertThat(nextUrl).isEqualTo(intendedUrl);
    }
}