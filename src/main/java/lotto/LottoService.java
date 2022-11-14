package lotto;

import lotto.utils.Constant;
import lotto.utils.Notice;
import lotto.utils.ResultMessage;

import java.util.ArrayList;
import java.util.List;

import static lotto.utils.ResultMessage.printLottoCountResult;


public class LottoService {
    private int purchaseAmount;
    private int lottoNum;
    private List<Lotto> lottos;
    private final Validation validation = new Validation();

    public void generateLotto(String amount) {
        purchaseAmount = validation.validateAmount(amount);
        lottoNum = getNumberOfLotto();

        lottosGenerator(lottoNum);
    }

    public void printLottoInfo() {
        System.out.println(Notice.NUMBER_OF_LOTTO.getMessage(lottoNum));

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public void printResultMessage() {
        System.out.println(Notice.RESULT_OF_WINNING_LOTTO.getMessage());
        printLottoCountResult();
    }

    public void checkWinningResult(String strWinningNum, String strBonusNum) {
        Lotto winningNums = validation.validateWinningNumber(strWinningNum);

        int bonusNum = validation.validateBonusNumber(strBonusNum);

        for (Lotto lotto : lottos) {
            compareWinningNumAndLotto(lotto.getNumbers(), winningNums.getNumbers(), bonusNum);
        }
    }

    private void compareWinningNumAndLotto(List<Integer> lotto, List<Integer> winningNums , int bonusNum) {
        int count = 0;
        boolean checkBonusNum = lotto.contains(bonusNum);

        for (int num : winningNums) {
            if (lotto.contains(num)) {
                count++;
            }
        }

        ResultMessage.increaseCountResult(count, checkBonusNum);
    }


    private int getNumberOfLotto() {
        return purchaseAmount / Constant.CURRENCY_UNIT.getValue();
    }

    private void lottosGenerator(int num) {
        lottos = new ArrayList<>();

        while (num != 0) {
            Lotto lotto = Lotto.lottoGenerator();
            lottos.add(lotto);

            num--;
        }
    }
}
