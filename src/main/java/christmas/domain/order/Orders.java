package christmas.domain.order;

import java.util.Set;

public class Orders {

    private final Set<Order> orders;

    public Orders(final Set<Order> orders) {
        this.orders = orders;
    }
}
