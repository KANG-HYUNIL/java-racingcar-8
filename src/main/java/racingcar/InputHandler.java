package racingcar;
import camp.nextstep.edu.missionutils.Console;


public class InputHandler {

    public String getCarNamesInput(){
        System.out.println("자동차 이름?");
        return Console.readLine();
    }

    public String getTryCountInput(){
        System.out.println("시도할 횟수?");
        return Console.readLine();
    }

}
