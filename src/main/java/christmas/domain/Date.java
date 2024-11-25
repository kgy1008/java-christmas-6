package christmas.domain;

import static christmas.common.ErrorMessage.INVALID_INPUT_RANGE;

public class Date {

    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;
    private static final int CHRISTMAS_DATE = 25;

    private final int date;
    private final boolean isSpecialDate;

    public Date(final int date) {
        validateRange(date);
        this.date = date;
        this.isSpecialDate = setIsStared();
    }

    private void validateRange(final int day) {
        if (day < MIN_DATE || day > MAX_DATE) {
            throw new IllegalArgumentException(INVALID_INPUT_RANGE.getMessage());
        }
    }

    private boolean setIsStared() {
        return findDay() == Day.SUNDAY || date == CHRISTMAS_DATE;
    }

    private Day findDay() {
        return Day.find(date);
    }
}
