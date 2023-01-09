package com.codecool.battleship;

import java.util.InputMismatchException;
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
        Scanner input = new Scanner(System.in);
        Display.askForPlayerName();
        return input.nextLine();
    }
}
