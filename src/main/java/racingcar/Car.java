package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

/**
 * Car 클래스는 자동차의 이름, 전진 횟수 나타내는 역할을 합니다.
 */
public class Car {

    private final String carName;
    private int forwardCount = 0;
    private static final String forwardString = "-";
    private static final int MOVE_THRESHOLD = 4;


    public Car(String carName){
        this.carName = carName;
        this.forwardCount = 0;
    }


    public String getCurrentPositionString(){
        return carName + " : " + forwardString.repeat(forwardCount);
    }


    public void moveForwardIfPossible(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            forwardCount++;
        }
    }

    public int getForwardCount(){
        return forwardCount;
    }

    public String getCarName(){
        return carName;
    }


}
