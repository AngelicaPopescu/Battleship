package com.codecool.battleship;

public class Square {

    //The Square class contains X and Y fields
    private int X;

    private int Y;

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    //The Square class has a SquareStatus field
    SquareStatus squareStatus;

    public SquareStatus getSquareStatus(){
        return squareStatus;
    }


    public Square(int x, int y, SquareStatus status){
        X = x;
        Y = y;
        squareStatus = status;
    }

    //The Square class has method that returns a graphical representation of SquareStatus
    public char graphicalSquareStatus() {
        return switch (this.squareStatus) {
            case EMPTY, HIT, SHIP, MISSED -> this.squareStatus.GetCharacter();
        };
    }

    //    public char graphicalSquareStatus() {
//        return switch (this.squareStatus) {
//            case EMPTY -> 'E';
//            case HIT -> 'H';
//            case SHIP -> 'S';
//            case MISSED -> 'M';
//        };
//    }

}
