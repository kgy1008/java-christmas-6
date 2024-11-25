package christmas.domain;

import christmas.domain.discount.DiscountPolicy;
import christmas.domain.order.Order;
import java.util.List;
import java.util.Set;

public class Calculator {

    private static final int MIN_PRICE_TO_GET_GIFT = 120_000;
    private final List<DiscountPolicy> discountPolicies;

    public Calculator(final List<DiscountPolicy> discountPolicies) {
        this.discountPolicies = discountPolicies;
    }

    public int calculateTotalPrice(final Set<Order> orders) {
        return orders.stream()
                .mapToInt(order -> order.getCount() * order.getPrice())
                .sum();
    }

    public Gift checkGift(final int totalPrice) {
        if (totalPrice >= MIN_PRICE_TO_GET_GIFT) {
            return Gift.CHAMPAGNE;
        }
        return Gift.NONE;
    }
}
