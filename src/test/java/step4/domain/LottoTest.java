package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.controller.LottoTicketMaker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("로또 갯수 대로 입력되는지")
    public void 로또_갯수_대로_입력되는지() {
        int manualLottoQty = 1;

        Amount amount = Amount.of(14000);
        List<Lotto> lottos = new ArrayList<>();
        List<Numbers> lottoNumbers = Stream.of("1,2,3,7,8,9").map(Numbers::of).collect(Collectors.toList());
        Lotto lotto = Lotto.of(lottoNumbers);
        lottos.add(lotto);

        LottoTicketMaker lottoTicketMaker = LottoTicketMaker.of(amount, manualLottoQty, lottos);
        Lottos lottoTicket = lottoTicketMaker.getLottoTicket();
        assertThat(lottoTicket.getLottos().size()).isEqualTo(14);
    }
}
