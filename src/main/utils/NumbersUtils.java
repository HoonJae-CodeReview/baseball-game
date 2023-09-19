package main.utils;

public class NumbersUtils {
    
    private NumbersUtils() {}

    public static int[] getRandomizedNumbers(int length) {
        int[] result = new int[length];
        
        for (int i=0; i<length; i++) {
            int randomNumber = (int) (Math.random() * 9) + 1;
            result[i] = randomNumber;
        }
        return result;
    }
    
}
