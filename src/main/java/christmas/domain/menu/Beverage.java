package christmas.domain.menu;

import java.util.Map;

public class Beverage implements Menu {
    private static final Map<String, Integer> MENU_ITEMS = Map.of(
            "제로콜라", 3000,
            "레드와인", 60000,
            "샴페인", 25000
    );

    @Override
    public boolean isContain(final String name) {
        return MENU_ITEMS.containsKey(name);
    }
}
