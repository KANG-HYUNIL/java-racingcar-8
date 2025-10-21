package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.assertj.core.api.Assertions.assertThat;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class GameControllerTest {

    private ByteArrayOutputStream outputStream;
    private static final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restoreSystemOutput() {
        System.setOut(systemOut);
        System.setIn(systemIn);
    }

    private void provideInput(String data) {
        InputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    static class TestNumberGenerator implements NumberGenerator {
        private final List<Integer> numberList;
        private int idx = 0;

        public TestNumberGenerator(List<Integer> numberList) {
            this.numberList = numberList;
        }

        @Override
        public int generate() {
            return numberList.get(idx++);
        }
    }

    @Test
    @DisplayName("전체 게임이 정상적으로 진행, 모든 과정 및 우승자 출력(모든 입력 정상 가정")
    void playGameSuccessfully() {

        // given = 사용자 입력 문자열 제공
        String input = "car1,car2" + System.lineSeparator() +
                "2" + System.lineSeparator();
        provideInput(input);

        // given = 테스트용 NumberGenerator 준비
        NumberGenerator testNumberGenerator = new TestNumberGenerator(

                //1회 : car1(4), car2(3)
                //2회 : car1(5), car2(2)
                List.of(4, 3, 5, 2)
        );
        GameController gameController = new GameController(testNumberGenerator);

        // when = 게임 진행
        gameController.playGame();

        // then = 모든 과정 및 우승자 출력 확인
        String output = outputStream.toString();
        assertThat(output)
                .contains("실행 결과")
                .contains("car1 : -")
                .contains("car2 : ")
                .contains("car1 : --")
                .contains("car2 : ")
                .contains("최종 우승자 : car1");

    }

}
