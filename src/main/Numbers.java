package main;

import java.util.HashMap;
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

    private HashMap<Integer, Integer> getNumberCountsFromArray(List<Integer> values) {
        HashMap<Integer, Integer> balls = new HashMap<>();
        for (int value : values){
            int numberCountOfCurrentValue = balls.getOrDefault(value, 0);
            balls.put(value, numberCountOfCurrentValue + 1);
        }
        return balls;
    }

    public Score getScore(Numbers answerNumbers) {
        Score score = new Score();

        for (Number_ number : numbers) {
            SBO sbo = answerNumbers.determineSBO(number);
            score.addSBO(sbo);
        }

        return score;
    }

    public SBO determineSBO(Number_ targetNumber) {

        for (Number_ number : numbers) {

            boolean hasSameValue = number.hasSameValue(targetNumber);
            boolean hasSamePosition = number.hasSamePosition(targetNumber);

            if (hasSameValue && hasSamePosition) {
                return SBO.STRIKE;
            }

            if (hasSameValue && !hasSamePosition) {
                return SBO.BALL;
            }
        }

        return SBO.OUT;
    }
}
