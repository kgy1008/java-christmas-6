package christmas;

import christmas.config.AppConfig;
import christmas.controller.Controller;

public class Application {
    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        Controller controller = config.controller();
        controller.run();
    }
}
