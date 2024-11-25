package christmas.view;

import christmas.dto.DiscountPromotions;
import christmas.dto.OrderMenus;

public class OutputView {

    private static final String NEW_LINE = System.lineSeparator();
    private static final int DEFAULT_COUNT = 1;

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
        System.out.print(NEW_LINE);
    }

    public static void printErrorMessage(final String message) {
        System.out.println(message);
    }

    public static void printTotalPrice(final int totalPrice) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%,d원", totalPrice);
        System.out.println(NEW_LINE);
    }

    public static void printGift(final String gift) {
        System.out.println("<증정 메뉴>");
        if (gift.equals("샴페인")) {
            System.out.printf("%s %d개", gift, DEFAULT_COUNT);
            System.out.println(NEW_LINE);
            return;
        }
        System.out.println(gift + NEW_LINE);
    }

    public static void printPromotion(final DiscountPromotions discountPromotions) {
        System.out.println("<혜택 내역>");
        if (discountPromotions.discountPromotions().isEmpty()) {
            System.out.println("없음");
            return;
        }
        discountPromotions.discountPromotions().forEach(discountPromotion -> {
            String name = discountPromotion.policyName();
            int discountAmount = discountPromotion.discountAmount();
            System.out.printf("%s: -%,d원%s", name, discountAmount, NEW_LINE);
        });
        System.out.print(NEW_LINE);
    }

    public static void printTotalDiscountAmount(final int totalDiscountAmount) {
        System.out.println("<총혜택 금액>");
        System.out.printf("-" + "%,d원", totalDiscountAmount);
        System.out.println(NEW_LINE);
    }

    public static void printPayment(final int payment) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf("%,d", payment);
        System.out.println(NEW_LINE);
    }
}
