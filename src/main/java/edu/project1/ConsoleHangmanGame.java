package edu.project1;

import java.util.Arrays;

@SuppressWarnings("RegexpSinglelineJava")
public class ConsoleHangmanGame {
    private ConsoleHangmanGame() {}

    private static final int ALPHABET_SIZE = 26;
    private static final boolean[] CHECKED_LETTERS = new boolean[ALPHABET_SIZE];
    private static String guessWord;
    private static int attempts;
    private static int maxAttempts;
    private static boolean isEnded = false;

    public static void reload(int theMaxAttempts, String theGuessWord) {
        attempts = 0;
        maxAttempts = theMaxAttempts;
        guessWord = theGuessWord;
        isEnded = false;
        Arrays.fill(CHECKED_LETTERS, false);
    }

    public static int getAttempts() {
        return attempts;
    }

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

    public static void tryGuess(String input) {
        char letter;
        if (isLetter(input)) {
            letter = input.charAt(0);
        } else {
            sendIncorrectInputMessage(input);
            return;
        }

        if (thisLetterWasAsked(letter)) {
            sendRepeatLetterMessage(letter);
        } else {
            checkTheLetter(letter);
        }
    }

    private static void checkTheLetter(char letter) {
        CHECKED_LETTERS[letter - 'a'] = true;
        if (guessWord.indexOf(letter) == -1) {
            attempts++;
            sendMistakeMessage();
            stateOutput();
            if (attempts == maxAttempts) {
                endGame();
            }
            return;
        }
        sendHitMessage();
        stateOutput();
    }

    public static void endGame() {
        isEnded = true;
        for (int i = 0; i < guessWord.length(); ++i) {
            if (!thisLetterWasAsked(guessWord.charAt(i))) {
                sendLostMessage();
                return;
            }
        }
        sendWonMessage();
    }

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

    private static void sendLostMessage() {
        System.out.print("You lost!\n");
    }

    private static void sendWonMessage() {
        System.out.print("You won!\n");
    }

    private static void sendHitMessage() {
        System.out.print("Hit!\n\n");
    }

    private static void sendMistakeMessage() {
        System.out.printf("Missed, mistake %d out of %d.\n\n", attempts, maxAttempts);
    }

    private static void sendIncorrectInputMessage(String input) {
        System.out.printf("Incorrect input. \"%s\" is not a letter. Try again\n\n", input);
    }

    private static void sendRepeatLetterMessage(char letter) {
        System.out.printf("You asked for the letter \"%c\", try another\n\n", letter);
    }
}
