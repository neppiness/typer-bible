package typer.bible.repository.util;

import org.junit.jupiter.api.Test;
import typer.bible.domain.Book;
import typer.bible.domain.BookName;
import typer.bible.domain.Verse;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BookGeneratorTest {

    static List<String> obadiahRawTexts = List.of(
            "옵1:1 오바댜의 묵시라",
            "옵1:주 <여호와께서 에돔을 심판하시다> 여호와께서 에돔에 대하여 이와 같이 말씀하시니라 우리가 여호와께로 말미암아 " +
                    "소식을 들었나니 곧 사자가 나라들 가운데에 보내심을 받고 이르기를 너희는 일어날지어다 우리가 일어나서 그와 " +
                    "싸우자 하는 것이니라",
            "옵1:2 보라 내가 너를 나라들 가운데에 매우 작게 하였으므로 네가 크게 멸시를 받느니라",
            "옵1:3 너의 마음의 교만이 너를 속였도다 바위 틈에 거주하며 높은 곳에 사는 자여 네가 마음에 이르기를 누가 능히 나를 " +
                    "땅에 끌어내리겠느냐 하니",
            "옵1:4 네가 독수리처럼 높이 오르며 별 사이에 깃들일지라도 내가 거기에서 너를 끌어내리리라 여호와의 말씀이니라",
            "옵1:5 혹시 도둑이 네게 이르렀으며 강도가 밤중에 네게 이르렀을지라도 만족할 만큼 훔치면 그치지 아니하였겠느냐 혹시 " +
                    "포도를 따는 자가 네게 이르렀을지라도 그것을 얼마쯤 남기지 아니하였겠느냐 네가 어찌 그리 망하였는고",
            "옵1:6 에서가 어찌 그리 수탈되었으며 그 감춘 보물이 어찌 그리 빼앗겼는고",
            "옵1:7 너와 약조한 모든 자들이 다 너를 쫓아 변경에 이르게 하며 너와 화목하던 자들이 너를 속여 이기며 네 먹을 것을 " +
                    "먹는 자들이 네 아래에 함정을 파니 네 마음에 지각이 없음이로다",
            "옵1:8 여호와의 말씀이니라 그 날에 내가 에돔에서 지혜 있는 자를 멸하며 에서의 산에서 지각 있는 자를 멸하지 " +
                    "아니하겠느냐",
            "옵1:9 드만아 네 용사들이 놀랄 것이라 이로 말미암아 에서의 산에 있는 사람은 다 죽임을 당하여 멸절되리라",
            "옵1:10 <에돔의 죄> 네가 네 형제 야곱에게 행한 포학으로 말미암아 부끄러움을 당하고 영원히 멸절되리라",
            "옵1:11 네가 멀리 섰던 날 곧 이방인이 그의 재물을 빼앗아 가며 외국인이 그의 성문에 들어가서 예루살렘을 얻기 위하여 " +
                    "제비 뽑던 날에 너도 그들 중 한 사람 같았느니라",
            "옵1:12 네가 형제의 날 곧 그 재앙의 날에 방관할 것이 아니며 유다 자손이 패망하는 날에 기뻐할 것이 아니며 그 고난의 " +
                    "날에 네가 입을 크게 벌릴 것이 아니며",
            "옵1:13 내 백성이 환난을 당하는 날에 네가 그 성문에 들어가지 않을 것이며 환난을 당하는 날에 네가 그 고난을 방관하지 " +
                    "않을 것이며 환난을 당하는 날에 네가 그 재물에 손을 대지 않을 것이며",
            "옵1:14 네거리에 서서 그 도망하는 자를 막지 않을 것이며 고난의 날에 그 남은 자를 원수에게 넘기지 않을 것이니라",
            "옵1:15 <여호와께서 만국을 벌하실 날> 여호와께서 만국을 벌할 날이 가까웠나니 네가 행한 대로 너도 받을 것인즉 네가 " +
                    "행한 것이 네 머리로 돌아갈 것이라",
            "옵1:16 너희가 내 성산에서 마신 것 같이 만국인이 항상 마시리니 곧 마시고 삼켜서 본래 없던 것 같이 되리라",
            "옵1:17 <여호와께 속할 나라> 오직 시온 산에서 피할 자가 있으리니 그 산이 거룩할 것이요 야곱 족속은 자기 기업을 " +
                    "누릴 것이며",
            "옵1:18 야곱 족속은 불이 될 것이며 요셉 족속은 불꽃이 될 것이요 에서 족속은 지푸라기가 될 것이라 그들이 그들 위에 " +
                    "붙어서 그들을 불사를 것인즉 에서 족속에 남은 자가 없으리니 여호와께서 말씀하셨음이라",
            "옵1:19 그들이 네겝과 에서의 산과 평지와 블레셋을 얻을 것이요 또 그들이 에브라임의 들과 사마리아의 들을 얻을 것이며 " +
                    "베냐민은 길르앗을 얻을 것이며",
            "옵1:20 사로잡혔던 이스라엘의 많은 자손은 가나안 사람에게 속한 이 땅을 사르밧까지 얻을 것이며 예루살렘에서 " +
                    "사로잡혔던 자들 곧 스바랏에 있는 자들은 네겝의 성읍들을 얻을 것이니라",
            "옵1:21 구원 받은 자들이 시온 산에 올라와서 에서의 산을 심판하리니 나라가 여호와께 속하리라"
    );

    @Test
    void getBookTest() throws IOException {
        List<Verse> versesFromTest = VerseCollector.getVerses(obadiahRawTexts);
        Book Obadiah = BookGenerator.getBook(BookName.OBADIAH);
        List<String> textsFromBookGenerator = Obadiah.getAllVerseTexts();
        int idx = 0;
        for (Verse verse : versesFromTest) {
            System.out.println(verse.toString());
            assertThat(verse.getText())
                    .isEqualTo(textsFromBookGenerator.get(idx++));
        }
    }
}