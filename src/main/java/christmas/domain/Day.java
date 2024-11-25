package christmas.domain;

import static christmas.common.ErrorMessage.NOT_FOUND_DAY;

import java.util.Arrays;
import java.util.List;

public enum Day {

    MONDAY(List.of(4, 11, 18, 25)),
    TUESDAY(List.of(5, 12, 19, 26)),
    WEDNESDAY(List.of(6, 13, 20, 27)),
    THURSDAY(List.of(7, 14, 21, 28)),
    FRIDAY(List.of(1, 8, 15, 22, 29)),
    SATURDAY(List.of(2, 9, 16, 23, 30)),
    SUNDAY(List.of(3, 10, 17, 24, 31));

    private final List<Integer> days;

    Day(final List<Integer> days) {
        this.days = days;
    }

    public static Day find(final int day) {
        return Arrays.stream(Day.values())
                .filter(d -> d.contains(day))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_DAY.getMessage()));
    }

    private boolean contains(final int day) {
        return days.contains(day);
    }
}
