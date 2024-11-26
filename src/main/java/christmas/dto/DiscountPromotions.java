package christmas.dto;

import java.util.Set;

public record DiscountPromotions(
        Set<DiscountPromotion> discountPromotions
) {
    public int getTotalBenefitAmount() {
        return discountPromotions.stream()
                .mapToInt(DiscountPromotion::discountAmount)
                .sum();
    }

    public int getTotalDiscountAmount() {
        return discountPromotions.stream()
                .filter(discountPromotion -> !discountPromotion.policyName().equals("증정 이벤트"))
                .mapToInt(DiscountPromotion::discountAmount)
                .sum();
    }
}
