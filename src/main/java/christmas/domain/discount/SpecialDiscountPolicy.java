package christmas.domain.discount;

import christmas.domain.Date;
import christmas.domain.order.Order;

public class SpecialDiscountPolicy implements DiscountPolicy {

    private static final int DISCOUNT_AMOUNT = 1000;

    private final String name;

    public SpecialDiscountPolicy() {
        this.name = "특별 할인";
    }

    @Override
    public int calculateDiscountAmount(final Date date, final Order order) {
        if (date.isSpecialDate()) {
            return DISCOUNT_AMOUNT;
        }
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }
}
