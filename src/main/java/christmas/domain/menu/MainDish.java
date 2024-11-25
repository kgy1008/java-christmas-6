package christmas.domain.menu;

import java.util.Map;

public class MainDish implements Menu {
    private static final Map<String, Integer> MENU_ITEMS = Map.of(
            "티본스테이크", 55000,
            "바비큐립", 54000,
            "해산물파스타", 35000,
            "크리스마스파스타", 25000
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

