package typer.bible.service.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import typer.bible.domain.Book;
import typer.bible.domain.BookName;
import typer.bible.domain.Chapter;
import typer.bible.domain.Verse;
import typer.bible.repository.MemoryBibleRepository;

import java.util.HashMap;
import java.util.List;

class TextIdTest {

    final static HashMap<String, Boolean> IdMap = new HashMap<>();
    final static MemoryBibleRepository memoryBibleRepository = MemoryBibleRepository.getInstance();
    final static StringBuilder sb = new StringBuilder();

    @Test
    void TextIdUniquenessTest() {
        for (BookName bookName : BookName.values()) {
            Book book = memoryBibleRepository.getBook(bookName);
            Assertions.assertThat(isDuplicatedTextIdFoundInBook(book)).isEqualTo(false);
        }
    }

    private boolean isDuplicatedTextIdFoundInBook(Book book) {
        int chapterNo = 1;
        while (book.getChapter(chapterNo) != null) {
            Chapter chapter = book.getChapter(chapterNo++);
            if (isDuplicatedIdFoundInChapter(chapter)) return true;
            IdMap.clear();
        }
        return false;
    }

    private boolean isDuplicatedIdFoundInChapter(Chapter chapter) {
        List<Verse> chapterVerses = chapter.getVerses();
        for (Verse verse : chapterVerses)
            if (isDuplicatedIdFoundInVerse(verse)) return true;
        return false;
    }

    private boolean isDuplicatedIdFoundInVerse(Verse verse) {
        List<String> texts = verse.getTexts();
        for (int index = 0; index < texts.size(); index++) {
            sb.append(verse.getVerseNo()).append('-').append(index);
            String id = sb.toString();
            if (IdMap.get(id) != null) return true;
            IdMap.put(id, true);
            sb.setLength(0);
        }
        return false;
    }
}
