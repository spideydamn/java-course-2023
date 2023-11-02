package edu.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3Test {
    static ByteArrayOutputStream logOutput = new ByteArrayOutputStream();

    @Test
    @DisplayName("Тестирование стандартного менеджера подключения с успешным подключением")
    void successfulDefaultManagerTest() {
        // given
        System.setOut(new PrintStream(logOutput));
        Task3.setRandomSeed(1);

        // when
        Task3.DefaultConnectionManager manager = new Task3.DefaultConnectionManager();
        Task3.PopularCommandExecutor executor = new Task3.PopularCommandExecutor(manager, 1);
        executor.tryExecute("command");

        //then
        String logMessage = logOutput.toString();
        assertTrue(logMessage.contains("Stable connection established. Sent command \"command\""));
    }

    @Test
    @DisplayName("Тестирование стандартного менеджера подключения с неудавшимся подключением")
    void failedDefaultManagerTest() {
        // given
        System.setOut(new PrintStream(logOutput));
        Task3.setRandomSeed(3);

        // when
        Task3.DefaultConnectionManager manager = new Task3.DefaultConnectionManager();
        Task3.PopularCommandExecutor executor = new Task3.PopularCommandExecutor(manager, 1);
        executor.tryExecute("command");

        //then
        String logMessage = logOutput.toString();
        assertTrue(logMessage.contains("Faulty connection failed"));
    }

    @Test
    @DisplayName("Тестирование проблемного менеджера подключения с успешным подключением")
    void successfulFaultyManagerTest() {
        // given
        System.setOut(new PrintStream(logOutput));
        Task3.setRandomSeed(1);

        // when
        Task3.FaultyConnectionManager manager = new Task3.FaultyConnectionManager();
        Task3.PopularCommandExecutor executor = new Task3.PopularCommandExecutor(manager, 1);
        executor.tryExecute("command");

        //then
        String logMessage = logOutput.toString();
        assertTrue(logMessage.contains("Faulty connection established. Sent command \"command\""));
    }

    @Test
    @DisplayName("Тестирование проблемного менеджера подключения с неудавшимся подключением")
    void failedFaultyManagerTest() {
        // given
        System.setOut(new PrintStream(logOutput));
        Task3.setRandomSeed(3);
        boolean wasException = false;

        // when
        Task3.FaultyConnectionManager manager = new Task3.FaultyConnectionManager();
        Task3.PopularCommandExecutor executor = new Task3.PopularCommandExecutor(manager, 1);
        executor.tryExecute("command");

        //then
        String logMessage = logOutput.toString();
        assertTrue(logMessage.contains("Faulty connection failed"));
    }

    @Test
    @DisplayName("Тестирование updatePackages")
    void updatePackagesTest() {
        // given
        System.setOut(new PrintStream(logOutput));
        Task3.setRandomSeed(1);

        // when
        Task3.DefaultConnectionManager manager = new Task3.DefaultConnectionManager();
        Task3.PopularCommandExecutor executor = new Task3.PopularCommandExecutor(manager, 1);
        executor.updatePackages();

        //then
        String logMessage = logOutput.toString();
        assertTrue(logMessage.contains("Stable connection established. Sent command \"apt update && apt upgrade -y\""));
    }
}
