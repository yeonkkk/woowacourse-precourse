package bridge;

import bridge.domain.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidatorTest {
    private Validator validator = new Validator();

    @DisplayName("숫자가 아니거나 3~20 사이의 수가 아니면 예외를 발생시킨다.")
    @Test
    void validateNumericInputExceptionTest() {
        List<String> inputs = List.of("e", "21", "1");
        for (String input : inputs) {
            assertThatThrownBy(() -> validator.validateNumericInput(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("입력 값이 숫자이면서 3~20 사이의 수인지 확인한다.")
    @Test
    void validateNumericInputTest() {
        List<String> inputs = List.of("3", "20");
        for (String input : inputs) {
            assertEquals(Integer.valueOf(input),
                    validator.validateNumericInput(input));
        }
    }

    @DisplayName("문자가 아니거나 U, D가 아니면 예외를 발생시킨다.")
    @Test
    void validateCharacterExceptionInput() {
        List<String> inputs = List.of("1", "u", "d");
        List<String> indicators = List.of("U", "D");
        for (String input : inputs) {
            assertThatThrownBy(() -> validator.validateCharacterInput(input, indicators))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("입력 값이 문자이면서 U, D 중 하나인지 확인한다.")
    @Test
    void validateCharacterInput() {
        List<String> inputs = List.of("U", "D");
        List<String> indicators = List.of("U", "D");
        for (String input : inputs) {
            assertEquals(input,
                    validator.validateCharacterInput(input, indicators));
        }
    }
}
