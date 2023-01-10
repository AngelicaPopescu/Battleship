package com.codecool.battleship;

public class Board {


    //The Board class has a Square[][] ocean field. This contains the squares that the board consists of.
    private Square[][] ocean;

    public void setOcean(Square[][] ocean) {
        this.ocean = ocean;
    }

    public Square[][] getOcean() {
        return ocean;
    }


    //The Board class has an isPlacementOk() method that verifies if placement of ship is possible
    public boolean isPlacementOK(){
        return true;
    }
}
