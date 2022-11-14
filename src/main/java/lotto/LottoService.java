package lotto;

import lotto.utils.Constant;
import lotto.utils.Notice;

import java.util.ArrayList;
import java.util.List;

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
