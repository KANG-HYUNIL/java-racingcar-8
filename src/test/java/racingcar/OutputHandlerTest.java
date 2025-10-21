package racingcar;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputHandlerTest {

    private ByteArrayOutputStream outputStream;
    private final PrintStream systemOut = System.out;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restoreSystemOutput() {
        System.setOut(systemOut);
    }


    @Test
    @DisplayName("OutputHandler가 각 Car들의 진행 상황을 정상적으로 출력")
    void getCarPositions_Print_Correctly() {

        //given = 출력할 Car 위치 문자열 배열 준비
        List<String> carPositions = List.of(
                "car1 : ---",
                "car2 : --",
                "car3 : ----"
        );
        String expectedOutput = "car1 : ---" + System.lineSeparator() +
                "car2 : --" + System.lineSeparator() +
                "car3 : ----" + System.lineSeparator() +
                System.lineSeparator();


        // when = printCarPositions 메서드 실행
        OutputHandler.printCarPositions(carPositions);

        // then =
        assertThat(outputStream.toString()).isEqualTo(expectedOutput);
    }

    @Test
    @DisplayName("OutputHandler가 최종 우승자 이름들을 정상적으로 출력")
    void getFinalWinnersName_Print_Correctly() {

        //given = 출력할 우승자 이름 리스트 준비
        List<String> winnerNames = List.of("car1", "car3");
        String expectedOutput = "최종 우승자 : car1, car3" + System.lineSeparator();

        // when = printFinalWinnersName 메서드 실행
        OutputHandler.printFinalWinnersName(winnerNames);

        // then =
        assertThat(outputStream.toString()).isEqualTo(expectedOutput);

    }




}
