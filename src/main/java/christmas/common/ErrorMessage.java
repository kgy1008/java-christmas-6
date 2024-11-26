package christmas.common;

public enum ErrorMessage {

    INVALID_INPUT_TYPE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_INPUT_RANGE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    NOT_FOUND_DAY("날짜에 해당하는 요일을 찾을 수 없습니다."),

    INVALID_ORDER("음료만 주문할 수 없습니다."),
    INVALID_ORDER_COUNT("메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다."),
    INVALID_ORDER_MENU("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_ORDER_FORMAT("유효하지 않은 주문입니다. 다시 입력해 주세요.")
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
