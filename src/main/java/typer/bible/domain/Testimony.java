package typer.bible.domain;

public enum Testimony {
    OLD(0), NEW(1);

    final int code;
    Testimony(int code_) { this.code = code_; }
}
