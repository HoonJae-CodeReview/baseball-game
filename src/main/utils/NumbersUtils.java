package main.utils;

import main.Number_;
import main.Numbers;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public final class NumbersUtils {
    
    private NumbersUtils() {}

    public static Numbers getRandomizedNumbers(int numberLength) {
        List<Integer> randomizedIntegers = NumbersUtils.getRandomizedIntegerList(numberLength);
        List<Number_> randomizedNumbers = NumbersUtils.convertToNumberList(randomizedIntegers);
        return new Numbers(randomizedNumbers);
    }

    private static List<Integer> getRandomizedIntegerList(int length) {
        return Stream.generate(() -> new Random().nextInt(9) + 1)
                .distinct()
                .limit(length)
                .toList();
    }

    public static List<Number_> convertToNumberList(List<Integer> values) {
        AtomicInteger position = new AtomicInteger(1);
        return values.stream()
                .map(value -> new Number_(value, position.getAndIncrement()))
                .toList();
    }
}
