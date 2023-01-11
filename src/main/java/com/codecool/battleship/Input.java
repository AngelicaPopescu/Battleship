package com.codecool.battleship;

import com.codecool.battleship.placement.Direction;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Input {

    private Scanner scanner;
    Display display = new Display();

    public int getGameMode() {
        int[] validAnswers = {1, 2, 3};
        int gameMode;
        while (true) {
            scanner = new Scanner(System.in);
            display.askForInput();
            int userInput = scanner.nextInt();
            try {
                if (checkForValidAnswer(userInput, validAnswers)) {
                    gameMode = userInput;
                    break;
                } else {
                    display.displayInvalidChoiceMessage();
                }
            } catch (InputMismatchException ignored) {
            }
        }
        return gameMode;
    }

    private boolean checkForValidAnswer(int input, int[] validAnswers) {
        for (int elem : validAnswers) {
            if (elem == input) {
                return true;
            }
        }
        return false;
    }

    public String getNameForPlayer() {
        String name;
        while (true) {
            scanner = new Scanner(System.in);
            display.askForPlayerName();
            String userChoice = scanner.nextLine();
            try {
                if (userChoice.matches("[a-zA-Z]+")) {
                    name = userChoice;
                    break;
                } else {
                    display.displayIncorrectName();
                }
            } catch (InputMismatchException ignored) {
            }
        }
        return name;
    }

    public int[] getValidCoordinates(int boardSize, String action) {
        int[] coordinates = new int[2];
        int row;
        int col;
        while (true) {
            scanner = new Scanner(System.in);
            if ((checkCoordinatesForAction(action))) {
                display.askForPlaceCoordinates();
            } else {
                display.askForShootCoordinates();
            }
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
                        display.displayInvalidChoiceMessage();
                    }
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                display.displayInvalidChoiceMessage();
            }
        }
        return coordinates;
    }


    public Direction getDirection() {
        Direction result;
//        while (true) {
            scanner = new Scanner(System.in);
            display.getBoatDirection();
            String inputs = scanner.nextLine();
//            try {
//                for (Direction c : Direction.values()) {
//                    if (c.name().equals(inputs)) {
//                        result = c;
//                        break;
//                    }
////                    } else {
////                        display.displayInvalidChoiceMessage();
////                    }
//                }
//            } catch (InputMismatchException ignored){
//            }
            result = switch (Direction.valueOf(inputs.trim())) {
                case NORTH -> Direction.NORTH;
                case SOUTH -> Direction.SOUTH;
                case EAST -> Direction.EAST;
                case WEST -> Direction.WEST;
            };
//        }
        return result;
    }

    private boolean checkCoordinatesForAction(String action) {
        return Objects.equals(action, "place");
    }

    public int askForBoardSize() {
        int boardSize;
        while (true) {
            scanner = new Scanner(System.in);
            display.askForBoardSize();
            boardSize = scanner.nextInt();
            try {
                if (boardSize >= 10 && boardSize <= 20) {
                    break;
                } else {
                    display.displayInvalidChoiceMessage();
                }
            } catch (InputMismatchException ignored) {

            }
        }
        return boardSize;
    }

    public int askForPlacementMethod() {
        int[] validAnswers = new int[]{1, 2};
        int placementMethod;
        while (true) {
            scanner = new Scanner(System.in);
            display.askForPlacement();
            placementMethod = scanner.nextInt();
            try {
                if (checkForValidAnswer(placementMethod, validAnswers)) {
                    break;
                } else {
                    display.displayInvalidChoiceMessage();
                }
            } catch (InputMismatchException ignored) {

            }
        }
        return placementMethod;
    }
}
