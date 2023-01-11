package com.codecool.battleship;

import java.util.Arrays;

public class Game {
    public Display display = new Display();
    public Input input = new Input();


    public void play() {
        //    List<Ship> shipsPlayer1 = (List<Ship>) new Ship();
        BoardFactory boardPlayer1 = new BoardFactory();
        Player player1 = new Player(input.getPlayerName(), boardPlayer1);
        //    List<Ship> shipsPlayer2 = (List<Ship>) new Ship();
        BoardFactory boardPlayer2 = new BoardFactory();
        Player player2 = new Player(input.getPlayerName(), boardPlayer2);
        Player player = player1;
        do {
            int boardSize = input.askForBoardSize();
            boardPlayer1.setOcean(boardSize);
            boardPlayer2.setOcean(boardSize);
            display.displayPlayerTurn(player.getPlayerName());
            display.displayBoard(boardSize, (player == player1)?boardPlayer1:boardPlayer2); // switch board for player
            int[] coordinates = input.getValidCoordinates(boardSize);

            player = (player == player1)? player2 : player1; // switch player
        } while (!player.isAlive());
    }
}
