package christmas.dto;

import christmas.domain.order.Order;
import java.util.List;
import java.util.Set;

public record OrderMenus(
        List<OrderMenu> menus
) {
    public static OrderMenus of(final Set<Order> orders) {
        List<OrderMenu> menus = orders.stream()
                .map(order -> new OrderMenu(order.getName(), order.getCount()))
                .toList();

        return new OrderMenus(menus);
    }
}
