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
//            List<Ship> shipsPlayer2 = (List<Ship>) new Ship();
        BoardFactory boardPlayer2 = new BoardFactory();
        Player player2 = new Player(input.getNameForPlayer(), boardPlayer2);
        Player player = player1;
        BoardFactory board = boardPlayer1;
        int boardSize = input.askForBoardSize();
        boardPlayer1.setOcean(boardSize);
        boardPlayer2.setOcean(boardSize);
        do {
            display.displayPlayerTurn(player.getPlayerName());
            display.displayBoard(boardSize, board); // switch board for player
            int placementMethod = input.askForPlacementMethod();
            if (placementMethod == 1) {
                int[] coordinates = input.getValidCoordinates(boardSize, "place", ShipType.CARRIER);
                int x = coordinates[0];
                int y = coordinates[1];
                board.manualPlacement(ShipType.CARRIER,x, y, input.getDirection());
                display.displayBoard(boardSize, board);
//                coordinates = input.getValidCoordinates(boardSize, "place");
//                x = coordinates[0];
//                y = coordinates[1];
//                board.manualPlacement(ShipType.DESTROYER,x, y, input.getDirection());
//                display.displayBoard(boardSize, board);
//                coordinates = input.getValidCoordinates(boardSize, "place");
//                x = coordinates[0];
//                y = coordinates[1];
//                board.manualPlacement(ShipType.SUBMARINE,x, y, input.getDirection());
//                display.displayBoard(boardSize, board);
//                coordinates = input.getValidCoordinates(boardSize, "place");
//                x = coordinates[0];
//                y = coordinates[1];
//                board.manualPlacement(ShipType.BATTLESHIP,x, y, input.getDirection());
//                display.displayBoard(boardSize, board);
//                coordinates = input.getValidCoordinates(boardSize, "place");
//                x = coordinates[0];
//                y = coordinates[1];
//                board.manualPlacement(ShipType.CRUISER,x, y,  input.getDirection());
//                display.displayBoard(boardSize, board);

            } else if (placementMethod == 2) {
                board.randomPlacement(ShipType.CARRIER, boardSize);
                board.randomPlacement(ShipType.DESTROYER, boardSize);
                board.randomPlacement(ShipType.SUBMARINE, boardSize);
                board.randomPlacement(ShipType.BATTLESHIP, boardSize);
                board.randomPlacement(ShipType.CRUISER, boardSize);
                display.displayBoard(boardSize, board);

            }


            player = (player == player1)? player2 : player1; // switch player
            board = (player == player2)? boardPlayer2 : boardPlayer1; // switch player
        } while (!player.isAlive());
    }
}
