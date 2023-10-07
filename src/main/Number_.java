package main;


public class Number_ {

    public static int MIN_VALUE = 1;
    public static int MAX_VALUE = 9;

    private final int value;
    private final int position;

    public Number_(int value, int position) throws IllegalArgumentException {
        validateValueRange(value);
        this.value = value;
        this.position = position;
    }

    private void validateValueRange(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException("올바른 숫자 값의 범위는 " + MIN_VALUE +"~" + MAX_VALUE + "입니다.");
        }
    }
}
