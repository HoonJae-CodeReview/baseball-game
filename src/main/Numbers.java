package main;

import java.util.HashMap;
import java.util.Map;

public class Numbers {

    public static final int LENGTH = 3;

    private final int[] numbers;
    private final Map<Integer, Integer> numberCounts;

    public Numbers(int[] values) {
        numbers = values;
        numberCounts = getNumberCountsFromArray(values);
    }

    private HashMap<Integer, Integer> getNumberCountsFromArray(int[] values) {
        HashMap<Integer, Integer> balls = new HashMap<>();
        for (int value : values){
            int numberCountOfCurrentValue = balls.getOrDefault(value, 0);
            balls.put(value, numberCountOfCurrentValue + 1);
        }
        return balls;
    }

    // Strike
    public int getCountOfSameNumberAtSameIndex(Numbers anotherNumbers) {
        int result = 0;
        for (int i=0; i<LENGTH; i++) {
            System.out.println(numbers[i]+","+anotherNumbers.numbers[i]);
            if (numbers[i] == anotherNumbers.numbers[i]) {
                result++;
            }
        }
        return result;
    }
}
