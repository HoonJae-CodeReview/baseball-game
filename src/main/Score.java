package main;

import java.util.HashMap;
import java.util.Map;

public class Score {
    private Map<SBO, Integer> score = new HashMap<>();

    public void addSBO(SBO sbo) {
        score.put(sbo, getSBO(sbo) + 1);
    }

    public int getSBO(SBO sbo) {
        return score.getOrDefault(sbo, 0);
    }
}
