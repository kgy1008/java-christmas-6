package christmas.domain.order;

import static christmas.common.ErrorMessage.INVALID_ORDER_FORMAT;

import christmas.domain.menu.Beverage;
import christmas.domain.menu.Dessert;
import christmas.domain.menu.MainDish;
import christmas.domain.menu.Menu;

public class Order {

    private static final int MIN_ORDER_COUNT = 1;

    private final String name;
    private final int count;
    private final Menu menuType;

    public Order(final String name, final int count, final Menu menuType) {
        validateCount(count);
        this.name = name;
        this.count = count;
        this.menuType = menuType;
    }

    private void validateCount(final int count) {
        if (count < MIN_ORDER_COUNT) {
            throw new IllegalArgumentException(INVALID_ORDER_FORMAT.getMessage());
        }
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

    public int getPrice() {
        return menuType.getPrice(name);
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}
