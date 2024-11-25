package christmas.domain.order;

import christmas.domain.menu.Dessert;
import christmas.domain.menu.MainDish;

public class Order {

    private final String name;
    private final int count;

    public Order(final String name, final int count) {
        this.name = name;
        this.count = count;
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
