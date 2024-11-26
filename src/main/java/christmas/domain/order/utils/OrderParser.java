package christmas.domain.order.utils;

import static christmas.common.ErrorMessage.INVALID_INPUT_TYPE;
import static christmas.common.ErrorMessage.INVALID_ORDER_MENU;

import christmas.domain.menu.Menu;
import christmas.domain.menu.Menus;
import christmas.domain.order.Order;
import christmas.domain.order.Orders;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderParser {

    private static final String DELIMITER = ",";
    private static final String SEPARATOR = "-";

    public static Orders parse(final String orderMenus, final Menus menus) {
        final String[] menuDetail = orderMenus.split(DELIMITER);

        Set<Order> orders = Arrays.stream(menuDetail)
                .map(menu -> {
                    menu = menu.trim();
                    String[] item = menu.split(SEPARATOR);
                    String name = item[0];
                    int price = convertToInt(item[1]);
                    Menu menuType = setMenuType(menus, name);
                    return new Order(name, price, menuType);
                })
                .collect(Collectors.toUnmodifiableSet());

        return new Orders(orders);
    }

    private static int convertToInt(final String price) {
        try {
            return Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_TYPE.getMessage());
        }
    }

    private static Menu setMenuType(final Menus menus, final String name) {
        return menus.getMenus().stream()
                .filter(menu -> menu.isContain(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_ORDER_MENU.getMessage()));
    }
}
