package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.utils.Constant.*;
import static lotto.utils.ExceptionMessage.*;

public class Validation {
    private List<Integer> winningNumbers;

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    protected int validateAmount(String amount) {
        validateNull(amount);

        int amountToInt = validateNumber(amount);
        validateAmountRange(amountToInt);

        return amountToInt;
    }


    protected List<Integer> validateWinningNumber(String number) {
        validateNull(number);
        validateSeparator(number);

        winningNumbers = Arrays.stream(number.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return winningNumbers;
    }


    protected int validateBonusNumber(String number) {
        validateNull(number);
        int bonusNumber = validateNumber(number);
        validateSingleNumberRange(bonusNumber);
        validateDuplicationByBonusNumber(winningNumbers, bonusNumber);

        return bonusNumber;
    }


    private void validateNull(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException(NO_INPUT_VALUE.getMessage());
        }
    }

    private void validateSeparator(String input) {
        if (!input.matches("^[\\d,]*$")) {
            throw new IllegalArgumentException(INVALID_SEPARATOR.getMessage());
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

    protected static void validateSingleNumberRange(int number) {
        if (number < LOTTO_RANGE_START_NUM.getValue() || LOTTO_RANGE_END_NUM.getValue() < number) {
            String message = OUT_OF_LOTTO_NUMBER_RANGE.getMessage(LOTTO_RANGE_START_NUM.getValue(), LOTTO_RANGE_END_NUM.getValue());
            throw new IllegalArgumentException(message);
        }
    }

    private static void validateDuplicationByBonusNumber(List<Integer> winningNumbers, int number) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBER_AND_BONUS_NUMBER.getMessage());
        }
    }
}
