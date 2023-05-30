package typer.bible.repository.util;

import typer.bible.domain.Chapter;
import typer.bible.domain.Verse;
import typer.bible.domain.util.VerseDTO;

import java.util.ArrayList;
import java.util.List;

public class ChapterDivider {

    static List<Chapter> divide(List<VerseDTO> allChapterVerseDTOs) {
        List<List<Verse>> listOfVerseList = initList(allChapterVerseDTOs);
        for (VerseDTO verseDTO : allChapterVerseDTOs)
            listOfVerseList.get(verseDTO.getChapterNo() - 1).add(verseDTO.toVerse());

        List<Chapter> chapters = new ArrayList<>();
        int chapterNo = 1;
        for (List<Verse> chapterVerses: listOfVerseList)
            chapters.add(new Chapter(chapterNo++, chapterVerses));
        return chapters;
    }

    private static List<List<Verse>> initList(List<VerseDTO> verseDTOs) {
        int noOfChapters = getNoOfChapter(verseDTOs);
        List<List<Verse>> listOfVerseList = new ArrayList<>();
        for (int i = 0; i < noOfChapters; i++)
            listOfVerseList.add(new ArrayList<>());
        return listOfVerseList;
    }

    private static int getNoOfChapter(List<VerseDTO> allChapterVerses) {
        VerseDTO lastVerseDTO = allChapterVerses.get(allChapterVerses.size() - 1);
        return lastVerseDTO.getChapterNo();
    }
}
