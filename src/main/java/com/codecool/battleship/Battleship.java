package com.codecool.battleship;

public class Battleship {
    public static void main(String[] args) {
        while (true) {
            Display.displayWelcomeMessage();
            Display.displayGameModeOptions();
            int gameMode = Input.getGameMode();
            System.out.println(gameMode);
            if (gameMode == 3) {
                System.exit(0);
            } else if (gameMode == 1) {
                Game game = new Game();
                System.out.println(game.player1.getPlayerName());
                System.out.println(game.player2.getPlayerName());
            }
        }
    }
}
