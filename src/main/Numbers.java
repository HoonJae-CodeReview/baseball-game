package main;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Numbers {

    public static final int LENGTH = 3;

    private final List<Number_> numbers;

    public Numbers(List<Number_> numbers) {
        validateNumbersLength(numbers);
        validateNumbersDuplication(numbers);
        this.numbers = numbers;
    }

    private void validateNumbersLength(List<Number_> numbers) {
        int length = numbers.size();
        if (length != LENGTH) {
            throw new IllegalArgumentException(LENGTH + "개의 수가 주어져야 합니다.");
        }
    }

    private void validateNumbersDuplication(List<Number_> numbers) {
        Set<Integer> numbersSet = numbers.stream()
                .map(number -> number.getValue())
                .collect(Collectors.toSet());

        int listSize = numbers.size();
        int setSize = numbersSet.size();
        if (listSize != setSize) {
            throw new IllegalArgumentException("중복된 값은 허용되지 않습니다.");
        }
    }

    public Score getScore(Numbers answerNumbers) {
        Score score = new Score();

        for (Number_ number : numbers) {
            StrikeBallOut strikeBallOut = answerNumbers.determineSBO(number);
            score.addStrikeBallOut(strikeBallOut);
        }

        return score;
    }

    public StrikeBallOut determineSBO(Number_ targetNumber) {

        boolean isStrike = numbers.stream()
                .filter(number -> number.hasSameValue(targetNumber))
                .anyMatch(number -> number.hasSamePosition(targetNumber));

        if (isStrike) {
            return StrikeBallOut.STRIKE;
        }

        boolean isBall = numbers.stream()
                .anyMatch(number -> number.hasSameValue(targetNumber));

        if (isBall) {
            return StrikeBallOut.STRIKE;
        }

        return StrikeBallOut.OUT;
    }
}
