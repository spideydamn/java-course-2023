package edu.project1;

import java.util.Scanner;

@SuppressWarnings("RegexpSinglelineJava")
public class ConsoleHangman {
    private ConsoleHangman() {
    }

    private static final int MAX_ATTEMPTS = 5;

    public static void run(Scanner inputScanner) throws java.util.NoSuchElementException {

        ConsoleHangmanGame.reload(MAX_ATTEMPTS, Dictionary.getRandomWord());

        while (!ConsoleHangmanGame.isEnded()) {
            System.out.print("Guess a letter:\n");
            String input = "";

            try {
                input = inputScanner.nextLine();
            } catch (java.util.NoSuchElementException e) { // for testing
                ConsoleHangmanGame.endGame();
                continue;
            }

            if (input.equals("give up")) {
                ConsoleHangmanGame.endGame();
            } else {
                ConsoleHangmanGame.tryGuess(input);
            }
        }
    }
}
