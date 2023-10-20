package main.utils;

import java.util.ArrayList;
import java.util.List;

public final class StringUtils {

    private StringUtils() {}

    public static List<Integer> parseToIntegers(String stringValue) {
        int length = stringValue.length();
        List<Integer> numbers = new ArrayList<>();
        for (int i=0; i<length; i++) {
            int number = stringValue.charAt(i) - '0';
            numbers.add(number);
        }
        return numbers;
    }

}
