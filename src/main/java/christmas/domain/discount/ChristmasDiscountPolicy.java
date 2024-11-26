package christmas.domain.discount;

import christmas.domain.Date;
import christmas.domain.order.Order;

public class ChristmasDiscountPolicy implements DiscountPolicy {

    private static final int START_DATE = 1;
    private static final int END_DATE = 25;
    private static final int INIT_DISCOUNT_PRICE = 1000;
    private static final int DISCOUNT_PRICE_UNIT = 100;

    private final String name;

    public ChristmasDiscountPolicy() {
        this.name = "크리스마스 디데이 할인";
    }

    @Override
    public int calculateDiscountAmount(final Date date, final Order order) {
        if (isDiscountApplicable(date)) {
            int period = date.getDate() - START_DATE;
            return INIT_DISCOUNT_PRICE + (period * DISCOUNT_PRICE_UNIT);
        }
        return 0;
    }

    private boolean isDiscountApplicable(final Date date) {
        return date.getDate() >= START_DATE && date.getDate() <= END_DATE;
    }

    @Override
    public String getName() {
        return name;
    }
}
