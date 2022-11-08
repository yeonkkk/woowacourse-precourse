package baseball;

import java.util.ArrayList;
import java.util.List;

import static baseball.Constant.*;


public class Validation {
    public static void verifyNumResponse(String numResponse) {
        verifyNumResponseLength(numResponse);
        verifyNumResponseTypeAndRange(numResponse);
        verifyNumResponseDuplication(numResponse);
    }

    private static void verifyNumResponseDuplication(String numResponse) {
        List<Character> duplicationCheckList = new ArrayList<>();

        for (char singleNum : numResponse.toCharArray()) {
            if (duplicationCheckList.contains(singleNum)) {
                throw new IllegalArgumentException();
            }
            duplicationCheckList.add(singleNum);
        }
    }

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
