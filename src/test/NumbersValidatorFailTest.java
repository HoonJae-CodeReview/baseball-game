package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static main.validators.NumbersValidator.validateNumbersRange;

public class NumbersValidatorFailTest {

    @ParameterizedTest()
    @CsvSource(
            value = {
                    "0 1 2",
                    "8 9 10",
            },
            delimiter = ':'
    )
    @DisplayName("Numbers 입력에 대한 경계값 미만 및 초과를 불허한다.")
    void boundarySuccessTest(String stringValue) {
        String[] numbersString = stringValue.split(" ");
        int length = numbersString.length;
        int[] numbers = new int[length];
        for (int i=0; i<length; i++) {
            numbers[i] = Integer.parseInt(numbersString[i]);
        }
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validateNumbersRange(numbers);
        });
    }
}
