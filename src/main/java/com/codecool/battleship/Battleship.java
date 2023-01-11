package com.codecool.battleship;

import java.util.Arrays;

public class Battleship {
    public static void main(String[] args) {
        while (true) {
            Game game = new Game();
            game.display.displayWelcomeMessage();
            game.display.displayGameModeOptions();
            int gameMode = game.input.getGameMode();
            if (gameMode == 3) {
                System.exit(0);
            } else if (gameMode == 1) {
                game.play();
            }
        }
    }
}
