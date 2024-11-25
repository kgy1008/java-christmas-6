package christmas.domain;

import christmas.domain.discount.DiscountPolicy;
import christmas.domain.order.Order;
import christmas.domain.order.Orders;
import java.util.List;
import java.util.Set;

public class Calculator {

    private final List<DiscountPolicy> discountPolicies;

    public Calculator(final List<DiscountPolicy> discountPolicies) {
        this.discountPolicies = discountPolicies;
    }

    public int calculateTotalPrice(final Set<Order> orders) {
        return orders.stream()
                .mapToInt(order -> order.getCount() * order.getPrice())
                .sum();
    }
}
