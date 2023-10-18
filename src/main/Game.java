package main;

import main.utils.NumbersUtils;
import main.view.View;
import main.utils.StringUtils;
import main.validators.ContinueOrExitValidator;

import java.util.List;

import static main.utils.NumbersUtils.getRandomizedNumbers;

public class Game {

    private final View view;
    private Numbers answer;
    private boolean running = true;

    public Game(View view) {
        this.view = view;
    }

    public void run() {
        while (running) {
            playGame();
            continueOrExit();
        }
    }

    private void playGame() {

        randomizeAnswer();

        while (true) {
            Numbers numbers = tryToMakeNumbersByInput();

            Score score = numbers.getScore(answer);
            int strikeCount = score.getSBO(SBO.STRIKE);
            if (strikeCount == Numbers.LENGTH) {
                view.congratulate();
                return;
            }

            view.printScore(score);
        }
    }

    private void randomizeAnswer() {
        int numberLength = Numbers.LENGTH;
        answer = getRandomizedNumbers(numberLength);
    }

    private Numbers tryToMakeNumbersByInput() {
        while (true) {
            view.requestNumber();
            String inputString = view.input();
            List<Integer> inputIntegers = StringUtils.parseToIntegers(inputString);
            try {
                return NumbersUtils.convertToNumbers(inputIntegers);
            }
            catch (Exception e) {
                view.printError(e);
            }
        }
    }

    private void continueOrExit() {
        view.requestExit();
        String inputString = "";

        while (true) {
            inputString = view.input();
            try {
                ContinueOrExitValidator.validateContinueOrExitResponse(inputString);
                break;
            }
            catch (IllegalArgumentException e) {
                view.printError(e);
            }
        }

        if (inputString.equals("2")) {
            running = false;
        }
    }
}
