package christmas.domain;

import christmas.domain.discount.DiscountPolicy;
import christmas.domain.order.Order;
import christmas.domain.order.Orders;
import christmas.dto.DiscountPromotion;
import christmas.dto.DiscountPromotions;
import java.util.HashSet;
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

    public DiscountPromotions calculateDiscountAmount(final Orders orders, final Date date, final Gift gift) {
        Set<DiscountPromotion> discount = new HashSet<>();
        for (Order order : orders.getOrders()) {
            for (DiscountPolicy discountPolicy : discountPolicies) {
                int amount = discountPolicy.calculateDiscountAmount(date, order);
                if (amount > 0) {
                    DiscountPromotion discountPromotion = new DiscountPromotion(discountPolicy.getName(), amount);
                    discount.add(discountPromotion);
                }
            }
        }
        if (gift == Gift.CHAMPAGNE) {
            discount.add(new DiscountPromotion("증정 이벤트", gift.getPrice()));
        }
        return new DiscountPromotions(discount);
    }
}
