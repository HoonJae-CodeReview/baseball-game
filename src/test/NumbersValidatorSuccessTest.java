package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import main.validators.NumbersValidator;

import java.util.ArrayList;
import java.util.List;

public class NumbersValidatorSuccessTest {

    @ParameterizedTest()
    @CsvSource(
            value = {
                    "1 9"
            },
            delimiter = ':'
    )
    @DisplayName("Numbers 입력에 대한 경계값을 허용한다.")
    void boundarySuccessTest(String stringValue) {
        String[] numbersString = stringValue.split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (String numberString : numbersString) {
            int number = Integer.parseInt(numberString);
            numbers.add(number);
        }
        NumbersValidator.validateNumbersRange(numbers);
    }
}
