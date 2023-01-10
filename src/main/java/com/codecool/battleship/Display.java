package com.codecool.battleship;

public class Display {
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

    public static void displayPlayerTurn(String name) {
        System.out.println(name + "'s turn");
    }
}
