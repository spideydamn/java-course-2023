package edu.hw1;

public class Task1 {
    private Task1() {}

    static final int SECONDS_IN_A_MINUTE = 60;

    public static int minutesToSeconds(String time) {
        if (time == null || time.indexOf(":") == 0 || time.indexOf(":") >= time.length() - 2) {
            return -1;
        }
        String[] numbers = time.split(":");
        int minutes;
        int seconds;
        try {
            minutes = Integer.parseInt(numbers[0]);
            seconds = Integer.parseInt(numbers[1]);
        } catch (NumberFormatException e) {
            return -1;
        }
        if (minutes >= 0 && (seconds >= 0 && seconds < SECONDS_IN_A_MINUTE)) {
            return minutes * SECONDS_IN_A_MINUTE + seconds;
        }
        return -1;
    }
}
