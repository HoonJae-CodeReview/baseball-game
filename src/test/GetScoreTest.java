package test;

import main.utils.NumbersUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import main.Numbers;

import java.util.ArrayList;
import java.util.List;

public class GetScoreTest {

    @ParameterizedTest()
    @CsvSource(
            value = {
                    "111:111:3",
                    "111:119:2",
                    "111:191:2",
                    "111:911:2",
                    "111:199:1",
                    "111:919:1",
                    "111:991:1",
                    "111:999:0",
            },
            delimiter = ':'
    )
    @DisplayName("올바른 Strike의 수를 셀 수 있다.")
    void getStrikeCountTest(String numbersString1, String numbersString2, int expected){
        // given
        Numbers numbers1 = new Numbers(NumbersUtils.convertToNumberList(getListOf(numbersString1)));
        Numbers numbers2 = new Numbers(NumbersUtils.convertToNumberList(getListOf(numbersString2)));

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
                    "123:913:1",
                    "123:239:2",
                    "123:312:3",
                    "123:231:3",
            },
            delimiter = ':'
    )
    @DisplayName("올바른 Ball의 수를 셀 수 있다.")
    void getBallCountTest(String numbersString1, String numbersString2, int expected){
        // given
        Numbers numbers1 = new Numbers(NumbersUtils.convertToNumberList(getListOf(numbersString1)));
        Numbers numbers2 = new Numbers(NumbersUtils.convertToNumberList(getListOf(numbersString2)));

        // when
        int strikeCount = numbers1.getCountOfSameNumberAtSameIndex(numbers2);
        int strikeOrBallCount = numbers1.getCountOfSameNumberAtAnyWhere(numbers2);

        // then
        int ballCount = strikeOrBallCount - strikeCount;
        Assertions.assertEquals(expected, ballCount);
    }

    List<Integer> getListOf(String stringValue) {
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<Numbers.LENGTH; i++) {
            int value = stringValue.charAt(i) - '0';
            result.add(value);
        }
        return result;
    }
}
