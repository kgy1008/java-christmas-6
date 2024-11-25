package christmas.domain;

import java.util.Arrays;
import java.util.Comparator;

public enum Badge {

    NONE("없음", 0),
    STAR("별", 5_000),
    TREE("트리", 10_000),
    SANTA("산타", 20_000);

    private final String name;
    private final int baseBenefitAmount;

    Badge(final String name, final int baseBenefitAmount) {
        this.name = name;
        this.baseBenefitAmount = baseBenefitAmount;
    }

    public static Badge fromAmount(final int amount) {
        return Arrays.stream(values())
                .filter(badge -> amount >= badge.baseBenefitAmount)
                .max(Comparator.comparingInt(badge -> badge.baseBenefitAmount))
                .orElse(NONE);
    }

    public String getName() {
        return name;
    }
}
