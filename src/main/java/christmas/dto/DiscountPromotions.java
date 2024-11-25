package christmas.dto;

import java.util.Set;

public record DiscountPromotions(
        Set<DiscountPromotion> discountPromotions
) {
    public int getTotalDiscountAmount() {
        return discountPromotions.stream()
                .mapToInt(DiscountPromotion::discountAmount)
                .sum();
    }
}
