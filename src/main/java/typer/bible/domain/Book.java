package typer.bible.domain;

import java.util.ArrayList;
import java.util.List;

public class Book {
    BookName bookName;
    List<Chapter> chapters;
    public int noOfChapters;

    public Book(BookName bookName_, List<Chapter> chapters_) {
        this.bookName = bookName_;
        this.chapters = new ArrayList<>(chapters_);
        this.noOfChapters = this.chapters.size();
    }

    public Chapter findChapterByNo(int chapterNo) {
        Chapter foundChapter = chapters.get(chapterNo - 1);
        if (foundChapter == null) foundChapter = chapters.get(0);
        return foundChapter;
    }

    public List<String> getAllVerseTexts() {
        List<String> returnValue = new ArrayList<>();
        for (Chapter chapter : this.chapters)
            returnValue.addAll(chapter.getAllVerseTexts());
        return returnValue;
    }
}
