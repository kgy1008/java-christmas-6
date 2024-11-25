package christmas.domain.menu;

public enum Dessert {
    CHOCOLATE_CAKE("초코 케이크", 15_000),
    ICE_CREAM("아이스크림", 5_000);

    private final String name;
    private final int price;

    Dessert(final String name, final int price) {
        this.name = name;
        this.price = price;
    }
}
