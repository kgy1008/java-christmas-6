package christmas.domain.order;

import static christmas.common.ErrorMessage.INVALID_ORDER;
import static christmas.common.ErrorMessage.INVALID_ORDER_COUNT;

import christmas.domain.menu.Beverage;
import java.util.Set;

public class Orders {

    private static final int MAX_ORDER_COUNT = 20;

    private final Set<Order> orders;

    public Orders(final Set<Order> orders) {
        validate(orders);
        this.orders = orders;
    }

    private void validate(final Set<Order> orders) {
        validateOrders(orders);
        validateOrderCount(orders);
    }

    private void validateOrders(final Set<Order> orders) {
        boolean allOrdersAreBeverages = orders.stream()
                .allMatch(order -> Beverage.isContain(order.getName()));

        if (allOrdersAreBeverages) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }

    private void validateOrderCount(final Set<Order> orders) {
        int totalCount = orders.stream()
                .mapToInt(Order::getCount)
                .sum();

        if (totalCount > MAX_ORDER_COUNT) {
            throw new IllegalArgumentException(INVALID_ORDER_COUNT.getMessage());
        }
    }
}
