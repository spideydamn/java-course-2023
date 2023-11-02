package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Scanner;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.commons.lang.StringUtils;

public class ConsoleHangmanTest {
    @Test
    @DisplayName("Тестирование чистой победы")
    void testClearWon() {
        // given
        final int COMMANDS_NUMBER = 5;

        ByteArrayOutputStream logOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(logOutput));

        String[] command = new String[COMMANDS_NUMBER];
        command[0] = "s";
        command[1] = "p";
        command[2] = "o";
        command[3] = "r";
        command[4] = "t";

        String commands = "";

        for (int i = 0; i < COMMANDS_NUMBER; ++i) {
            commands += command[i];
            commands += '\n';
        }

        Scanner inputScanner = new Scanner(new ByteArrayInputStream(commands.getBytes()));

        Dictionary.setRandomSeed(1);

        //when
        ConsoleHangman.run(inputScanner);

        //then
        String logMessage = logOutput.toString();

        assertEquals(5, StringUtils.countMatches(logMessage, "The word: "));
        assertEquals(5, StringUtils.countMatches(logMessage, "Hit!"));
        assertEquals("You won!", logMessage.substring(logMessage.length() - 9, logMessage.length() - 1));
        assertEquals(0, StringUtils.countMatches(logMessage, "You asked for the letter "));
        assertEquals(0, StringUtils.countMatches(logMessage, "Incorrect input."));
    }

    @Test
    @DisplayName("Тестирование не чистой победы")
    void testNotClearWon() {
        // given
        final int COMMANDS_NUMBER = 9;

        ByteArrayOutputStream logOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(logOutput));

        String[] command = new String[COMMANDS_NUMBER];
        command[0] = "s";
        command[1] = "a";
        command[2] = "p";
        command[3] = "b";
        command[4] = "o";
        command[5] = "c";
        command[6] = "r";
        command[7] = "d";
        command[8] = "t";

        String commands = "";

        for (int i = 0; i < COMMANDS_NUMBER; ++i) {
            commands += command[i];
            commands += '\n';
        }

        Scanner inputScanner = new Scanner(new ByteArrayInputStream(commands.getBytes()));

        Dictionary.setRandomSeed(1);

        //when
        ConsoleHangman.run(inputScanner);

        //then
        String logMessage = logOutput.toString();

        assertEquals(9, StringUtils.countMatches(logMessage, "The word: "));
        assertEquals(4, StringUtils.countMatches(logMessage, "Missed"));
        assertEquals(5, StringUtils.countMatches(logMessage, "Hit!"));
        assertEquals("You won!", logMessage.substring(logMessage.length() - 9, logMessage.length() - 1));
        assertEquals(0, StringUtils.countMatches(logMessage, "You asked for the letter "));
        assertEquals(0, StringUtils.countMatches(logMessage, "Incorrect input."));
    }

    @Test
    @DisplayName("Тестирование чистого поражения")
    void testClearLose() {
        // given
        final int COMMANDS_NUMBER = 5;

        ByteArrayOutputStream logOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(logOutput));

        String[] command = new String[COMMANDS_NUMBER];
        command[0] = "a";
        command[1] = "b";
        command[2] = "c";
        command[3] = "d";
        command[4] = "e";

        String commands = "";

        for (int i = 0; i < COMMANDS_NUMBER; ++i) {
            commands += command[i];
            commands += '\n';
        }

        Scanner inputScanner = new Scanner(new ByteArrayInputStream(commands.getBytes()));

        Dictionary.setRandomSeed(1);

        //when
        ConsoleHangman.run(inputScanner);

        //then
        String logMessage = logOutput.toString();

        assertEquals(5, StringUtils.countMatches(logMessage, "The word: "));
        assertEquals(5, StringUtils.countMatches(logMessage, "Missed"));
        assertEquals("You lost!", logMessage.substring(logMessage.length() - 10, logMessage.length() - 1));
        assertEquals(0, StringUtils.countMatches(logMessage, "You asked for the letter "));
        assertEquals(0, StringUtils.countMatches(logMessage, "Incorrect input."));
    }

    @Test
    @DisplayName("Тестирование не чистого поражения")
    void testNotClearLose() {
        // given
        final int COMMANDS_NUMBER = 9;

        ByteArrayOutputStream logOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(logOutput));

        String[] command = new String[COMMANDS_NUMBER];
        command[0] = "s";
        command[1] = "p";
        command[2] = "o";
        command[3] = "r";
        command[4] = "a";
        command[5] = "b";
        command[6] = "c";
        command[7] = "d";
        command[8] = "e";

        String commands = "";

        for (int i = 0; i < COMMANDS_NUMBER; ++i) {
            commands += command[i];
            commands += '\n';
        }

        Scanner inputScanner = new Scanner(new ByteArrayInputStream(commands.getBytes()));

        Dictionary.setRandomSeed(1);

        //when
        ConsoleHangman.run(inputScanner);

        //then
        String logMessage = logOutput.toString();

        assertEquals(9, StringUtils.countMatches(logMessage, "The word: "));
        assertEquals(5, StringUtils.countMatches(logMessage, "Missed"));
        assertEquals(4, StringUtils.countMatches(logMessage, "Hit!"));
        assertEquals("You lost!", logMessage.substring(logMessage.length() - 10, logMessage.length() - 1));
        assertEquals(0, StringUtils.countMatches(logMessage, "You asked for the letter "));
        assertEquals(0, StringUtils.countMatches(logMessage, "Incorrect input."));
    }

    @Test
    @DisplayName("Тестирование неверного ввода")
    void testWrongInput() {
        // given
        final int COMMANDS_NUMBER = 6;

        ByteArrayOutputStream logOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(logOutput));

        String[] command = new String[COMMANDS_NUMBER];
        command[0] = "abc";
        command[1] = "123";
        command[2] = "1";
        command[3] = ".";
        command[4] = "ж";
        command[5] = " ";

        String commands = "";

        for (int i = 0; i < COMMANDS_NUMBER; ++i) {
            commands += command[i];
            commands += '\n';
        }

        Scanner inputScanner = new Scanner(new ByteArrayInputStream(commands.getBytes()));

        Dictionary.setRandomSeed(1);

        //when
        ConsoleHangman.run(inputScanner);

        //then
        String logMessage = logOutput.toString();

        assertEquals(0, StringUtils.countMatches(logMessage, "The word: "));
        assertEquals(0, ConsoleHangmanGame.getAttempts());
        assertEquals(6, StringUtils.countMatches(logMessage, "Incorrect input."));
        assertEquals(0, StringUtils.countMatches(logMessage, "Missed"));
        assertEquals(0, StringUtils.countMatches(logMessage, "Hit!"));
    }

    @Test
    @DisplayName("Тестирование повторяющихся букв")
    void testRepeatingLetters() {
        // given
        final int COMMANDS_NUMBER = 6;

        ByteArrayOutputStream logOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(logOutput));

        String[] command = new String[COMMANDS_NUMBER];
        command[0] = "a";
        command[1] = "a";
        command[2] = "a";
        command[3] = "b";
        command[4] = "b";
        command[5] = "c";

        String commands = "";

        for (int i = 0; i < COMMANDS_NUMBER; ++i) {
            commands += command[i];
            commands += '\n';
        }

        Scanner inputScanner = new Scanner(new ByteArrayInputStream(commands.getBytes()));

        Dictionary.setRandomSeed(1);

        //when
        ConsoleHangman.run(inputScanner);

        //then
        String logMessage = logOutput.toString();

        assertEquals(3, StringUtils.countMatches(logMessage, "The word: "));
        assertEquals(3, StringUtils.countMatches(logMessage, "Missed"));
        assertEquals(0, StringUtils.countMatches(logMessage, "Hit!"));
        assertEquals(3, StringUtils.countMatches(logMessage, "You asked for the letter "));
        assertEquals(0, StringUtils.countMatches(logMessage, "Incorrect input."));
    }

    @Test
    @DisplayName("Тестирование команды сдаться")
    void testGiveUp() {
        // given
        final int COMMANDS_NUMBER = 5;

        ByteArrayOutputStream logOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(logOutput));

        String[] command = new String[COMMANDS_NUMBER];
        command[0] = "a";
        command[1] = "b";
        command[2] = "c";
        command[3] = "d";
        command[4] = "give up";

        String commands = "";

        for (int i = 0; i < COMMANDS_NUMBER; ++i) {
            commands += command[i];
            commands += '\n';
        }

        Scanner inputScanner = new Scanner(new ByteArrayInputStream(commands.getBytes()));

        Dictionary.setRandomSeed(1);

        //when
        ConsoleHangman.run(inputScanner);

        //then
        String logMessage = logOutput.toString();

        assertEquals(4, StringUtils.countMatches(logMessage, "The word: "));
        assertEquals(4, StringUtils.countMatches(logMessage, "Missed"));
        assertEquals("You lost!", logMessage.substring(logMessage.length() - 10, logMessage.length() - 1));
    }
}
