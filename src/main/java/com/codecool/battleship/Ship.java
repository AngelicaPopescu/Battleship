package com.codecool.battleship;

import java.util.ArrayList;
import java.util.List;

public class Ship {

    private final List<Square> squareList;
    private ShipType shipType;


    public Ship(List<Square> squareList) {
        this.squareList = squareList;
    }

    public Ship(ShipType shipType) {
        this.shipType = shipType;
        squareList = new ArrayList<>();
    }


    public List<Square> getSquareList() {
        return squareList;
    }


    public ShipType getShipType() {
        return shipType;
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }

//    public boolean isShipPosition(Square square){
//        if(squareList != null){
//            for (Square s: squareList){
//                if (s.getY() == square.getY() && s.getX() == square.getX()) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

        public boolean isSunk(){
        int count =0;
        for (Square s: squareList){
            if(s.getSquareStatus() == SquareStatus.SUNK){
                count++;
            }
        }
        return count == squareList.size();
    }

    public void setShot(Square square) {
        if (squareList != null) {
            for (Square s : squareList) {
                if (s.getY() == square.getY() && s.getX() == square.getX()) {
                    s.setSquareStatus(SquareStatus.HIT);
                }
            }
        }
    }

    public SquareStatus getShotStatus(Square square) {
        if (squareList != null) {
            for (Square s : squareList) {
                if (s.getY() == square.getY() && s.getX() == square.getX()) {
                    return s.getSquareStatus();
                }
            }
        }
        return SquareStatus.MISSED;
    }

    public void checkAndSetSunk(BoardFactory board) {
            int count = 0;
            for (Square s : squareList) {
                System.out.println("Square status: "+s.squareStatus);
                if (s.getSquareStatus() == SquareStatus.HIT) {
                    count ++;
                }
            }
            System.out.println("count: "+count);
            if (count == squareList.size()) {
                System.out.println("Ship sunk "+getShipType());
                for (Square s: squareList) {
                    s.setSquareStatus(SquareStatus.SUNK);
                    board.ocean[s.getY()][s.getX()].setSquareStatus(SquareStatus.SUNK);
                }
            }
    }

}
