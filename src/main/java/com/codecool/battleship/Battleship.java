package com.codecool.battleship;

import java.util.Arrays;

public class Battleship {

    public static void main(String[] args){

        //testing
        int boardSize = 5;
        Board board = new Board();
        board.setOcean(boardSize);
        System.out.println("Ocean: "+ Arrays.deepToString(board.getOcean()));
        board.boardDisplay();

        while (true) {
            Display.displayWelcomeMessage();
            Display.displayGameModeOptions();
            int gameMode = Input.getGameMode();
            System.out.println(gameMode);
            if (gameMode == 3) {
                System.exit(0);
            } else if (gameMode == 1) {
                Game game = new Game();
                game.play();
            }
        }
    }
}
