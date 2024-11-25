package christmas.controller;

import christmas.domain.Calculator;
import christmas.domain.Date;
import christmas.domain.Gift;
import christmas.domain.menu.Menus;
import christmas.domain.order.Orders;
import christmas.domain.order.utils.OrderParser;
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
        calculate(orders, date);
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

    private void calculate(final Orders orders, final Date date) {
        int totalPrice = calculateTotalPrice(orders);
        displayGift(totalPrice);
    }

    private int calculateTotalPrice(final Orders orders) {
        int totalPrice = calculator.calculateTotalPrice(orders.getOrders());
        OutputView.printTotalPrice(totalPrice);
        return totalPrice;
    }

    private void displayGift(final int totalPrice) {
        Gift gift = calculator.checkGift(totalPrice);
        OutputView.printGift(gift.getGift());
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
