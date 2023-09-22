package main.utils;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class NumbersUtils {
    
    private NumbersUtils() {}

    public static List<Integer> getRandomizedNumbers(int length) {
        return Stream.generate(() -> new Random().nextInt(9) + 1)
                .distinct()
                .limit(length)
                .toList();
    }
}
