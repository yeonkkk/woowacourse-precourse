package lotto;

import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PurchaseAmountTest {

    @DisplayName("예외 테스트: 입력된 금액으로 빈 문자열이 들어왔을 경우")
    @Test
    void purchaseAmountNullTest() {
        String input = "";

        assertThatThrownBy(() -> new PurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외 테스트입력된 금액이 숫자로만 이루어지지 않았을 경우")
    @Test
    void purchaseAmountNumericTest() {
        String input = "12000원";

        assertThatThrownBy(() -> new PurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외 테스트: 입력된 금액이 1000으로 나누어 떨어지지 않는 경우")
    @Test
    void purchaseAmountRemainderTest() {
        String input = "12005";

        assertThatThrownBy(() -> new PurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외 테스트: 입력된 금액이 1000원 이하일 경우")
    @Test
    void purchaseAmountRangeTest() {
        String input = "500";

        assertThatThrownBy(() -> new PurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
