package com.codecool.battleship;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Input {

    private Scanner scanner;

    public int getGameMode() {
        int[] validAnswers = {1, 2, 3};
        int gameMode;
        while (true) {
            scanner = new Scanner(System.in);
            Display.askForInput();
            int userInput = scanner.nextInt();
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

    private boolean checkForValidAnswer(int input, int [] validAnswers){
        for(int elem: validAnswers) {
           if (elem == input){
               return true;
           }
        }
        return false;
    }

    public String getNameForPlayer() {
        String name;
        while(true) {
            scanner = new Scanner(System.in);
            Display.askForPlayerName();
            String userChoice = scanner.nextLine();
            try {
                if (userChoice.matches("[a-zA-Z]+")) {
                    name = userChoice;
                    break;
                } else {
                    Display.displayIncorrectName();
                }
            } catch (InputMismatchException ignored) {
            }
        }
        return name;
    }

    public int [] getValidCoordinates(int boardSize) {
        int [] coordinates = new int[2];
        int row;
        int col;
        while (true) {
            scanner = new Scanner(System.in);
            Display.askForShootCoordinates();
            String inputs = scanner.nextLine();
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

    public int askForBoardSize() {
        int boardSize;
        while (true) {
            scanner = new Scanner(System.in);
            Display.askForBoardSize();
            boardSize = scanner.nextInt();
            try {
                if (boardSize >= 10 && boardSize <= 20) {
                    break;
                } else {
                    Display.displayInvalidChoiceMessage();
                }
            } catch (InputMismatchException ignored) {

            }
        }
    return boardSize;
    }
}
