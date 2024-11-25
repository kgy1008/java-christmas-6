package christmas.view;

public class OutputView {

    public static void printWelcomeMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printPreviewEventMessage(final int day) {
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!", day);
        System.out.println();
    }

    public static void printErrorMessage(final String message) {
        System.out.println(message);
    }
}
