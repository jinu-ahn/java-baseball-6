package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballController {
    private static final int INDEX_SIZE = 3;
    private static final int BALL = 0;
    private static final int STRIKE = 1;
    private static final int NOTHING = 2;
    private static final int NO_HIT = 0;
    private static final int MAX_HIT = 3;


    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private User user;
    private int[] result;
    private Computer computer;

    private User userNumber() {
        outputView.inputNumber();
        return new User(inputView.inputNumber());
    }

    private void resultCalculator() {
        List<Integer> userNumbers = user.getUserNumbers();
        List<Integer> computerNumbers = computer.getComputer();
        result = new int[INDEX_SIZE];
        for(int i=0;i<INDEX_SIZE;i++){
            if(isCoincide(computerNumbers.get(i),userNumbers.get(i))) continue;
            if(isContains(computerNumbers,userNumbers.get(i))) continue;
            result[NOTHING]++;
        }
    }

    private boolean isCoincide(int computerNumber, int userNumber) {
        if(computerNumber == userNumber) {
            result[STRIKE]++;
            return true;
        }
        return false;
    }
    private boolean isContains(List<Integer> computerNumbers, int userNumber){
        if(computerNumbers.contains(userNumber)) {
            result[BALL]++;
            return true;
        }
        return false;
    }

}
