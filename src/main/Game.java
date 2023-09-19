package main;

import main.utils.NumbersUtils;
import main.view.View;

import static main.utils.StringUtils.parseToNumbers;

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

        while (true) {
            String inputString = view.input();
            if (inputString.equals("1")) {
                return;
            }
            else if (inputString.equals("2")) {
                running = false;
                return;
            }
            else {
                view.print("[!] 제시된 항목에서 선택해주세요.");
            }
        }
    }
}
