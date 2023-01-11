package com.codecool.battleship;

import java.util.Arrays;

public class Battleship {
    public static void main(String[] args) {
        while (true) {
            Display.displayWelcomeMessage();
            Display.displayGameModeOptions();
            int gameMode = Input.getGameMode();
            if (gameMode == 3) {
                System.exit(0);
            } else if (gameMode == 1) {
                Game game = new Game();
                game.play();
            }
        }


        //testing
//

//        while (true) {
//            Display.displayWelcomeMessage();
//            Display.displayGameModeOptions();
//            int gameMode = Input.getGameMode();
//            System.out.println(gameMode);
//            if (gameMode == 3) {
//                System.exit(0);
//            } else if (gameMode == 1) {
//                Game game = new Game();
//                game.play();
//            }
//        }

    }
}

