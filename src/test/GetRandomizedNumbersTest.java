package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static main.utils.NumbersUtils.getRandomizedNumbers;

public class GetRandomizedNumbersTest {

    @Test()
    @DisplayName("무작위 숫자 생성 시 중복된 숫자가 생기지 않는다.")
    void noDuplicatedNumbersTest() {
        final int repeatCount = 100000;
        for (int i=0; i<repeatCount; i++) {
            int length = 1 + (int) Math.round(Math.random() * 8);
            int[] randomizedNumbers = getRandomizedNumbers(length);
            int[] numbersCount = new int[10];
            for (int number : randomizedNumbers) {
                numbersCount[number]++;
                if (numbersCount[number] > 1) {
                    Assertions.fail();
                }
            }
        }
    }
}
