package typer.bible.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import typer.bible.domain.util.VerseDTO;

import java.util.List;
import static org.assertj.core.api.Assertions.*;

class VerseDTOTest {

    static VerseDTO john_3_16, psalms_146_2;

    static List<String> john_3_16_texts = List.of("하나님이 세상을 이처럼 사랑하사", "독생자를 주셨으니",
            "이는 그를 믿는 자마다", "멸망하지 않고", "영생을 얻게 하려 하심이라");
    static List<String> psalms_146_2_texts
            = List.of("나의 생전에 여호와를 찬양하며", "나의 평생에 내 하나님을 찬송하리로다");

    @BeforeAll
    static void beforeAll() {
        john_3_16 = new VerseDTO(BookName.JOHN, 3, 16, john_3_16_texts);
        psalms_146_2 = new VerseDTO(BookName.PSALMS, 146, 2, psalms_146_2_texts);
    }

    @Test
    void VerseConstructorTest1() {
        assertThat(john_3_16.getBookName()).isEqualTo(BookName.JOHN);
        assertThat(john_3_16.getChapterNo()).isEqualTo(3);
        assertThat(john_3_16.getVerseNo()).isEqualTo(16);
        assertThat(john_3_16.getTexts())
                .isEqualTo(List.of("하나님이 세상을 이처럼 사랑하사", "독생자를 주셨으니",
                        "이는 그를 믿는 자마다", "멸망하지 않고", "영생을 얻게 하려 하심이라"));
    }

    @Test
    void VerseConstructorTest2() {
        assertThat(psalms_146_2.getBookName()).isEqualTo(BookName.PSALMS);
        assertThat(psalms_146_2.getChapterNo()).isEqualTo(146);
        assertThat(psalms_146_2.getVerseNo()).isEqualTo(2);
        assertThat(psalms_146_2.getTexts())
                .isEqualTo(List.of("나의 생전에 여호와를 찬양하며", "나의 평생에 내 하나님을 찬송하리로다"));
    }

    @Test
    void toStringTest1() {
        assertThat(john_3_16.toString())
                .isEqualTo("요한복음 3장 16절: 하나님이 세상을 이처럼 사랑하사 독생자를 주셨으니 이는 그를 " +
                        "믿는 자마다 멸망하지 않고 영생을 얻게 하려 하심이라");
        System.out.println(john_3_16.toString());
    }

    @Test
    void toStringTest2() {
        assertThat(psalms_146_2.toString())
                .isEqualTo("시편 146편 2절: 나의 생전에 여호와를 찬양하며 나의 평생에 내 하나님을 찬송하리로다");
        System.out.println(psalms_146_2.toString());
    }
}