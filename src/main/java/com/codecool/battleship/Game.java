package com.codecool.battleship;

public class Game {
    Board boardPlayer1 = new Board();
    public Player player1 = new Player(Input.getPlayerName(), boardPlayer1);
    Board boardPlayer2 = new Board();
    public Player player2 = new Player(Input.getPlayerName(), boardPlayer2);

}
