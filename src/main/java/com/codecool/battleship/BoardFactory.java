package com.codecool.battleship;


import com.codecool.battleship.placement.Direction;
import com.codecool.battleship.placement.ShipPlacement;

public class BoardFactory extends Board {

    //The BoardFactory class has a @randomPlacement() method that handles random ship placement on board
    public void randomPlacement(ShipType shipType, int oceanSize) {

        ShipPlacement shipPlacement;
//        int count=0;

        do {
            shipPlacement = new ShipPlacement(oceanSize);
//            System.out.println("Ship direction: " + shipPlacement.shipDirection);
//            System.out.println("Ship type: " + shipType.getLength());
//            System.out.println("Ship position y: " + shipPlacement.shipPosition.y);
//            System.out.println("Ship position x: " + shipPlacement.shipPosition.x);
//            System.out.println("is plcement ok?: "+isPlacementOK(shipType, shipPlacement));
//            count++;
//            System.out.println("ship random placement: "+count);
        } while (!isPlacementOK(shipType, shipPlacement));

        if (isPlacementOK(shipType, shipPlacement)) {
            switch (shipPlacement.shipDirection) {
                case EAST -> {
                    for (int i = 0; i < shipType.getLength(); i++) {
                        this.ocean[shipPlacement.shipPosition.y][shipPlacement.shipPosition.x + i].squareStatus =
                                SquareStatus.SHIP;
                        //N on top
                        if (shipPlacement.shipPosition.y>0) {
                            this.ocean[shipPlacement.shipPosition.y-1][shipPlacement.shipPosition.x+i].squareStatus =
                                    SquareStatus.NEARBY;
                        }
                        //N under
                        if (shipPlacement.shipPosition.y<(oceanSize-1)) {
                            this.ocean[shipPlacement.shipPosition.y+1][shipPlacement.shipPosition.x+i].squareStatus =
                                    SquareStatus.NEARBY;
                        }
                    }
                    //N at left
                    if (shipPlacement.shipPosition.x>0) {
                        this.ocean[shipPlacement.shipPosition.y][shipPlacement.shipPosition.x-1].squareStatus =
                                SquareStatus.NEARBY;
                    }
                    //N at right
                    if ((shipPlacement.shipPosition.x+shipType.getLength())<=(oceanSize-1)) {
                        this.ocean[shipPlacement.shipPosition.y][shipPlacement.shipPosition.x+shipType.getLength()].squareStatus =
                                SquareStatus.NEARBY;
                    }
                }
                case WEST -> {
                    for (int i = 0; i < shipType.getLength(); i++) {
                        this.ocean[shipPlacement.shipPosition.y][shipPlacement.shipPosition.x - i].squareStatus =
                                SquareStatus.SHIP;
                        //N on top
                        if (shipPlacement.shipPosition.y>0) {
                            this.ocean[shipPlacement.shipPosition.y-1][shipPlacement.shipPosition.x-i].squareStatus =
                                    SquareStatus.NEARBY;
                        }
                        //N under
                        if (shipPlacement.shipPosition.y<(oceanSize-1)) {
                            this.ocean[shipPlacement.shipPosition.y+1][shipPlacement.shipPosition.x-i].squareStatus =
                                    SquareStatus.NEARBY;
                        }
                    }
                    //N at left
                    if ((shipPlacement.shipPosition.x-shipType.getLength())>=0) {
                        this.ocean[shipPlacement.shipPosition.y][shipPlacement.shipPosition.x-shipType.getLength()].squareStatus =
                                SquareStatus.NEARBY;
                    }
                    //N at right
                    if (shipPlacement.shipPosition.x<(oceanSize-1)) {
                        this.ocean[shipPlacement.shipPosition.y][shipPlacement.shipPosition.x+1].squareStatus =
                                SquareStatus.NEARBY;
                    }
                }
                case NORTH -> {
                    for (int i = 0; i < shipType.getLength(); i++) {
                        this.ocean[shipPlacement.shipPosition.y - i][shipPlacement.shipPosition.x].squareStatus =
                                SquareStatus.SHIP;
                        //N at left
                        if (shipPlacement.shipPosition.x>0) {
                            this.ocean[shipPlacement.shipPosition.y-i][shipPlacement.shipPosition.x-1].squareStatus =
                                    SquareStatus.NEARBY;
                        }
                        //N at right
                        if (shipPlacement.shipPosition.x<(oceanSize-1)) {
                            this.ocean[shipPlacement.shipPosition.y-i][shipPlacement.shipPosition.x+1].squareStatus =
                                    SquareStatus.NEARBY;
                        }
                    }
                    //N on top
                    if (shipPlacement.shipPosition.y-shipType.getLength()>=0) {
                        this.ocean[shipPlacement.shipPosition.y-shipType.getLength()][shipPlacement.shipPosition.x].squareStatus =
                                SquareStatus.NEARBY;
                    }
                    //N under
                    if (shipPlacement.shipPosition.y<(oceanSize-1)) {
                        this.ocean[shipPlacement.shipPosition.y+1][shipPlacement.shipPosition.x].squareStatus =
                                SquareStatus.NEARBY;
                    }
                }
                case SOUTH -> {
                    for (int i = 0; i < shipType.getLength(); i++) {
                        this.ocean[shipPlacement.shipPosition.y + i][shipPlacement.shipPosition.x].squareStatus =
                                SquareStatus.SHIP;
                        //N at left
                        if (shipPlacement.shipPosition.x>0) {
                            this.ocean[shipPlacement.shipPosition.y+i][shipPlacement.shipPosition.x-1].squareStatus =
                                    SquareStatus.NEARBY;
                        }
                        //N at right
                        if (shipPlacement.shipPosition.x<(oceanSize-1)) {
                            this.ocean[shipPlacement.shipPosition.y+i][shipPlacement.shipPosition.x+1].squareStatus =
                                    SquareStatus.NEARBY;
                        }
                    }
                    //N on top
                    if (shipPlacement.shipPosition.y>0) {
                        this.ocean[shipPlacement.shipPosition.y-1][shipPlacement.shipPosition.x].squareStatus =
                                SquareStatus.NEARBY;
                    }
                    //N under
                    if ((shipPlacement.shipPosition.y+shipType.getLength())<=(oceanSize-1)) {
                        this.ocean[shipPlacement.shipPosition.y+shipType.getLength()][shipPlacement.shipPosition.x].squareStatus =
                                SquareStatus.NEARBY;
                    }
                }
            }
        }
    }


    //The BoardFactory class has a @manualPlacement() method that handles manual ship placement on board
    public ShipPlacement manualPlacement(ShipType ship, int x, int y, Direction direction) {
        ShipPlacement shipPlacement = new ShipPlacement(x, y, direction);
        return shipPlacement;
    }

}
