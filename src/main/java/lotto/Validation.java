package lotto;

import static lotto.utils.Constant.*;
import static lotto.utils.ExceptionMessage.*;

public class Validation {
    protected int validateAmount(String amount) {
        validateNull(amount);

        int amountToInt = validateNumber(amount);
        validateAmountRange(amountToInt);

        return amountToInt;
    }

    private void validateNull(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException(NO_INPUT_VALUE.getMessage());
        }
    }

    private int validateNumber(String input) {
        boolean result = input.chars().allMatch(Character::isDigit);
        if (!result) {
            throw new IllegalArgumentException(IS_NOT_NUMBER.getMessage());
        }

        return Integer.parseInt(input);
    }

    private void validateAmountRange(int number) {
        if (number < MINIMUM_AMOUNT.getValue()) {
            throw new IllegalArgumentException(LESS_THAN_MINIMUM_AMOUNT.getMessage(MINIMUM_AMOUNT.getValue()));
        }

        if (number % CURRENCY_UNIT.getValue() != 0) {
            throw new IllegalArgumentException(INVALID_CURRENCY_UNIT.getMessage(CURRENCY_UNIT.getValue()));
        }
    }
}
