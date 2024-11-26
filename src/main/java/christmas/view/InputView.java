package christmas.view;

import static christmas.common.ErrorMessage.INVALID_INPUT_TYPE;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Date;

public class InputView {

    public static Date inputVisitDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String answer = Console.readLine();
        int day = convertToInt(answer);
        return new Date(day);
    }

    public static String inputMenu() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        return Console.readLine();
    }

    private static int convertToInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_TYPE.getMessage());
        }
    }
}
