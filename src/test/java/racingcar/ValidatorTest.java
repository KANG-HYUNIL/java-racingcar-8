package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {

    @Test
    @DisplayName("정상적인 Car 이름에 대해서는 예외가 발생하지 않고 Car 이름 List가 반환.")
    void getCarNameString_ValidNames_NoException() {

        //given = 정상적 인 자동차 이름 문자열 제공
        String input = "car1,car2,car3";

        //when = validateAndParseCarNames 메서드 실행
        List<String> listCarName =  Validator.validateAndParseCarNames(input);

        //then = 예외가 발생하지 않음
        assertThat(listCarName).containsExactly("car1", "car2", "car3");
    }

    @Test
    @DisplayName("Car 이름이 5자를 초과할 경우 IllegalArgumentException 발생.")
    void getCarNameString_NameExceedsMaxLength_ThrowsException() {

        //given = 5자 초과 자동차 이름 문자열 제공
        String input = "carOne,car2,car3";

        //when, then = validateAndParseCarNames 메서드 실행 시 예외 발생 확인
        assertThatThrownBy(() -> Validator.validateAndParseCarNames(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Car 이름이 비어 있을 경우 IllegalArgumentException 발생.")
    void getCarNameString_EmptyName_ThrowsException() {

        //given = 비어 있는 자동차 이름 문자열 제공
        String input = "car1, ,car3";

        //when, then = validateAndParseCarNames 메서드 실행 시 예외 발생 확인
        assertThatThrownBy(() -> Validator.validateAndParseCarNames(input))
            .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("시도 횟수가 1 이상일 경우 예외가 발생하지 않고 시도 횟수가 반환.")
    void getAttemptCount_ValidCount_NoException() {

        //given = 정상적인 시도 횟수 문자열 제공
        String input = "5";

        //when = validateAndParseAttemptCount 메서드 실행
        int attemptCount = Validator.validateAndParseAttemptCount(input);

        //then = 예외가 발생하지 않음
        assertThat(attemptCount).isEqualTo(5);
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아닐 경우 IllegalArgumentException 발생.")
    void getAttemptCount_NonNumeric_ThrowsException() {

        //given = 숫자가 아닌 시도 횟수 문자열 제공
        String input = "five";

        //when, then = validateAndParseAttemptCount 메서드 실행 시 예외 발생 확인
        assertThatThrownBy(() -> Validator.validateAndParseAttemptCount(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수가 1 미만일 경우 IllegalArgumentException 발생.")
    void getAttemptCount_LessThanOne_ThrowsException() {

        //given = 1 미만 시도 횟수 문자열 제공
        String input = "0";

        //when, then = validateAndParseAttemptCount 메서드 실행 시 예외 발생 확인
        assertThatThrownBy(() -> Validator.validateAndParseAttemptCount(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
