package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();

        try {
            lottoController.executeLottoProgram();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
