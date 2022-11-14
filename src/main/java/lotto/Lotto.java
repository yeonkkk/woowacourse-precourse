package lotto;

import lotto.utils.Constant;

import java.util.ArrayList;
import java.util.List;

import static lotto.Validation.validateSingleNumberRange;
import static lotto.utils.ExceptionMessage.DUPLICATE_VALUE;
import static lotto.utils.ExceptionMessage.INVALID_COUNT;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        validateRange(numbers);

        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }



    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != Constant.LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(INVALID_COUNT.getMessage());
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        List<Integer> uniqueNumbers = new ArrayList<>();

        for (int number : numbers) {
            if (uniqueNumbers.contains(number)) {
                throw new IllegalArgumentException(DUPLICATE_VALUE.getMessage());
            }
            uniqueNumbers.add(number);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateSingleNumberRange(number);
        }
    }
}
