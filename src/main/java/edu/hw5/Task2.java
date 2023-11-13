package edu.hw5;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjuster;
import java.util.ArrayList;

public class Task2 {
    private Task2() {}

    public static LocalDate getNextFriday13(LocalDate localDate) {
        if (localDate == null) {
            return null;
        }
        TemporalAdjuster adjuster = new NextFriday13Adjuster();
        return (LocalDate)adjuster.adjustInto(localDate);
    }

    public static LocalDate[] getFridays13(int year) {
        if (year < 0) {
            return null;
        }
        ArrayList<LocalDate> listAns = new ArrayList<>();
        LocalDate currentDay = LocalDate.of(year , Month.JANUARY , 1);
        while (currentDay.getYear() == year) {
            currentDay = getNextFriday13(currentDay);
            listAns.add(currentDay);
        }
        listAns.remove(listAns.size() - 1);
        LocalDate[] ans = new LocalDate[listAns.size()];
        listAns.toArray(ans);
        return ans;
    }
}

