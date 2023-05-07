package typer.bible.domain;

public enum Book {
    GENESIS(Testimony.OLD, 1), EXODUS(Testimony.OLD, 2),
    LEVITICUS(Testimony.OLD, 3), NUMBERS(Testimony.OLD, 4),
    DEUTERONOMY(Testimony.OLD, 5), JOSHUA(Testimony.OLD, 6),
    JUDGES(Testimony.OLD, 7), RUTH(Testimony.OLD, 8),
    SAMUEL1(Testimony.OLD, 9), SAMUEL2(Testimony.OLD, 10),

    KINGS1(Testimony.OLD, 11), KINGS2(Testimony.OLD, 12),
    CHRONICLES1(Testimony.OLD, 13), CHRONICLES2(Testimony.OLD, 14),
    EZRA(Testimony.OLD, 15), NEHEMIAH(Testimony.OLD, 16),
    ESTHER(Testimony.OLD, 17), JOB(Testimony.OLD, 18),
    PSALMS(Testimony.OLD, 19), PROVERBS(Testimony.OLD, 20),

    ECCLESIASTES(Testimony.OLD, 21), SONGOFSOLOMON(Testimony.OLD, 22),
    ISAIAH(Testimony.OLD, 23), JEREMIAH(Testimony.OLD, 24),
    LAMENTATIONS(Testimony.OLD, 25), EZEKIEL(Testimony.OLD, 26),
    DANIEL(Testimony.OLD, 27), HOSEA(Testimony.OLD, 28),
    JOEL(Testimony.OLD, 29), AMOS(Testimony.OLD, 30),

    OBADIAH(Testimony.OLD, 31), JONAH(Testimony.OLD, 32),
    MICAH(Testimony.OLD, 33), NAHUM(Testimony.OLD, 34),
    HABAKKUK(Testimony.OLD, 35), ZEPHANIAH(Testimony.OLD, 36),
    HAGGAI(Testimony.OLD, 37), ZECHARIAH(Testimony.OLD, 38),
    MALACHI(Testimony.OLD, 39),


    MATTHEW(Testimony.NEW, 1), MARK(Testimony.NEW, 2),
    LUKE(Testimony.NEW, 3), JOHN(Testimony.NEW, 4),
    ACTS(Testimony.NEW, 5),     ROMANS(Testimony.NEW, 6),
    CORINTHIANS1(Testimony.NEW, 7), CORINTHIANS2(Testimony.NEW, 8),
    GALATIANS(Testimony.NEW, 9), EPHESIANS(Testimony.NEW, 10),

    // 11 to 20 New Testimony Books
    PHILIPPIANS(Testimony.NEW, 11), COLOSSIANS(Testimony.NEW, 12),
    THESSALONIANS1(Testimony.NEW, 13), THESSALONIANS2(Testimony.NEW, 14),
    TIMOTHY1(Testimony.NEW, 15), TIMOTHY2(Testimony.NEW, 16),
    TITUS(Testimony.NEW, 17), PHILEMON(Testimony.NEW, 18),
    HEBREWS(Testimony.NEW, 19), JAMES(Testimony.NEW, 20),

    // 21 to 27 New Testimony Books
    PETER1(Testimony.NEW, 21), PETER2(Testimony.NEW, 22),
    JOHN1(Testimony.NEW, 23), JOHN2(Testimony.NEW, 24),
    JOHN3(Testimony.NEW, 25), JUDE(Testimony.NEW, 26),
    REVELATION(Testimony.NEW, 27);

    final public Testimony testimony;
    final public int bookNumber;

    Book(Testimony testimony_, int bookNumber_) {
        this.testimony = testimony_;
        this.bookNumber = bookNumber_;
    }
 }