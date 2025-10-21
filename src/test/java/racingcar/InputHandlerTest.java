package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import static org.assertj.core.api.Assertions.assertThat;

public class InputHandlerTest {


    private static final InputStream systemIn = System.in;

    private void provideInput(String data) {
        InputStream testIn = new java.io.ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @AfterEach
    void restoreSystemInputOutput() {
        System.setIn(systemIn);
    }

    @Test
    @DisplayName("입력한 자동차 이름 문자열 그대로 반환")
    void getCarNamesInput_Returns_UserInput() {

        //given = 사용자 입력 문자열 제공
        String input = "car1,car2,car3";
        provideInput(input + System.lineSeparator());
        InputHandler inputHandler = new InputHandler();

        //when = getCarNamesInput 메서드 실행
        String result = inputHandler.getCarNamesInput();

        //then = 입력한 문자열 그대로 반환 확인
        assertThat(result).isEqualTo(input);
    }

    @Test
    @DisplayName("입력한 시도 횟수 문자열 그대로 반환")
    void getTryCountInput_Returns_UserInput() {

        //given = 사용자 입력 문자열 제공
        String input = "5";
        provideInput(input + System.lineSeparator());
        InputHandler inputHandler = new InputHandler();

        //when = getTryCountInput 메서드 실행
        String result = inputHandler.getTryCountInput();

        //then = 입력한 문자열 그대로 반환 확인
        assertThat(result).isEqualTo(input);
    }

}
