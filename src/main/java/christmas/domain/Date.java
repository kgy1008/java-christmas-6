package christmas.domain;

import static christmas.common.ErrorMessage.INVALID_INPUT_RANGE;

public class Date {

    private static final int MIN_DAY = 1;
    private static final int MAX_DAY = 31;

    private final int day;

    public Date(final int day) {
        validateRange(day);
        this.day = day;
    }

    private void validateRange(final int day) {
        if (day < MIN_DAY || day > MAX_DAY) {
            throw new IllegalArgumentException(INVALID_INPUT_RANGE.getMessage());
        }
    }

    private Day findDay() {
        return Day.find(day);
    }
}
