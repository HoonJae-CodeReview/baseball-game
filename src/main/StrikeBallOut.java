package main;

public enum StrikeBallOut {
    STRIKE("스트라이크"),
    BALL("볼"),
    OUT("아웃");

    private final String description;

    StrikeBallOut(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
