package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RandomNumberGenerator rng = new RandomNumberGenerator();
        GameController gameController = new GameController(rng);
        gameController.playGame();
    }
}
