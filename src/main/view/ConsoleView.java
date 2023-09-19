package main.view;

import main.Numbers;
import main.Score;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ConsoleView implements View {

    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String input() {
        try {
            return bufferedReader.readLine();
        }
        catch (Exception e) {
            return null;
        }
    }

    @Override
    public void print(String string) {
        System.out.println(string);
    }

    @Override
    public void print(StringTokenizer stringTokenizer) {
        System.out.print(stringTokenizer);
    }

    @Override
    public void print(Exception e) {
        System.out.println("[!] " + e.getMessage());
    }

    @Override
    public void print(Score score) {
        StringBuilder stringBuilder = new StringBuilder();
        int strikeCount = score.getStrikeCount();
        int ballCount = score.getBallCount();
        int outCount = score.getOutCount();
        if (strikeCount > 0) {
            stringBuilder.append(strikeCount);
            stringBuilder.append("스트라이크 ");
        }
        if (ballCount > 0) {
            stringBuilder.append(ballCount);
            stringBuilder.append("볼 ");
        }
        if (outCount == Numbers.LENGTH) {
            stringBuilder.append("낫싱 ");
        }
        System.out.println(stringBuilder);
    }

    @Override
    public void requestNumber() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    @Override
    public void congratulate() {
        System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", Numbers.LENGTH);
    }

    @Override
    public void requestExit() {
        print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
    }
}
