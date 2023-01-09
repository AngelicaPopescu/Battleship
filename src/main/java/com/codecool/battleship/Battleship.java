package com.codecool.battleship;

public class Battleship {
    public static void main(String[] args) {
        Display.displayWelcomeMessage();
        Display.displayGameModeOptions();
        Game game = new Game();
        System.out.println(game.player1.getPlayerName());
        System.out.println(game.player2.getPlayerName());
    }
}
