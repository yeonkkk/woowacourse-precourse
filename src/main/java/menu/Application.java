package menu;

import menu.controller.Controller;
import menu.view.InputView;
import menu.view.OutputView;


public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new InputView(), new OutputView());
        controller.execute();
    }
}
