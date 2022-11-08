package baseball;

import static baseball.Constant.*;


public class Validation {
    private static void verifyNumResponseLength(String numResponse) {
        if (numResponse.length() != TARGET_NUM_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private static void verifyNumResponseTypeAndRange(String numResponse) {
        if (!numResponse.matches("^[1-9]*$")) {
            throw new IllegalArgumentException();
        }
    }
}
