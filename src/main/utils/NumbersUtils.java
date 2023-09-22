package main.utils;

import java.util.ArrayList;
import java.util.List;

public class NumbersUtils {
    
    private NumbersUtils() {}

    public static List<Integer> getRandomizedNumbers(int length) {
        List<Integer> result = new ArrayList<>();

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i=1; i<=9; i++) {
            numbers.add(i);
        }

        for (int i=0; i<length; i++) {
            int leftNumbersCount = numbers.size();
            int randomIndex = (int) Math.floor(Math.random() * leftNumbersCount);
            int randomNumber = numbers.get(randomIndex);
            numbers.remove(randomIndex);
            result.add(randomNumber);
        }
        return result;
    }


    
}
