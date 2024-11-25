package christmas.domain.menu;

import java.util.Collections;
import java.util.Set;

public class Menus {

    private final Set<Menu> menus;

    public Menus(final Set<Menu> menus) {
        this.menus = menus;
    }

    public Set<Menu> getMenus() {
        return Collections.unmodifiableSet(menus);
    }
}
