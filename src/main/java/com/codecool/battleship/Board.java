package com.codecool.battleship;

import java.util.Arrays;

public class Board {


    //The Board class has a Square[][] ocean field. This contains the squares that the board consists of.
    private Square[][] ocean;

    int oceanSize;

//    public void setOcean(Square[][] ocean) {
    public void setOcean(int oceanSize) {
        this.ocean = new Square[oceanSize][oceanSize];
        for(int x=0; x<oceanSize; x++){
            for (int y=0; y<oceanSize; y++) {
                this.ocean[x][y]= new Square(x,y,SquareStatus.EMPTY);
            }
        }
        this.oceanSize = oceanSize;
    }

    public Square[][] getOcean() {
        return ocean;
    }


    //The Board class has an isPlacementOk() method that verifies if placement of ship is possible
    public boolean isPlacementOK(){
        return true;
    }

    public void boardDisplay(){
        String[][] toDisplay = new String[oceanSize][oceanSize];

        for (int row = 0; row < oceanSize; row++) {
            for (int col = 0; col < oceanSize; col++) {
                toDisplay[row][col]=" "+ocean[row][col].squareStatus.GetCharacter();
//                toDisplay[row][col]=" "+ocean[row][col].graphicalSquareStatus()+" x: "
//                        +ocean[row][col].X+" y: "+ocean[row][col].Y;
            }
        }

        System.out.println("toDisplay: "+Arrays.deepToString(toDisplay));
        System.out.println();
        System.out.println(
                Arrays.deepToString(toDisplay)
                        .replace("[[", "")
                        .replace("], ", "\n")
                        .replace(",","")
                        .replace("[","")
                        .replace("]]",""));
        System.out.println();
    }



}
