package christmas.domain;

import christmas.domain.discount.DiscountPolicy;
import christmas.domain.order.Order;
import christmas.domain.order.Orders;
import christmas.dto.DiscountPromotion;
import christmas.dto.DiscountPromotions;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Calculator {

    private static final int MIN_PRICE_TO_GET_GIFT = 120_000;
    private static final int MIN_PRICE_TO_APPLY_EVENT = 10_000;
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

    public DiscountPromotions calculateDiscountAmount(final Orders orders, final Date date, final int totalPrice) {
        if (totalPrice < MIN_PRICE_TO_APPLY_EVENT) {
            return new DiscountPromotions(new HashSet<>());
        }

        Set<DiscountPromotion> discountPromotions = calculateDiscountForOrders(orders, date);
        addGiftPromotionIfApplicable(discountPromotions, checkGift(totalPrice));
        return new DiscountPromotions(discountPromotions);
    }

    private Set<DiscountPromotion> calculateDiscountForOrders(final Orders orders, final Date date) {
        return orders.getOrders().stream()
                .flatMap(order -> calculateDiscountForOrder(order, date).stream())
                .collect(Collectors.toSet());
    }

    private List<DiscountPromotion> calculateDiscountForOrder(final Order order, final Date date) {
        return discountPolicies.stream()
                .map(discountPolicy -> {
                    int amount = discountPolicy.calculateDiscountAmount(date, order);
                    if (amount > 0) {
                        return new DiscountPromotion(discountPolicy.getName(), amount);
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .toList();
    }

    private void addGiftPromotionIfApplicable(final Set<DiscountPromotion> discountPromotions, final Gift gift) {
        if (gift == Gift.CHAMPAGNE) {
            discountPromotions.add(new DiscountPromotion("증정 이벤트", gift.getPrice()));
        }
    }
}
