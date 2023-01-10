package com.codecool.battleship;

public class Board {

    private Square[][] ocean;

    public void setOcean(Square[][] ocean) {
        this.ocean = ocean;
    }

    public Square[][] getOcean() {
        return ocean;
    }

    public boolean isPlacementOK(){
        return true;
    }
}
