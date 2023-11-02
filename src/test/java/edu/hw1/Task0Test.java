package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task0Test {
    @Test
    @DisplayName("Проверка вывода")
    void checkOutput() {
        // given
        ByteArrayOutputStream logOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(logOutput));

        // when
        Task0.helloWorld();

        //then
        String logMessage = logOutput.toString();
        assertEquals(logMessage.substring(logMessage.length() - 18, logMessage.length() - 5), "Hello, world!");
    }
}
