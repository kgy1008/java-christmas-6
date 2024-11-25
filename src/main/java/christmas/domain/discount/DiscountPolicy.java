package christmas.domain.discount;

import christmas.domain.Date;

public interface DiscountPolicy {
    int calculateDiscountAmount(Date date);
}
