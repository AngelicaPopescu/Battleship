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
    private final Display display = new Display();

    public void play() {
        Player player = player1;
        do {
            int boardSize = Input.askForBoardSize();
            boardPlayer1.setOcean(boardSize);
            boardPlayer2.setOcean(boardSize);
            display.displayPlayerTurn(player.getPlayerName());
            display.displayBoard(boardSize, (player == player1)?boardPlayer1:boardPlayer2); // switch board for player
            int[] coordinates = Input.getValidCoordinates(boardSize);

            player = (player == player1)? player2 :  player1; // switch player
        } while (!player.isAlive());
    }
}
