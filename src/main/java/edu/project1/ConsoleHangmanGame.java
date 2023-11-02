package edu.project1;

import java.util.Arrays;

@SuppressWarnings("RegexpSinglelineJava")
public class ConsoleHangmanGame {
    private ConsoleHangmanGame() {}

    private static final int ALPHABET_SIZE = 26;
    private static int attempts;
    private static int maxAttempts;
    private static String guessWord;
    private static final boolean[] CHECKED_LETTERS = new boolean[ALPHABET_SIZE];
    private static boolean isEnded = false;

    public static void reload(int theMaxAttempts, String theGuessWord) {
        attempts = 0;
        maxAttempts = theMaxAttempts;
        guessWord = theGuessWord;
        isEnded = false;
        Arrays.fill(CHECKED_LETTERS, false);
    }

    // getters:
    public static int getAttempts() {
        return attempts;
    }

    // checkers:
    public static boolean isEnded() {
        return isEnded;
    }

    private static boolean thisLetterWasAsked(char letter) {
        return CHECKED_LETTERS[letter - 'a'];
    }

    private static boolean isLetter(String letter) {
        if (letter.length() != 1) {
            return false;
        }
        return ('a' <= letter.charAt(0) && letter.charAt(0) <= 'z');
    }

    // gaming features:
    public static void tryGuess(String input) {
        char letter;
        if (isLetter(input)) {
            letter = input.charAt(0);
        } else {
            System.out.printf("Incorrect input. \"%s\" is not a letter. Try again\n\n", input);
            return;
        }

        if (thisLetterWasAsked(letter)) {
            System.out.printf("You asked for the letter \"%c\", try another\n\n", letter);
        } else {
            checkTheLetter(letter);
        }
    }

    private static void checkTheLetter(char letter) {
        CHECKED_LETTERS[letter - 'a'] = true;
        if (guessWord.indexOf(letter) == -1) {
            attempts++;
            System.out.printf("Missed, mistake %d out of %d.\n\n", attempts, maxAttempts);
            stateOutput();
            if (attempts == maxAttempts) {
                endGame();
            }
            return;
        }
        System.out.print("Hit!\n\n");
        stateOutput();
    }

    public static void endGame() {
        isEnded = true;
        for (int i = 0; i < guessWord.length(); ++i) {
            if (!thisLetterWasAsked(guessWord.charAt(i))) {
                System.out.print("You lost!\n");
                return;
            }
        }
        System.out.print("You won!\n");
    }

    // output:
    private static void stateOutput() {
        System.out.print("The word: ");
        int countGuessedLetters = 0;
        for (int i = 0; i < guessWord.length(); ++i) {
            if (thisLetterWasAsked(guessWord.charAt(i))) {
                System.out.print(guessWord.charAt(i));
                countGuessedLetters++;
            } else {
                System.out.print("*");
            }
        }
        System.out.print("\n\n");
        if (countGuessedLetters == guessWord.length()) {
            endGame();
        }
    }
}
