package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import main.validators.NumbersValidator;

public class NumbersValidatorSuccessTest {

    @ParameterizedTest()
    @CsvSource(
            value = {
                    "1 2 3 4 5 6 7 8 9"
            },
            delimiter = ':'
    )
    @DisplayName("Numbers 입력에 대한 경계값을 허용한다.")
    void boundarySuccessTest(String stringValue) {
        String[] numbersString = stringValue.split(" ");
        int length = numbersString.length;
        int[] numbers = new int[length];
        for (int i=0; i<length; i++) {
            numbers[i] = Integer.parseInt(numbersString[i]);
        }
        NumbersValidator.validateNumbersRange(numbers);
    }
}
