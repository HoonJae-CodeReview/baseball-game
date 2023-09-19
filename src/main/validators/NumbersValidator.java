package main.validators;

import main.Numbers;

public final class NumbersValidator {

    private NumbersValidator() {}

    public static void validateNumbersLength(int[] numbers) {
        int length = numbers.length;
        if (length != Numbers.LENGTH) {
            throw new IllegalArgumentException(Numbers.LENGTH + "개로 이루어진 숫자를 입력해주세요.");
        }
    }

    public static void validateNumbersRange(int[] numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 9) {
                throw new IllegalArgumentException("1부터 9까지의 숫자들로 이루어진 수를 입력해주세요.");
            }
        }
    }
}
