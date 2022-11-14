package lotto.service;

import lotto.domain.*;
import lotto.utils.Constant;
import lotto.utils.Notice;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.ResultMessage.calculateTotalWinningMoney;
import static lotto.domain.ResultMessage.printLottoCountResult;


public class LottoService {
    private PurchaseAmount purchaseAmount;
    private int lottoNum;
    private List<Lotto> lottos;

    public void generateLotto(String amount) {
        purchaseAmount = new PurchaseAmount(amount);
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
        WinningLotto winningLotto = new WinningLotto(strWinningNum);
        BonusNumber bonusNum = new BonusNumber(strBonusNum, winningLotto);

        for (Lotto lotto : lottos) {
            compareWinningNumAndLotto(
                    lotto.getNumbers(),
                    winningLotto.getNumbers(),
                    bonusNum.getNumber());
        }
    }

    public void calculateEarningsRate() {
        int earnings = calculateTotalWinningMoney();
        int amount = purchaseAmount.getAmount();
        double earningsRate = Math.round(earnings * 1000 / amount) / 10.0;

        String earningsRateStr = earningsRate + "%";
        System.out.printf(Notice.EARNINGS_RATE.getMessage(), earningsRateStr);
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
        return purchaseAmount.getAmount() / Constant.CURRENCY_UNIT.getValue();
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
