package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.Constant.RADIX;
import static baseball.Constant.TARGET_NUM_SIZE;

public class NumberBaseBallGame {
    private static List<Character> targetNumList;

    private static void generateTargetNum() {
        targetNumList = new ArrayList<>();

        while (targetNumList.size() < TARGET_NUM_SIZE) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            char radonNumToChar = Character.forDigit(randomNum, RADIX);

            if (targetNumList.contains(radonNumToChar)) {
                continue;
            }
            targetNumList.add(radonNumToChar);
        }
    }
}
