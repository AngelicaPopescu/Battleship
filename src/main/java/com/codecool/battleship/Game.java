package com.codecool.battleship;

import java.util.Arrays;

public class Game {
    //create player 1
    private BoardFactory boardPlayer1 = new BoardFactory();
    //    List<Ship> shipsPlayer1 = (List<Ship>) new Ship();
    private final Player player1 = new Player(Input.getPlayerName(), boardPlayer1);

    //create player 2
    private BoardFactory boardPlayer2 = new BoardFactory();
    //    List<Ship> shipsPlayer2 = (List<Ship>) new Ship();
    private final Player player2 = new Player(Input.getPlayerName(), boardPlayer2);
    private Display display = new Display();

    public void play() {
        Player player = player1;
        do {
            int boardSize = Input.askForBoardSize();
            boardPlayer1.setOcean(boardSize);
            boardPlayer2.setOcean(boardSize);
            display.displayBoard(boardSize, boardPlayer1);
            Display.displayPlayerTurn(player.getPlayerName());
            int[] coordinates = Input.getValidCoordinates(boardSize);
            player = (player == player1)? player2 :  player1;
        } while (!player.isAlive());
    }
}
