package christmas.common;

public enum ErrorMessage {

    INVALID_INPUT_TYPE("숫자로 입력해주세요."),
    INVALID_INPUT_RANGE("12월 1일부터 12월 31일 사이의 날짜를 입력해주세요."),
    NOT_FOUND_DAY("날짜에 해당하는 요일을 찾을 수 없습니다."),

    INVALID_ORDER("음료만 주문할 수 없습니다."),
    INVALID_ORDER_COUNT("메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.")
    ;

    private static final String HEADER = "[ERROR] ";
    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return HEADER + message;
    }
}
