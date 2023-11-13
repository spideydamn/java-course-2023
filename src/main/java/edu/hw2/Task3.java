package edu.hw2;

import java.util.Random;

@SuppressWarnings("RegexpSinglelineJava")
public class Task3 {
    private Task3() {}

    static Random rnd = new Random();
    final static int FAILURE_PROBABILITY = 4;

    static void setRandomSeed(int seed) { // for testing
        rnd.setSeed(seed);
    }

    public interface Connection extends AutoCloseable {
        void execute(String command);
    }

    public interface ConnectionManager {
        Connection getConnection();
    }

    public static class ConnectionException extends RuntimeException {
        public ConnectionException(String message) {
            super(message);
        }
    }

    public static final class PopularCommandExecutor {
        PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
            this.manager = manager;
            this.maxAttempts = maxAttempts;
        }

        private final ConnectionManager manager;
        private final int maxAttempts;

        private Exception cause;

        public void updatePackages() {
            tryExecute("apt update && apt upgrade -y");
        }

        void tryExecute(String command) throws ConnectionException {
            for (int i = 0; i < maxAttempts; ++i) {
                try {
                    Connection connection = this.manager.getConnection();
                    connection.execute(command);
                    connection.close();
                    return;
                } catch (Exception e) {
                    this.cause = e;
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    static class StableConnection implements Connection {
        @Override
        public void execute(String command) {
            System.out.printf("Stable connection established. Sent command \"%s\"%n", command);
        }

        @Override
        public void close() {
            System.out.println("Stable connection closed");
        }
    }

    static class FaultyConnection implements Connection {
        @Override
        public void execute(String command) throws ConnectionException {
            if (rnd.nextInt() % FAILURE_PROBABILITY == 0) {
                throw new ConnectionException("Faulty connection failed");
            }
            System.out.printf("Faulty connection established. Sent command \"%s\"%n", command);
        }

        @Override
        public void close() {
            System.out.println("Faulty connection closed");
        }
    }

    static class DefaultConnectionManager implements ConnectionManager {
        @Override
        public Connection getConnection() throws ConnectionException {
            if (rnd.nextInt() % FAILURE_PROBABILITY == 0) {
                return new FaultyConnection();
            }
            return new StableConnection();
        }
    }

    static class FaultyConnectionManager implements ConnectionManager {
        @Override
        public Connection getConnection() throws ConnectionException {
            return new FaultyConnection();
        }
    }
}
