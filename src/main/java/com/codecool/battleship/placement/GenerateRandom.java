package com.codecool.battleship.placement;

import java.util.Random;

public class GenerateRandom {
    public static int randomCoordinates(){
        return (int) Math.floor(Math.random()*();
    }

    private static final Random PRNG = new Random();

    public static Direction randomDirection(){
        Direction[] directions = Direction.values();
        return directions[PRNG.nextInt(directions.length)];
    }

}

