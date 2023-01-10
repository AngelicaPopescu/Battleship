package com.codecool.battleship;

import java.util.List;

public class Game {

    //create player 1
    Board boardPlayer1 = new Board();
//    List<Ship> shipsPlayer1 = (List<Ship>) new Ship();
    public Player player1 = new Player(Input.getPlayerName(), boardPlayer1);

    //create player 2
    Board boardPlayer2 = new Board();
//    List<Ship> shipsPlayer2 = (List<Ship>) new Ship();
    public Player player2 = new Player(Input.getPlayerName(), boardPlayer2);
}
