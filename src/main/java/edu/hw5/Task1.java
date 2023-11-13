package edu.hw5;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import static java.time.Duration.ofMillis;

public class Task1 {
    private Task1() {}

    public static String getMiddleTime(String[] durations) throws ParseException {
        if (durations == null) {
            return "0ч 0м";
        }
        long sumMilliseconds = 0;
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd, hh:mm");
        for (String s : durations) {
            String[] duration = s.split(" - ");
            sumMilliseconds += formatter.parse(duration[1]).getTime() - formatter.parse(duration[0]).getTime();
        }
        sumMilliseconds /= durations.length;
        Duration answer = ofMillis(sumMilliseconds);
        return String.format("%dч %dм", answer.toHours(), answer.toMinutesPart());
    }
}
