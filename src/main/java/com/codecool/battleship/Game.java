package com.codecool.battleship;

import java.util.Arrays;
import java.util.List;

public class Game {
    //create player 1
    private final Board boardPlayer1 = new Board();
    //    List<Ship> shipsPlayer1 = (List<Ship>) new Ship();
    private final Player player1 = new Player(Input.getPlayerName(), boardPlayer1);

    //create player 2
    private final Board boardPlayer2 = new Board();
    //    List<Ship> shipsPlayer2 = (List<Ship>) new Ship();
    private final Player player2 = new Player(Input.getPlayerName(), boardPlayer2);

    public void play() {
        Player player = player1;
        do {
            int boardSize = Input.askForBoardSize();
            boardPlayer1.setOcean(boardSize);
            boardPlayer2.setOcean(boardSize);
            boardPlayer1.boardDisplay();
            Display.displayPlayerTurn(player.getPlayerName());
            int[] coordinates = Input.getValidCoordinates(boardSize);
            System.out.println("Ocean: " + Arrays.deepToString(boardPlayer1.getOcean()));
            player = (player == player1)? player2 :  player1;
        } while (!player.isAlive());
    }
}
