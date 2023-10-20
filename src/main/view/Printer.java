package main.view;

import main.Score;

import java.util.StringTokenizer;

public interface Printer {
    void print(String string);
    void print(StringTokenizer stringTokenizer);
    void printError(Exception e);
    void printScore(Score score);
    void requestNumber();
    void congratulate();
    void requestExit();
}
