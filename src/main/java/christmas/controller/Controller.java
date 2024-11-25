package christmas.controller;

import christmas.domain.Date;
import christmas.domain.order.Orders;
import christmas.domain.order.utils.OrderParser;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.function.Supplier;

public class Controller {

    public void run() {
        inputOrder();
    }

    private Orders inputOrder() {
        OutputView.printWelcomeMessage();
        Date date = retryTemplate(InputView::inputVisitDate);
        return retryTemplate(() -> {
            String orderedMenus = InputView.inputMenu();
            return parseOrder(orderedMenus);
        });
    }

    private Orders parseOrder(final String orderMenus) {
        return OrderParser.parse(orderMenus);
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
