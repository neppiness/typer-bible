package typer.bible.domain;

import java.util.List;

public class Book {
    final BookName bookName;
    final List<Chapter> chapters;

    public Book(BookName bookName_, List<Chapter> chapters_) {
        this.bookName = bookName_;
        this.chapters = chapters_;
    }

    public int getNoOfChapters() {
        return this.chapters.size();
    }

    public Chapter getChapter(int chapterNo) {
        return this.chapters.get(chapterNo - 1);
    }
}
