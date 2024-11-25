package christmas.domain.discount;

import christmas.domain.Date;
import christmas.domain.order.Order;

public class WeekdayDiscountPolicy implements DiscountPolicy {

    private static final int DISCOUNT_AMOUNT = 2023;

    @Override
    public int calculateDiscountAmount(final Date date, final Order order) {
        if (date.isWeekday() && order.isDessert()) {
            return DISCOUNT_AMOUNT * order.getCount();
        }
        return 0;
    }
}
