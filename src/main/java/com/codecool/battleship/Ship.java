package com.codecool.battleship;

import java.util.List;

public class Ship {

    private List<Square> squareList;
    private Ship shipType;


    public Ship (List<Square> squareList ){
        this.squareList = squareList;
    }


    public List<Square> getSquareList() {
        return squareList;
    }


    public Ship getShipType() {
        return shipType;
    }

    public void setShipType(Ship shipType) {
        this.shipType = shipType;
    }

    public boolean isShipPosition(Square square){
        if(squareList != null){
            for (Square s: squareList){
                if (s.getY() == square.getY() && s.getX() == square.getX()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSunk(){

        if(squareList != null){
            for (Square s: squareList){
                if(s.getSquareStatus() == SquareStatus.SHIP){
                    return false;
                }
            }
        }
        return true;
    }


}
