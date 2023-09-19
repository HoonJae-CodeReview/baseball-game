package main.utils;

public final class StringUtils {

    private StringUtils() {}

    public static int[] parseToNumbers(String stringValue) {
        int length = stringValue.length();
        int[] numbers = new int[length];
        for (int i=0; i<length; i++) {
            int number = stringValue.charAt(i) - '0';
            numbers[i] = number;
        }
        return numbers;
    }

}
