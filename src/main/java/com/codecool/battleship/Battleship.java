package com.codecool.battleship;

import java.util.Arrays;

public class Battleship {

    public static void main(String[] args){

        //testing
        int boardSize = 5;
        Board board = new Board();
        board.setOcean(boardSize);
        System.out.println("Ocean: "+ Arrays.deepToString(board.getOcean()));
        board.boardDisplay();





    }
}
