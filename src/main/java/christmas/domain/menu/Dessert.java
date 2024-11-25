package christmas.domain.menu;

import java.util.Map;

public class Dessert implements Menu {
    private static final Map<String, Integer> MENU_ITEMS = Map.of(
            "초코케이크", 15000,
            "아이스크림", 5000
    );

    @Override
    public boolean isContain(final String name) {
        return MENU_ITEMS.containsKey(name);
    }

    @Override
    public int getPrice(final String name) {
        return MENU_ITEMS.get(name);
    }
}
