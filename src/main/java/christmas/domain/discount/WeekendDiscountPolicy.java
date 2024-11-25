package christmas.domain.discount;

import christmas.domain.Date;
import christmas.domain.order.Order;

public class WeekendDiscountPolicy implements DiscountPolicy {

    private static final int DISCOUNT_AMOUNT = 2023;

    @Override
    public int calculateDiscountAmount(final Date date, final Order order) {
        if (date.isWeekend() && order.isMainDish()) {
            return DISCOUNT_AMOUNT * order.getCount();
        }
        return 0;
    }
}
