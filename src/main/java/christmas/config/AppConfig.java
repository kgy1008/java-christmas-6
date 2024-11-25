package christmas.config;

import christmas.controller.Controller;
import christmas.domain.Calculator;
import christmas.domain.discount.ChristmasDiscountPolicy;
import christmas.domain.discount.DiscountPolicy;
import christmas.domain.discount.SpecialDiscountPolicy;
import christmas.domain.discount.WeekdayDiscountPolicy;
import christmas.domain.discount.WeekendDiscountPolicy;
import christmas.domain.menu.Appetizer;
import christmas.domain.menu.Beverage;
import christmas.domain.menu.Dessert;
import christmas.domain.menu.MainDish;
import christmas.domain.menu.Menu;
import christmas.domain.menu.Menus;
import java.util.List;
import java.util.Set;

public class AppConfig {

    public Controller controller() {
        return new Controller(calculator(), menus());
    }

    private Calculator calculator() {
        List<DiscountPolicy> policies = List.of(new ChristmasDiscountPolicy(), new SpecialDiscountPolicy(),
                new WeekdayDiscountPolicy(), new WeekendDiscountPolicy());
        return new Calculator(policies);
    }

    private Menus menus() {
        Set<Menu> menus = Set.of(
                new Appetizer(),
                new Beverage(),
                new Dessert(),
                new MainDish()
        );
        return new Menus(menus);
    }
}
