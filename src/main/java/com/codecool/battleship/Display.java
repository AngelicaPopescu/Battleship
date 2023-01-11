package com.codecool.battleship;

import java.util.Arrays;

public class Display{
    public static void displayWelcomeMessage (){
        System.out.println("Battleship");
    }

    public static void displayGameModeOptions (){
        System.out.println("1. New game\n2. High scores\n3. Exit");
    }

    public static void displayInvalidChoiceMessage() {
        System.out.println("Invalid choice!\n" );
    }

    public static void askForInput() {
        System.out.println("Enter your choice: ");
    }

    public static void askForPlayerName() {
        System.out.println("Player name: ");
    }

    public static void askForShootCoordinates() {
        System.out.println("Shoot to: ");
    }

    public void displayPlayerTurn(String name) {
        System.out.println(name + "'s turn");
    }

    public static void displayIncorrectName() {
        System.out.println("Doesn't look like a name! Type your name here: ");
    }

    public static void askForBoardSize() {
        System.out.println("Choose the board size: ");
    }

    public void displayBoard(int boardSize, BoardFactory board) {
        System.out.println(board.boardToString(boardSize));
    }
}
