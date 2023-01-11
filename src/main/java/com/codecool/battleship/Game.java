package com.codecool.battleship;

import com.codecool.battleship.placement.Direction;

import java.util.Arrays;
import java.util.List;

public class Game {
    public Display display = new Display();
    public Input input = new Input();


    public void play() {
        BoardFactory boardPlayer1 = new BoardFactory();
        String namePlayer1 = input.getNameForPlayer();
        Player player1 = new Player(namePlayer1, boardPlayer1);
        List<Ship> shipsPlayer1;
        //    List<Ship> shipsPlayer2 = (List<Ship>) new Ship();
        BoardFactory boardPlayer2 = new BoardFactory();
        Player player2 = new Player(input.getNameForPlayer(), boardPlayer2);
        Player player = player1;
        BoardFactory board = boardPlayer1;
        do {
            int boardSize = input.askForBoardSize();
            boardPlayer1.setOcean(boardSize);
            boardPlayer2.setOcean(boardSize);
            display.displayPlayerTurn(player.getPlayerName());
            display.displayBoard(boardSize, board); // switch board for player
            int placementMethod = input.askForPlacementMethod();
            if (placementMethod == 1) {
                int[] coordinates = input.getValidCoordinates(boardSize, "place");
                Direction direction1 = input.getDirection();
                System.out.println(direction1);
                board.manualPlacement(coordinates[0], coordinates[1], direction1);
                display.displayBoard(boardSize, board);


            }


            player = (player == player1)? player2 : player1; // switch player
            board = (player == player1)? boardPlayer2 : boardPlayer1; // switch player
        } while (!player.isAlive());
    }
}
