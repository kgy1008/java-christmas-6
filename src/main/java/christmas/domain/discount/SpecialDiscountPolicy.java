package christmas.domain.discount;

import christmas.domain.Date;

public class SpecialDiscountPolicy implements DiscountPolicy {

    private static final int DISCOUNT_AMOUNT = 1000;

    @Override
    public int calculateDiscountAmount(final Date date) {
        if (date.isSpecialDate()) {
            return DISCOUNT_AMOUNT;
        }
        return 0;
    }
}
