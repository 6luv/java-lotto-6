package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    private static final String INPUT_MONEY_GUIDE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTO_GUIDE = "당첨 번호를 입력해 주세요.";

    private Input() {}

    public static int inputMoney() {
        System.out.println(INPUT_MONEY_GUIDE);
        String money = Console.readLine();
        validateBlank(money);
        validateMoneyNumeric(money);
        return Integer.parseInt(money);
    }

    public static List<Integer> inputWinningLotto() {
        System.out.println(INPUT_WINNING_LOTTO_GUIDE);
        String winningLotto = Console.readLine();
        return Arrays.stream(winningLotto.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
        }
    }

    private static void validateMoneyNumeric(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }
}
