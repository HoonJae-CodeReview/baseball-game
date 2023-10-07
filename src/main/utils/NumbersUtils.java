package main.utils;

import main.Number_;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class NumbersUtils {
    
    private NumbersUtils() {}

    public static List<Number_> convertToNumberList(List<Integer> values) {
        AtomicInteger position = new AtomicInteger(1);
        return values.stream()
                .map(value -> new Number_(value, position.getAndIncrement()))
                .toList();
    }

    public static List<Integer> getRandomizedIntegerList(int length) {
        return Stream.generate(() -> new Random().nextInt(9) + 1)
                .distinct()
                .limit(length)
                .toList();
    }
}
