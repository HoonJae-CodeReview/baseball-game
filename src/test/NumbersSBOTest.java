package test;

import main.Numbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NumbersSBOTest {

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
    @DisplayName("올바른 스트라이크 수를 셀 수 있다.")
    void getStrikeCountTest(String numbersString1, String numbersString2, int expected){
        // given
        Numbers numbers1 = new Numbers(getArrayValueOf(numbersString1));
        Numbers numbers2 = new Numbers(getArrayValueOf(numbersString2));

        // when
        int strikeCount = numbers1.getCountOfSameNumberAtSameIndex(numbers2);

        // then
        Assertions.assertEquals(expected, strikeCount);
    }

    int[] getArrayValueOf(String stringValue) {
        int[] result = new int[Numbers.LENGTH];
        for (int i=0; i<Numbers.LENGTH; i++) {
            result[i] = stringValue.charAt(i) - '0';
        }
        return result;
    }

}
