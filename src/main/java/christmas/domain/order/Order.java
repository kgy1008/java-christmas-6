package christmas.domain.order;

import christmas.domain.menu.Dessert;

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

    public int getCount() {
        return count;
    }
}
