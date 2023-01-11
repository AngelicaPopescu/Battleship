package com.codecool.battleship;

import com.codecool.battleship.placement.ShipPlacement;

import java.util.Arrays;

public class Board {


    //The Board class has a Square[][] ocean field. This contains the squares that the board consists of.
    protected Square[][] ocean;

    int oceanSize;

    //    public void setOcean(Square[][] ocean) {
    public void setOcean(int oceanSize) {
        this.ocean = new Square[oceanSize][oceanSize];
        for (int row = 0; row < oceanSize; row++) {
            for (int col = 0; col < oceanSize; col++) {
                this.ocean[row][col] = new Square(row, col, SquareStatus.EMPTY);
            }
        }
        this.oceanSize = oceanSize;
    }

    public Square[][] getOcean() {
        return ocean;
    }


    //The Board class has an isPlacementOk() method that verifies if placement of ship is possible
    public boolean isPlacementOK(ShipType shipType, ShipPlacement shipPlacement) {
        boolean response = false;
        //check for margins of board
        if (shipPlacement.shipPosition.x >= 0 && shipPlacement.shipPosition.x <= oceanSize - 1) {
            if (shipPlacement.shipPosition.y >= 0 && shipPlacement.shipPosition.y <= oceanSize - 1) {
                response = true;
            }
        }
            //check for ship overlapping

        //        for () {
//
//        }


        return response;
    }

    public String boardToString(int boardSize){
        StringBuilder sb = new StringBuilder();
        sb.append("   ");
        for (int i = 0; i < boardSize; i++) {
            sb.append("  ").append((char) ('A' + i));
        }
        sb.append("\n");
        for (int y = 0; y < boardSize; y++) {
            sb.append(String.format("%3s", y + 1));;
            for (int x = 0; x < ocean[0].length; x++) {
                sb.append("  ").append(ocean[y][x].squareStatus.GetCharacter());
            }
            sb.append("\n");
        }
        return String.valueOf(sb);
    }


//    public void boardDisplay(){
//        String[][] toDisplay = new String[oceanSize][oceanSize];
//
//        for (int row = 0; row < oceanSize; row++) {
//            for (int col = 0; col < oceanSize; col++) {
//                toDisplay[row][col]=" "+ocean[row][col].squareStatus.GetCharacter();
////                toDisplay[row][col]=" "+ocean[row][col].graphicalSquareStatus()+" x: "
////                        +ocean[row][col].X+" y: "+ocean[row][col].Y;
//            }
//        }
//
//        System.out.println("toDisplay: "+Arrays.deepToString(toDisplay));
//        System.out.println();
//        System.out.println(
//                Arrays.deepToString(toDisplay)
//                        .replace("[[", "")
//                        .replace("], ", "\n")
//                        .replace(",","")
//                        .replace("[","")
//                        .replace("]]",""));
//        System.out.println();
//    }


}
