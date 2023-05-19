package typer.bible.repository.util;

import typer.bible.domain.BookName;
import java.util.HashMap;

public class BookNameResolver {

    static HashMap<String, BookName> map;
    static String[] abbreviations = new String[]{
            "창", "출", "레", "민", "신",
            "수", "삿", "룻", "삼상", "삼하",
            "왕상", "왕하", "대상", "대하", "스",
            "느", "에", "욥", "시", "잠",
            "전", "아", "사", "렘", "애",
            "겔", "단", "호", "욜", "암",
            "옵", "욘", "미", "나", "합",
            "습", "학", "슥", "말",

            "마", "막", "눅", "요", "행",
            "롬", "고전", "고후", "갈", "엡",
            "빌", "골", "살전", "살후", "딤전",
            "딤후", "딛", "몬", "히", "약",
            "벧전", "벧후", "요일", "요이", "요삼",
            "유", "계"
    };

    public static BookName get(String abbr) {
        if (map == null) setMap();
        return map.get(abbr);
    }

    private static void setMap() {
        map = new HashMap<>();
        int abbrIdx = 0;
        for (BookName bookName : BookName.values())
            map.put(abbreviations[abbrIdx++], bookName);
    }
}
