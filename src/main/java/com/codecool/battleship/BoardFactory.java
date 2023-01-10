package com.codecool.battleship;


import com.codecool.battleship.placement.ShipPlacement;

public class BoardFactory {

    //The BoardFactory class has a @randomPlacement() method that handles random ship placement on board
    public ShipPlacement randomPlacement(ShipType ship){
        ShipPlacement shipPlacement = null;
        return shipPlacement;
    }


    //The BoardFactory class has a @manualPlacement() method that handles manual ship placement on board
    public ShipPlacement manualPlacement(ShipPlacement ship){
        return null;
    }

}
