package christmas.domain.order;

import christmas.domain.menu.Beverage;
import christmas.domain.menu.Dessert;
import christmas.domain.menu.MainDish;
import christmas.domain.menu.Menu;

public class Order {

    private final String name;
    private final int count;
    private final Menu menuType;

    public Order(final String name, final int count, final Menu menuType) {
        this.name = name;
        this.count = count;
        this.menuType = menuType;
    }

    public boolean isDessert() {
        return menuType instanceof Dessert;
    }

    public boolean isMainDish() {
        return menuType instanceof MainDish;
    }

    public boolean isBeverage() {
        return menuType instanceof Beverage;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}
