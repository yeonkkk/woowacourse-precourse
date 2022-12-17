package menu.controller;

import menu.domain.Category;
import menu.domain.Coach;
import menu.utils.Generator;
import menu.utils.Menu;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

import static menu.utils.Constant.WEEK_LENGTH;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final Generator generator;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.generator = new Generator();
    }

    public void execute() {
        outputView.start();
        List<String> coachNames = inputView.enterCoach();
        List<Coach> coaches = inputView.enterMenuByAll(coachNames);
        Category category = new Category();
        recommendMenuFinal(coaches, totalCategory(category));
        outputView.recommendResult(coaches, category);
    }

    public void recommendMenuFinal(List<Coach> coaches, Category category) {
        for (Menu menu : category.getMenus()) {
            recommendMenuByDay(coaches, menu);
        }
    }


    public void recommendMenuByDay(List<Coach> coaches, Menu menu) {
        for (Coach coach : coaches) {
            selectMenu(coach, menu);
        }
    }

    public Category totalCategory(Category category) {
        for (int i = 0; i < WEEK_LENGTH; i++) {
            selectCategory(category);
        }
        return category;
    }


    public void selectCategory(Category category) {
        boolean result = false;
        while (!result) {
            Menu menu = generator.categoryGenerator();
            result = category.addCategory(menu);
        }
    }

    public void selectMenu(Coach coach, Menu menu) {
        boolean result = false;
        while (!result) {
            String recommendMenu = generator.menuGenerator(menu);
            result = coach.addRecommendMenu(recommendMenu);
        }
    }
}
