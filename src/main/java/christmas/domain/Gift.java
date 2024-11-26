package christmas.domain;

public enum Gift {
    NONE("없음", 0),
    CHAMPAGNE("샴페인", 25_000);

    private final String gift;
    private final int price;

    Gift(final String gift, final int price) {
        this.gift = gift;
        this.price = price;
    }

    public String getGift() {
        return gift;
    }

    public int getPrice() {
        return price;
    }
}
