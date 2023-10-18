package test;

import main.Numbers;
import main.SBO;
import main.Score;
import main.utils.NumbersUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

public class GetScoreTest {

    @ParameterizedTest()
    @CsvSource(
            value = {
                    "123:123:3:0:0",
                    "123:124:2:0:1",
                    "123:132:1:2:0",
                    "123:134:1:1:1",
                    "123:214:0:2:1",
                    "123:245:0:1:2",
                    "123:456:0:0:3",
            },
            delimiter = ':'
    )
    @DisplayName("2개의 숫자들이 주어졌을 때 Strike, Ball, Out 을 판별할 수 있다.")
    void SBO_판별_테스트(
            String numbersString1,
            String numbersString2,
            int expectedStrike,
            int expectedBall,
            int expectedOut
    ){
        // given
        Numbers numbers1 = NumbersUtils.convertToNumbers(getListOf(numbersString1));
        Numbers numbers2 = NumbersUtils.convertToNumbers(getListOf(numbersString2));

        // when
        Score score = numbers2.getScore(numbers1);
        int strikeCount = score.getSBO(SBO.STRIKE);
        int ballCount = score.getSBO(SBO.BALL);
        int outCount = score.getSBO(SBO.OUT);

        // then
        Assertions.assertEquals(expectedStrike, strikeCount);
        Assertions.assertEquals(expectedBall, ballCount);
        Assertions.assertEquals(expectedOut, outCount);
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
