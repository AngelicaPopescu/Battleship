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
        //    List<Ship> shipsPlayer2 = (List<Ship>) new Ship();
        BoardFactory boardPlayer2 = new BoardFactory();
        Player player2 = new Player(input.getNameForPlayer(), boardPlayer2);
        Player player = player1;
        BoardFactory board = boardPlayer1;
        int boardSize = input.askForBoardSize();
        boardPlayer1.setOcean(boardSize);
        boardPlayer2.setOcean(boardSize);
//        List<Ship> shipsListPlayer1 = new ArrayList<>();
//        List<Ship> shipsListPlayer2 = new ArrayList<>();
        ShipType[] shipTypes = ShipType.values();

        for (ShipType shipType: shipTypes) {
            Ship shipPlayer1 = new Ship(shipType);
            Ship shipPlayer2 = new Ship(shipType);
            player1.getShipList().add(shipPlayer1);
            player2.getShipList().add(shipPlayer2);
        }
        int repeat = 0;
        do {
            repeat += 1;
            display.displayPlayerTurn(player.getPlayerName());
            display.displayBoard(boardSize, board, "place", player);
            int placementMethod = input.askForPlacementMethod();
            if (placementMethod == 1) {
                for (Ship ship : ((player == player1)? player1.getShipList() : player2.getShipList())) {
                    int[] coordinates;
                    int x;
                    int y;
                    boolean placement;
                    do {
                        coordinates = input.getValidCoordinates(boardSize, "place", ship.getShipType());
                        x = coordinates[0];
                        y = coordinates[1];
                        placement = board.manualPlacement(ship,x, y, input.getDirection());
                        display.displayBoard(boardSize, board, "place", player);
                    } while (!placement);

                }
            } else if (placementMethod == 2) {
                for (Ship ship : ((player == player1)? player1.getShipList() : player2.getShipList())) {
                    board.randomPlacement(ship, boardSize);
                }
                display.displayBoard(boardSize, board, "place", player);
            }
            player = (player == player1)? player2 : player1; // switch player
            board = (player == player2)? boardPlayer2 : boardPlayer1; // switch player
        } while (!(repeat == 2));


        do {
            board = (player == player1)? boardPlayer2 : boardPlayer1; // switch player
            display.displayPlayerTurn(player.getPlayerName());
            display.displayBoard(boardSize, board, "shoot", player);
            int [] coordinates = input.getValidCoordinates(boardSize, "shoot", ShipType.CARRIER);
            int x = coordinates[0];
            int y = coordinates[1];
            if (board.ocean[y][x].squareStatus.GetCharacter() == 'S'){
              square = board.ocean[y][x];
                board.ocean[y][x].squareStatus = SquareStatus.HIT;
                for (Ship ship: (player == player1)? player1.getShipList() : player2.getShipList()) {
//                for (Ship ship: player.getShipList()) {
//                    System.out.println("For loop started line 84 Game");
                    for (int i=0; i<ship.getSquareList().size(); i++) {
//                        System.out.println("For loop started line 86 Game");
                        System.out.println("ship: "+ship.getShipType()+" x: "+ ship.getSquareList().get(i).getX()+"  y: "+
                                ship.getSquareList().get(i).getY());
                        System.out.println("X: "+x+"  Y: "+y);
                        if (ship.getSquareList().get(i).getX()==x && ship.getSquareList().get(i).getY()==y) {
                            System.out.println("ship list contains square! :)");
                            ship.getSquareList().get(i).squareStatus = SquareStatus.HIT;
                            ship.checkAndSetSunk(board);
                        }
                    }
                }
            } else {
                board.ocean[y][x].squareStatus = SquareStatus.MISSED;
            }
            display.displayBoard(boardSize, board, "shoot", player);
            player = (player == player1)? player2 : player1; // switch player
        } while (player.isAlive((player == player1)? player1.getShipList() : player2.getShipList()));


    }
}
