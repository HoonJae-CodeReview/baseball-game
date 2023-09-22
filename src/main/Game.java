package main;

import main.utils.NumbersUtils;
import main.view.View;
import main.utils.StringUtils;
import main.validators.ContinueOrExitValidator;

import java.util.List;

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
            int strikeCount = score.getStrikeCount();
            if (strikeCount == Numbers.LENGTH) {
                view.congratulate();
                return;
            }

            view.print(score);
        }
    }

    private void randomizeAnswer() {
        int numberLength = Numbers.LENGTH;
        List<Integer> randomizedNumbers = NumbersUtils.getRandomizedNumbers(numberLength);
        answer = new Numbers(randomizedNumbers);
    }

    private Numbers tryToMakeNumbersByInput() {
        while (true) {
            view.requestNumber();
            String inputString = view.input();
            List<Integer> inputNumbers = StringUtils.parseToNumbers(inputString);
            try {
                return new Numbers(inputNumbers);
            }
            catch (Exception e) {
                view.print(e);
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
                view.print(e);
            }
        }

        if (inputString.equals("2")) {
            running = false;
        }
    }
}
