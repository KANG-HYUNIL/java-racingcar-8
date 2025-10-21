package racingcar;

import java.util.List;

public class Validator {

    private static final int MAX_NAME_LENGTH = 5;


    private static void checkCarNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    private static void checkEmptyCarName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
        }
    }

    private static void validateCarName(String name) {
        checkEmptyCarName(name);
        checkCarNameLength(name);
    }

    public static void validateCarNames(List<String> names) {
        for (String name : names) {
            validateCarName(name);
        }
    }

    public static void validateAttemptCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
        }
    }

    public static List<String> validateAndParseCarNames(String input) {

        List<String> carNames = List.of(input.split(","));
        validateCarNames(carNames);
        return carNames;
    }

    public static int validateAndParseAttemptCount(String input) {
        try {
            int count = Integer.parseInt(input);
            validateAttemptCount(count);
            return count;
        } catch (Exception e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

}
