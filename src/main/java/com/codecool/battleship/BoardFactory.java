package com.codecool.battleship;


import com.codecool.battleship.placement.Direction;
import com.codecool.battleship.placement.ShipPlacement;

public class BoardFactory extends Board {

    //The BoardFactory class has a @randomPlacement() method that handles random ship placement on board
    public void randomPlacement(ShipType shipType, int oceanSize){
        ShipPlacement shipPlacement = new ShipPlacement(oceanSize);
        if (isPlacementOK(shipType, shipPlacement)) {
            System.out.println("Ship direction: "+shipPlacement.shipDirection);
            System.out.println("Ship type: "+shipType.getLength());
            System.out.println("Ship position y: "+shipPlacement.shipPosition.y);
            System.out.println("Ship position x: "+shipPlacement.shipPosition.x);
            switch (shipPlacement.shipDirection) {
                case EAST -> {
                    for (int i=0; i< shipType.getLength();i++){
                        this.ocean[shipPlacement.shipPosition.y][shipPlacement.shipPosition.x+i].squareStatus =
                                SquareStatus.SHIP;}
                }
                case WEST -> {
                    for (int i=0; i< shipType.getLength();i++){
                        this.ocean[shipPlacement.shipPosition.y][shipPlacement.shipPosition.x-i].squareStatus =
                                SquareStatus.SHIP;}
                }
                case NORTH -> {
                    for (int i=0; i< shipType.getLength();i++){
                        this.ocean[shipPlacement.shipPosition.y-i][shipPlacement.shipPosition.x].squareStatus =
                                SquareStatus.SHIP;}
                }
                case SOUTH -> {
                    for (int i=0; i< shipType.getLength();i++){
                        this.ocean[shipPlacement.shipPosition.y+i][shipPlacement.shipPosition.x].squareStatus =
                                SquareStatus.SHIP;}
                }

            }

        }
    }


    //The BoardFactory class has a @manualPlacement() method that handles manual ship placement on board
    public ShipPlacement manualPlacement(ShipType ship, int x, int y, Direction direction){
        ShipPlacement shipPlacement = new ShipPlacement(x, y, direction);
        return shipPlacement;
    }

}
