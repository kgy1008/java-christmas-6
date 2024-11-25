package christmas.view;

import christmas.dto.OrderMenus;

public class OutputView {

    private static final String NEW_LINE = System.lineSeparator();

    public static void printWelcomeMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printPreviewEventMessage(final int date) {
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!", date);
        System.out.println(NEW_LINE);
    }

    public static void printOrderedMenu(final OrderMenus orderMenus) {
        System.out.println("<주문 메뉴>");
        orderMenus.menus().forEach(orderMenu -> {
            String name = orderMenu.name();
            int count = orderMenu.count();
            System.out.printf("%s %d개%s", name, count, NEW_LINE);
        });
        System.out.println(NEW_LINE);
    }

    public static void printErrorMessage(final String message) {
        System.out.println(message);
    }

    public static void printTotalPrice(final int totalPrice) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%,d원",totalPrice);
        System.out.println(NEW_LINE);
    }
}
