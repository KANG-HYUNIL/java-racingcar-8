package racingcar;

import java.util.List;

public final class OutputHandler {

    private static final String finalWinners = "최종 우승자 : ";

    public static void printRoundResult(){
        System.out.println();
        System.out.println("실행 결과");
    }


    public static void printCarPositions(List<String> carPositionString) {

        for (String positionString : carPositionString) {
            System.out.println(positionString);
        }
        System.out.println();
    }

    public static void printFinalWinnersName(List<String> winnerNames) {
        String winners = String.join(", ", winnerNames);
        System.out.println(finalWinners + winners);
    }

}
