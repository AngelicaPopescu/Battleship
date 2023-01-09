package com.codecool.battleship;

public class Player {
    private String playerName;
    private Board playerBoard;

    public Player(String playerName, Board playerBoard) {
        this.playerName = playerName;
        this.playerBoard = playerBoard;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public Board getPlayerBoard() {
        return this.playerBoard;
    }

}
