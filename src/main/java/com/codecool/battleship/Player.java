package com.codecool.battleship;

import java.util.List;

public class Player {
    private String playerName;
    private Board playerBoard;
//    private List<Ship> playerShips;

    public Player(String playerName, Board playerBoard) {
        this.playerName = playerName;
        this.playerBoard = playerBoard;
//        this.playerShips = playerShips;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Board getPlayerBoard() {
        return this.playerBoard;
    }

    public boolean isAlive() {
        return false;
    }
}
