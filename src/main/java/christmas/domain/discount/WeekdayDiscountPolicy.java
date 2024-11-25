package christmas.domain.discount;

import christmas.domain.Date;
import christmas.domain.order.Order;

public class WeekdayDiscountPolicy implements DiscountPolicy {

    private static final int DISCOUNT_AMOUNT = 2023;

    private final String name;

    public WeekdayDiscountPolicy() {
        this.name = "평일 할인";
    }

    @Override
    public int calculateDiscountAmount(final Date date, final Order order) {
        if (date.isWeekday() && order.isDessert()) {
            return DISCOUNT_AMOUNT * order.getCount();
        }
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }
}
