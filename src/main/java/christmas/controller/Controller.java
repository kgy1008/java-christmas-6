package christmas.controller;

import christmas.domain.Calculator;
import christmas.domain.Date;
import christmas.domain.Gift;
import christmas.domain.menu.Menus;
import christmas.domain.order.Orders;
import christmas.domain.order.utils.OrderParser;
import christmas.dto.DiscountPromotions;
import christmas.dto.OrderMenus;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.function.Supplier;

public class Controller {

    private final Calculator calculator;
    private final Menus menus;

    public Controller(final Calculator calculator, final Menus menus) {
        this.calculator = calculator;
        this.menus = menus;
    }

    public void run() {
        Date date = inputDate();
        Orders orders = inputOrder();
        displayOrder(date, orders);
        calculateAndDisplay(orders, date);
    }

    private Date inputDate() {
        OutputView.printWelcomeMessage();
        return retryTemplate(InputView::inputVisitDate);
    }

    private Orders inputOrder() {
        return retryTemplate(() -> {
            String orderedMenus = InputView.inputMenu();
            return OrderParser.parse(orderedMenus, menus);
        });
    }

    private void displayOrder(final Date date, final Orders orders) {
        OutputView.printPreviewEventMessage(date.getDate());
        OutputView.printOrderedMenu(OrderMenus.of(orders.getOrders()));
    }

    private void calculateAndDisplay(final Orders orders, final Date date) {
        int totalPrice = calculateTotalPrice(orders);
        OutputView.printTotalPrice(totalPrice);
        Gift gift = displayGift(totalPrice);
        DiscountPromotions discountPromotions = calculateDiscountAmount(orders, date, gift);
        displayBenefit(discountPromotions);
    }

    private int calculateTotalPrice(final Orders orders) {
        return calculator.calculateTotalPrice(orders.getOrders());
    }

    private Gift displayGift(final int totalPrice) {
        Gift gift = calculator.checkGift(totalPrice);
        OutputView.printGift(gift.getGift());
        return gift;
    }

    private DiscountPromotions calculateDiscountAmount(final Orders orders, final Date date, final Gift gift) {
        return calculator.calculateDiscountAmount(orders, date, gift);
    }

    private void displayBenefit(final DiscountPromotions discountPromotions) {
        OutputView.printPromotion(discountPromotions);
        OutputView.printTotalDiscountAmount(discountPromotions.getTotalDiscountAmount());
    }

    private <T> T retryTemplate(final Supplier<T> action) {
        while (true) {
            try {
                return action.get();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void retryTemplate(final Runnable action) {
        while (true) {
            try {
                action.run();
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
