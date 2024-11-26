package christmas.domain.discount;

import christmas.domain.Date;
import christmas.domain.order.Order;

public interface DiscountPolicy {
    int calculateDiscountAmount(final Date date, final Order order);
    String getName();
}
