package typer.bible.domain;

import java.util.ArrayList;
import java.util.List;

public class Book {
    BookName bookName;
    List<Chapter> chapters;
    int noOfChapters;

    Book(BookName bookName_, List<Chapter> chapters_) {
        this.bookName = bookName_;
        this.chapters = new ArrayList<>(chapters_);
        this.noOfChapters = this.chapters.size();
    }
}
