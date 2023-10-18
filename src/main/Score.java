package main;

import java.util.HashMap;
import java.util.Map;

public class Score {
    private Map<StrikeBallOut, Integer> score = new HashMap<>();

    public void addStrikeBallOut(StrikeBallOut strikeBallOut) {
        score.put(strikeBallOut, getStrikeBallOut(strikeBallOut) + 1);
    }

    public int getStrikeBallOut(StrikeBallOut strikeBallOut) {
        return score.getOrDefault(strikeBallOut, 0);
    }
}
