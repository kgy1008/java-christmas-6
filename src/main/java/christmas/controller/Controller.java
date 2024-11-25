package christmas.controller;

import christmas.domain.Date;
import christmas.domain.order.Orders;
import christmas.domain.order.utils.OrderParser;
import christmas.dto.OrderMenus;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.function.Supplier;

public class Controller {

    public void run() {
        Date date = inputDate();
        Orders orders = inputOrder();
        displayOrder(date, orders);
    }

    private Date inputDate() {
        OutputView.printWelcomeMessage();
        return retryTemplate(InputView::inputVisitDate);
    }

    private Orders inputOrder() {
        return retryTemplate(() -> {
            String orderedMenus = InputView.inputMenu();
            return OrderParser.parse(orderedMenus);
        });
    }

    private void displayOrder(final Date date, final Orders orders) {
        OutputView.printPreviewEventMessage(date.getDate());
        OutputView.printOrderedMenu(OrderMenus.of(orders.getOrders()));
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
