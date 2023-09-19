package main;

import main.utils.NumbersUtils;
import main.view.View;

import static main.utils.StringUtils.parseToNumbers;
import static main.validators.ContinueOrExitValidator.validateContinueOrExitResponse;

public class Game {

    private final View view;
    private Numbers answer;
    private boolean running = true;

    public Game(View view) {
        this.view = view;
    }

    public void run() {
        while (running) {
            try {
                playGame();
                continueOrExit();
            }
            catch (IllegalArgumentException e) {
                view.print(e);
            }
        }
    }

    private void playGame() {

        randomizeAnswer();

        while (true) {
            view.requestNumber();

            String inputString = view.input();
            int[] inputNumbers = parseToNumbers(inputString);
            Numbers numbers = new Numbers(inputNumbers);

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
        int[] randomizedNumbers = NumbersUtils.getRandomizedNumbers(numberLength);
        answer = new Numbers(randomizedNumbers);
    }

    private void continueOrExit() {
        view.requestExit();
        String inputString = "";

        while (true) {
            inputString = view.input();
            try {
                validateContinueOrExitResponse(inputString);
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
