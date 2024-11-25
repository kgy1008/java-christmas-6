package christmas.domain.order;

import static christmas.common.ErrorMessage.INVALID_ORDER_MENU;

import christmas.domain.menu.Appetizer;
import christmas.domain.menu.Beverage;
import christmas.domain.menu.Dessert;
import christmas.domain.menu.MainDish;

public class Order {

    private final String name;
    private final int count;

    public Order(final String name, final int count) {
        validate(name);
        this.name = name;
        this.count = count;
    }

    private void validate(final String name) {
        boolean isValidMenu = Appetizer.isContain(name) ||
                Beverage.isContain(name) ||
                Dessert.isContain(name) ||
                MainDish.isContain(name);

        if (!isValidMenu) {
            throw new IllegalArgumentException(INVALID_ORDER_MENU.getMessage());
        }
    }

    public boolean isDessert() {
        return Dessert.isContain(name);
    }

    public boolean isMainDish() {
        return MainDish.isContain(name);
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}
