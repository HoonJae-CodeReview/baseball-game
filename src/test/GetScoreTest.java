package test;

import main.Numbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GetScoreTest {

    @ParameterizedTest()
    @CsvSource(
            value = {
                    "000:000:3",
                    "000:001:2",
                    "000:010:2",
                    "000:100:2",
                    "000:011:1",
                    "000:101:1",
                    "000:110:1",
                    "000:111:0",
            },
            delimiter = ':'
    )
    @DisplayName("올바른 Strike의 수를 셀 수 있다.")
    void getStrikeCountTest(String numbersString1, String numbersString2, int expected){
        // given
        Numbers numbers1 = new Numbers(getArrayValueOf(numbersString1));
        Numbers numbers2 = new Numbers(getArrayValueOf(numbersString2));

        // when
        int strikeCount = numbers1.getCountOfSameNumberAtSameIndex(numbers2);

        // then
        Assertions.assertEquals(expected, strikeCount);
    }

    @ParameterizedTest()
    @CsvSource(
            value = {
                    "123:123:0",
                    "123:456:0",
                    "123:013:1",
                    "123:230:2",
                    "123:312:3",
                    "123:231:3",
            },
            delimiter = ':'
    )
    @DisplayName("올바른 Ball의 수를 셀 수 있다.")
    void getBallCountTest(String numbersString1, String numbersString2, int expected){
        // given
        Numbers numbers1 = new Numbers(getArrayValueOf(numbersString1));
        Numbers numbers2 = new Numbers(getArrayValueOf(numbersString2));

        // when
        int strikeCount = numbers1.getCountOfSameNumberAtSameIndex(numbers2);
        int strikeOrBallCount = numbers1.getCountOfSameNumberAtAnyWhere(numbers2);

        // then
        int ballCount = strikeOrBallCount - strikeCount;
        Assertions.assertEquals(expected, ballCount);
    }

    int[] getArrayValueOf(String stringValue) {
        int[] result = new int[Numbers.LENGTH];
        for (int i=0; i<Numbers.LENGTH; i++) {
            result[i] = stringValue.charAt(i) - '0';
        }
        return result;
    }
}
