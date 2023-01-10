package com.codecool.battleship;

import java.util.Arrays;
import java.util.List;

public class Game {

    public void play() {
        //create player 1
        Board boardPlayer1 = new Board();
//    List<Ship> shipsPlayer1 = (List<Ship>) new Ship();
        Player player1 = new Player(Input.getPlayerName(), boardPlayer1);
        System.out.println(player1.getPlayerName());
        //create player 2
        Board boardPlayer2 = new Board();
//    List<Ship> shipsPlayer2 = (List<Ship>) new Ship();
        Player player2 = new Player(Input.getPlayerName(), boardPlayer2);
        System.out.println(player2.getPlayerName());
        int[] coordinates = Input.getValidCoordinates(10);
        System.out.println(Arrays.toString(coordinates));
    }
}
