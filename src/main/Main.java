package main;

import main.view.ConsoleView;
import main.view.View;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleView();
        Game game = new Game(view);
        game.run();
    }
}