package com.codecool.battleship;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Input {

    public static int getGameMode() {
        int[] validAnswers = {1, 2, 3};
        int gameMode;
        while (true) {
            Scanner input = new Scanner(System.in);
            Display.askForInput();
            int userInput = input.nextInt();
            try {
                if (checkForValidAnswer(userInput, validAnswers)) {
                    gameMode = userInput;
                    break;
                } else {
                    Display.displayInvalidChoiceMessage();
                }
            } catch (InputMismatchException ignored) {
            }
        }
        return gameMode;
    }

    private static boolean checkForValidAnswer(int input, int [] validAnswers){
        for(int elem: validAnswers) {
           if (elem == input){
               return true;
           }
        }
        return false;
    }

    public static String getPlayerName() {
        String name;
        while(true) {
            Scanner input = new Scanner(System.in);
            Display.askForPlayerName();
            try {
                if (input.nextLine().matches("[a-zA-Z]+")) {
                    name = String.valueOf(input);
                    break;
                } else {
                    Display.displayIncorrectName();
                }
            } catch (InputMismatchException ignored) {
            }
        }
        return name;
    }

    public static int [] getValidCoordinates(int boardSize) {
        int [] coordinates = new int[2];
        int row;
        int col;
        while (true) {
            Scanner playerCoordinates = new Scanner(System.in);
            Display.askForShootCoordinates();
            String inputs = playerCoordinates.nextLine();
            if (Objects.equals(inputs, "quit")) {
                System.exit(0);
            }
            try {
                if (!Objects.equals(inputs, "")) {
                    col = inputs.substring(0, 1).toUpperCase().charAt(0) - 65;
                    row = Integer.parseInt(inputs.substring(1)) - 1;
                    if (row >= 0 && boardSize - 1 > row && col >= 0 && boardSize - 1 > col) {
                        coordinates[0] = col;
                        coordinates[1] = row;
                        break;
                    } else {
                        Display.displayInvalidChoiceMessage();
                    }
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                Display.displayInvalidChoiceMessage();
            }
        }
        return coordinates;
    }
}
