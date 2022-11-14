package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class BonusNumberTest {
    @DisplayName("예외 테스트: 보너스 번호로 빈 문자열이 들어오는 경우")
    @Test
    void BonusNumberNullTest() {
        WinningLotto winningLotto = new WinningLotto("5,6,7,8,9,10");
        String input = "";

        assertThatThrownBy(() -> new BonusNumber(input, winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("예외 테스트: 보너스 번호가 1~45 범위에서 벗어나는 경우")
    @Test
    void BonusNumberOutOfRangeTest() {
        WinningLotto winningLotto = new WinningLotto("5,6,7,8,9,10");
        String input = "0";

        assertThatThrownBy(() -> new BonusNumber(input, winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("예외 테스트: 보너스 번호에 숫자가 아닌 문자가 포함된 경우")
    @Test
    void BonusNumberNumericTest() {
        WinningLotto winningLotto = new WinningLotto("5,6,7,8,9,10");
        String input = "1,";

        assertThatThrownBy(() -> new BonusNumber(input, winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외 테스트: 보너스 번호가 당첨 번호와 중복 될 경우")
    @Test
    void BonusNumberDuplicationTest() {
        WinningLotto winningLotto = new WinningLotto("5,6,7,8,9,10");
        String input = "5";

        assertThatThrownBy(() -> new BonusNumber(input, winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
