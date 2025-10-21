package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("Car이 4 이상을 받으면 전진한다.")
    void carMoveForward_When_NumberIs4OrMore() {

        //given = 차 이름, 4 이상의 숫자
        Car car = new Car("TestCar");
        int testNumber = 5; // 4 이상인 숫자 설정

        //when = moveForwardIfPossible 메서드 실행
        car.moveForwardIfPossible(testNumber);

        //then = 전진 횟수 1 증가 확인
        assertThat(car.getForwardCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("Car이 3 이하를 받으면 전진하지 않는다.")
    void carNotMoveForward_When_NumberIs3OrLess() {

        // given = 차 이름, 3 이하의 숫자
        Car car = new Car("TestCar");
        int testNumber = 2; // 3 이하인 숫자 설정

        // when = moveForwardIfPossible 메서드 실행
        car.moveForwardIfPossible(testNumber);

        // then = 전진 횟수 증가하지 않음 확인
        assertThat(car.getForwardCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("Car 현재 위치를 요구된 형식의 문자열로 반환해야 한다")
    void getCurrentPositionString_Returns_CorrectFormat() {

        //given = 차 이름, 전진 횟수 설정
        Car car = new Car("TestCar");
        int testNumber = 5; // 4 이상인 숫자 설정
        car.moveForwardIfPossible(testNumber); // 전진 1회
        car.moveForwardIfPossible(testNumber); // 전진 1회 더해서 총 2회 전진

        //when = getCurrentPositionString 메서드 실행
        String positionString = car.getCurrentPositionString();

        //then = 요구된 형식의 문자열 반환 확인
        assertThat(positionString).isEqualTo("TestCar : --");
    }


}
