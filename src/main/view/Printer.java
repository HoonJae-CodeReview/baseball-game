package main.view;

import main.Score;

import java.util.StringTokenizer;

public interface Printer {
    void print(String string);
    void print(StringTokenizer stringTokenizer);
    void print(Exception e);
    void print(Score score);
}
