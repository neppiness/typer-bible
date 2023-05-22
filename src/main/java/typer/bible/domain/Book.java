package typer.bible.domain;

import java.util.ArrayList;
import java.util.List;

public class Book {
    final BookName bookName;
    final List<List<Verse>> chapters;
    final int noOfChapters;

    public Book(BookName bookName_, List<List<Verse>> chapters_) {
        this.bookName = bookName_;
        this.chapters = new ArrayList<>(chapters_);
        this.noOfChapters = this.chapters.size();
    }

    public int getNoOfChapters() {
        return this.noOfChapters;
    }

    public List<Verse> find(int chapterNo) {
        return this.chapters.get(chapterNo - 1);
    }

    public List<Verse> find(int chapterNo, int verseNo) {
        return List.of(this.chapters.get(chapterNo - 1).get(verseNo - 1));
    }

    public List<Verse> getAllVerses() {
        List<Verse> allBookVerses = new ArrayList<>();
        for (List<Verse> chapter : this.chapters)
            allBookVerses.addAll(chapter);
        return allBookVerses;
    }
}
