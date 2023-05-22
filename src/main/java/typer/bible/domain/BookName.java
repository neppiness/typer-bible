package typer.bible.domain;

public enum BookInfo {
    // Old Testimony Books #1 - #10
    GENESIS(Testimony.OLD, 1, "창세기"), EXODUS(Testimony.OLD, 2, "출애굽기"),
    LEVITICUS(Testimony.OLD, 3, "레위기"), NUMBERS(Testimony.OLD, 4, "민수기"),
    DEUTERONOMY(Testimony.OLD, 5, "신명기"), JOSHUA(Testimony.OLD, 6, "여호수아"),
    JUDGES(Testimony.OLD, 7, "사사기"), RUTH(Testimony.OLD, 8, "룻기"),
    SAMUEL1(Testimony.OLD, 9, "사무엘상"), SAMUEL2(Testimony.OLD, 10, "사무엘하"),

    // Old Testimony Books #11 - #20
    KINGS1(Testimony.OLD, 11, "열왕기상"), KINGS2(Testimony.OLD, 12, "열왕기하"),
    CHRONICLES1(Testimony.OLD, 13, "역대상"), CHRONICLES2(Testimony.OLD, 14, "역대하"),
    EZRA(Testimony.OLD, 15, "에스라"), NEHEMIAH(Testimony.OLD, 16, "느헤미야"),
    ESTHER(Testimony.OLD, 17, "에스더"), JOB(Testimony.OLD, 18, "욥기"),
    PSALMS(Testimony.OLD, 19, "시편"), PROVERBS(Testimony.OLD, 20, "잠언"),

    // Old Testimony Books #21 - #30
    ECCLESIASTES(Testimony.OLD, 21, "전도서"), SONGOFSOLOMON(Testimony.OLD, 22, "아가"),
    ISAIAH(Testimony.OLD, 23, "이사야"), JEREMIAH(Testimony.OLD, 24, "예레미야"),
    LAMENTATIONS(Testimony.OLD, 25, "예레미아애가"), EZEKIEL(Testimony.OLD, 26, "에스겔"),
    DANIEL(Testimony.OLD, 27, "다니엘"), HOSEA(Testimony.OLD, 28, "호세아"),
    JOEL(Testimony.OLD, 29, "요엘"), AMOS(Testimony.OLD, 30, "아모스"),

    // Old Testimony Books #31 - #39
    OBADIAH(Testimony.OLD, 31, "오바댜"), JONAH(Testimony.OLD, 32, "요나"),
    MICAH(Testimony.OLD, 33, "미가"), NAHUM(Testimony.OLD, 34, "나훔"),
    HABAKKUK(Testimony.OLD, 35, "하박국"), ZEPHANIAH(Testimony.OLD, 36, "스바냐"),
    HAGGAI(Testimony.OLD, 37, "학개"), ZECHARIAH(Testimony.OLD, 38, "스가랴"),
    MALACHI(Testimony.OLD, 39, "말라기"),

    // New Testimony Books #1 - #10
    MATTHEW(Testimony.NEW, 1, "마태복음"), MARK(Testimony.NEW, 2, "마가복음"),
    LUKE(Testimony.NEW, 3, "누가복음"), JOHN(Testimony.NEW, 4, "요한복음"),
    ACTS(Testimony.NEW, 5, "사도행전"),     ROMANS(Testimony.NEW, 6, "로마서"),
    CORINTHIANS1(Testimony.NEW, 7, "고린도전서"), CORINTHIANS2(Testimony.NEW, 8, "고린도후서"),
    GALATIANS(Testimony.NEW, 9, "갈라디아서"), EPHESIANS(Testimony.NEW, 10, "에베소서"),

    // New Testimony Books #11 - #20
    PHILIPPIANS(Testimony.NEW, 11, "빌립보서"), COLOSSIANS(Testimony.NEW, 12, "골로새서"),
    THESSALONIANS1(Testimony.NEW, 13, "데살로니가전서"), THESSALONIANS2(Testimony.NEW, 14, "데살로니가후서"),
    TIMOTHY1(Testimony.NEW, 15, "디모데전서"), TIMOTHY2(Testimony.NEW, 16, "디모데후서"),
    TITUS(Testimony.NEW, 17, "디도서"), PHILEMON(Testimony.NEW, 18, "빌레몬서"),
    HEBREWS(Testimony.NEW, 19, "히브리서"), JAMES(Testimony.NEW, 20, "야고보서"),

    // New Testimony Books #21 - #27
    PETER1(Testimony.NEW, 21, "베드로전서"), PETER2(Testimony.NEW, 22, "베드로후서"),
    JOHN1(Testimony.NEW, 23, "요한일서"), JOHN2(Testimony.NEW, 24, "요한이서"),
    JOHN3(Testimony.NEW, 25, "요한삼서"), JUDE(Testimony.NEW, 26, "유다서"),
    REVELATION(Testimony.NEW, 27, "요한계시록");

    final public Testimony testimony;
    final public int bookNumber;
    final public String inKorean;

    BookInfo(Testimony testimony_, int bookNumber_, String inKorean_) {
        this.testimony = testimony_;
        this.bookNumber = bookNumber_;
        this.inKorean = inKorean_;
    }
 }