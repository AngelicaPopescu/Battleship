package com.codecool.battleship;

import com.codecool.battleship.placement.Direction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    public Display display = new Display();
    public Input input = new Input();
    public Square square;
    public Ship ship;


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
        List<Ship> shipsListPlayer1 = new ArrayList<>();
        List<Ship> shipsListPlayer2 = new ArrayList<>();
        ShipType[] shipTypes = ShipType.values();

        for (ShipType shipType: shipTypes) {
            Ship ship = new Ship(shipType);
            shipsListPlayer1.add(ship);
            shipsListPlayer2.add(ship);
        }
        int repeat = 0;
        do {
            repeat += 1;
            display.displayPlayerTurn(player.getPlayerName());
            display.displayBoard(boardSize, board, "place");
            int placementMethod = input.askForPlacementMethod();
            if (placementMethod == 1) {
                for (ShipType shipType: shipTypes) {
                    int[] coordinates;
                    int x;
                    int y;
                    boolean placement;
                    do {
                        coordinates = input.getValidCoordinates(boardSize, "place", shipType);
                        x = coordinates[0];
                        y = coordinates[1];
                        placement = board.manualPlacement(shipType,x, y, input.getDirection());
                        display.displayBoard(boardSize, board, "place");
                    } while (!placement);

                }
            } else if (placementMethod == 2) {
                for (ShipType shipType: shipTypes) {
                    board.randomPlacement(shipType, boardSize);
                }
                display.displayBoard(boardSize, board, "place");
            }
            player = (player == player1)? player2 : player1; // switch player
            board = (player == player2)? boardPlayer2 : boardPlayer1; // switch player
        } while (!(repeat == 2));


        do {
            display.displayPlayerTurn(player.getPlayerName());
            display.displayBoard(boardSize, board, "shoot");
            int [] coordinates = input.getValidCoordinates(boardSize, "shoot", ShipType.CARRIER);
            int x = coordinates[0];
            int y = coordinates[1];
            if (board.ocean[y][x].squareStatus.GetCharacter() == 'S'){
                square = new Square(x, y , board.ocean[y][x].squareStatus);
                board.ocean[y][x].squareStatus = SquareStatus.HIT;


            }


            player = (player == player1)? player2 : player1; // switch player
            board = (player == player1)? boardPlayer2 : boardPlayer1; // switch player
        } while (player.isAlive());

    }
}
