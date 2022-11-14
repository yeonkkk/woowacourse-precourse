package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


public class ValidationTest {

    private final Validation validation = new Validation();

    @DisplayName("예외 테스트: 입력된 금액으로 빈 문자열이 들어왔을 경우")
    @Test
    void purchaseAmountNullTest() {
        String input = "";

        assertThatThrownBy(() -> validation.validateAmount(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외 테스트입력된 금액이 숫자로만 이루어지지 않았을 경우")
    @Test
    void purchaseAmountNumericTest() {
        String input = "12000원";

        assertThatThrownBy(() -> validation.validateAmount(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외 테스트: 입력된 금액이 1000으로 나누어 떨어지지 않는 경우")
    @Test
    void purchaseAmountRemainderTest() {
        String input = "12005";

        assertThatThrownBy(() -> validation.validateAmount(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외 테스트: 입력된 금액이 1000원 이하일 경우")
    @Test
    void purchaseAmountRangeTest() {
        String input = "500";

        assertThatThrownBy(() -> validation.validateAmount(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외 테스트: 당첨 번호로 빈 문자열이 들어올 경우")
    @Test
    void winningNumberNullTest() {
        String input = "";

        assertThatThrownBy(() -> validation.validateWinningNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외 테스트: 당첨 번호로 숫자가 아닌 값이 들어올 경우")
    @Test
    void winningNumberNumericTest() {
        String input = "1,e,3,4,5,6";

        assertThatThrownBy(() -> validation.validateWinningNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("예외 테스트: 당첨 번호 구분자로 ,가 아닌 다른 문자가 올 경우")
    @Test
    void winningNumberSeparatorTest() {
        String input = "1 2 3 4 5 6";

        assertThatThrownBy(() -> validation.validateWinningNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외 테스트: 보너스 번호로 빈 문자열이 들어오는 경우")
    @Test
    void BonusNumberNullTest() {
        validation.setWinningNumbers(new Lotto(List.of(5, 6, 7, 8, 9, 10)));

        String input = "";

        assertThatThrownBy(() -> validation.validateBonusNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("예외 테스트: 보너스 번호가 1~45 범위에서 벗어나는 경우")
    @Test
    void BonusNumberOutOfRangeTest() {
        validation.setWinningNumbers(new Lotto(List.of(5, 6, 7, 8, 9, 10)));

        String input = "0";

        assertThatThrownBy(() -> validation.validateBonusNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("예외 테스트: 보너스 번호에 숫자가 아닌 문자가 포함된 경우")
    @Test
    void BonusNumberNumericTest() {
        validation.setWinningNumbers(new Lotto(List.of(5, 6, 7, 8, 9, 10)));

        String input = "1,";

        assertThatThrownBy(() -> validation.validateBonusNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외 테스트: 보너스 번호가 당첨 번호와 중복 될 경우")
    @Test
    void BonusNumberDuplicationTest() {
        validation.setWinningNumbers(new Lotto(List.of(5, 6, 7, 8, 9, 10)));

        String input = "5";

        assertThatThrownBy(() -> validation.validateBonusNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
