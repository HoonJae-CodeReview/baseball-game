package main;

public class Score {
    private final int strikeCount, ballCount, outCount;

    public Score(int strikeCount, int ballCount, int outCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
        this.outCount = outCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getOutCount() {
        return outCount;
    }
}
