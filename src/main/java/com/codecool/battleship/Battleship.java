package com.codecool.battleship;

public class Battleship {
    public static void main(String[] args) {
        while (true) {
            Display.displayWelcomeMessage();
            Display.displayGameModeOptions();
            int gameMode = Input.getGameMode();
            if (gameMode == 3) {
                System.exit(0);
            } else if (gameMode == 1) {
                Game game = new Game();
                game.play();
            }
        }
    }
}
