package com.codecool.battleship;

import java.util.List;

public class Player {
    private String playerName;
    private Board playerBoard;
    private List<Ship> shipList;
    private Input input = new Input();

    public Player(String playerName, Board playerBoard) {
        this.playerName = playerName;
        this.playerBoard = playerBoard;
//        this.playerShips = playerShips;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public Board getPlayerBoard() {
        return this.playerBoard;
    }



    public boolean isAlive() {
//        if (playerShips != null) {
////            for (Ship ship : playerShips) {
//////                if (!Ship.isSunk()) return true;
////            }
//        }
        return false;
    }
}
