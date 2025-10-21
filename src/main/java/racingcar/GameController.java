package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private List<Car> cars = new ArrayList<>();
    private int tryCount;
    private final NumberGenerator numberGenerator;

    public GameController(NumberGenerator numberGenerator){
        this.numberGenerator = numberGenerator;
    }

    private void initGame() {
        String carNamesInput = InputHandler.getCarNamesInput();
        String tryCountInput = InputHandler.getTryCountInput();

        List<String> carNames = Validator.validateAndParseCarNames(carNamesInput);
        this.tryCount = Validator.validateAndParseAttemptCount(tryCountInput);

        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    private void roundPlay() {

        List<String> positionStringList = new ArrayList<>();

        for (Car car : cars) {
            int randomNumber = numberGenerator.generate();
            car.moveForwardIfPossible(randomNumber);

            String positionString = car.getCurrentPositionString();
            positionStringList.add(positionString);
        }

        OutputHandler.printCarPositions(positionStringList);
    }

    private void determineWinnersAndPrint() {

        List<String> winnerNames = new ArrayList<>();
        int maxForwardCount = -1;

        for (Car car : cars) {
            int carForwardCount = car.getForwardCount();
            if (carForwardCount > maxForwardCount) {
                maxForwardCount = carForwardCount;
                winnerNames.clear();
                winnerNames.add(car.getCarName());
            } else if (carForwardCount == maxForwardCount) {
                winnerNames.add(car.getCarName());
            }
        }

        OutputHandler.printFinalWinnersName(winnerNames);
    }


    public void playGame() {
        this.initGame();

        OutputHandler.printRoundResult();

        for (int round = 0; round < tryCount; round++) {
            roundPlay();
        }

        determineWinnersAndPrint();
    }


}
