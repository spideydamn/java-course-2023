package edu.hw5;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class NextFriday13Adjuster implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        int fieldDayOfWeek = temporal.get(ChronoField.DAY_OF_WEEK);
        DayOfWeek dayOfWeek = DayOfWeek.of(fieldDayOfWeek);

        int daysToAdd = 7;
        if (DayOfWeek.THURSDAY.equals(dayOfWeek)) {
            daysToAdd = 1;
        } else if (DayOfWeek.WEDNESDAY.equals(dayOfWeek)) {
            daysToAdd = 2;
        } else if (DayOfWeek.TUESDAY.equals(dayOfWeek)) {
            daysToAdd = 3;
        } else if (DayOfWeek.MONDAY.equals(dayOfWeek)) {
            daysToAdd = 4;
        } else if (DayOfWeek.SUNDAY.equals(dayOfWeek)) {
            daysToAdd = 5;
        } else if (DayOfWeek.SATURDAY.equals(dayOfWeek)) {
            daysToAdd = 6;
        }
        temporal = temporal.plus(daysToAdd, ChronoUnit.DAYS);

        while (temporal.get(ChronoField.DAY_OF_MONTH) != 13) {
            temporal = temporal.plus(7, ChronoUnit.DAYS);
        }

        return temporal;
    }
}
