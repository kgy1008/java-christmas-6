package christmas.domain.menu;

import java.util.Map;

public class Appetizer implements Menu {
    private static final Map<String, Integer> MENU_ITEMS = Map.of(
            "양송이수프", 6000,
            "타파스", 5500,
            "시저샐러드", 8000
    );

    @Override
    public boolean isContain(final String name) {
        return MENU_ITEMS.containsKey(name);
    }
}

