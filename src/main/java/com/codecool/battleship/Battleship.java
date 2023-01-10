package com.codecool.battleship;

import java.util.Arrays;

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
        int boardSize = 5;
        Board board = new Board();
        board.setOcean(boardSize);
        System.out.println("Ocean: " + Arrays.deepToString(board.getOcean()));
        board.boardDisplay();
    }
}
