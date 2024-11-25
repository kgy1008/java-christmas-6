package christmas.domain;

public enum Gift {
    NONE("없음"),
    CHAMPAGNE("샴페인");

    private final String gift;

    Gift(final String gift) {
        this.gift = gift;
    }

    public String getGift() {
        return gift;
    }
}
