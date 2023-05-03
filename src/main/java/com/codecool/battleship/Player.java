package com.codecool.battleship;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    private final String playerName;
    private final Board playerBoard;

    private final List<Ship> shipList;

    private final Input input = new Input();
    Set<String> usedCoordinates;


    public List<Ship> getShipList() {
        return shipList;
    }

    public Player(String playerName, Board playerBoard) {
        this.playerName = playerName;
        this.playerBoard = playerBoard;
        this.shipList = new ArrayList<>();
        this.usedCoordinates = new HashSet<>();
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public boolean isAlive(List<Ship> shipList) {
        boolean result = false;
      for (Ship ship : shipList) {
          if(!ship.isSunk()){
              result = true;
          }
       }
      return result;
    }

}
