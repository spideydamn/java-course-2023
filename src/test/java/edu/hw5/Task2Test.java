package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Task2Test {
    @Test
    @DisplayName("Тестирование getFridays13")
    void testGetFridays13() {
        // given
        int year1925 = 1925;
        int year2024 = 2024;

        // when
        LocalDate[] ans1925 = Task2.getFridays13(year1925);
        LocalDate[] ans2024 = Task2.getFridays13(year2024);

        // then
        assertEquals(LocalDate.of(1925, Month.FEBRUARY, 13), ans1925[0]);
        assertEquals(LocalDate.of(1925, Month.MARCH, 13), ans1925[1]);
        assertEquals(LocalDate.of(1925, Month.NOVEMBER, 13), ans1925[2]);

        assertEquals(LocalDate.of(2024, Month.SEPTEMBER, 13), ans2024[0]);
        assertEquals(LocalDate.of(2024, Month.DECEMBER, 13), ans2024[1]);
    }

    @Test
    @DisplayName("Тестирование getNextFriday13")
    void testGetNextFriday13() {
        // given
        LocalDate ld1 = LocalDate.of(1924, Month.DECEMBER, 31);
        LocalDate ld2 = LocalDate.of(1925, Month.FEBRUARY, 11);
        LocalDate ld3 = LocalDate.of(1925, Month.FEBRUARY, 14);

        // when
        LocalDate ans1 = Task2.getNextFriday13(ld1);
        LocalDate ans2 = Task2.getNextFriday13(ld2);
        LocalDate ans3 = Task2.getNextFriday13(ld3);

        // then
        assertEquals(LocalDate.of(1925, Month.FEBRUARY, 13), ans1);
        assertEquals(LocalDate.of(1925, Month.FEBRUARY, 13), ans2);
        assertEquals(LocalDate.of(1925, Month.MARCH, 13), ans3);
    }

    @Test
    @DisplayName("Тестирование getFridays13 на отрицательный год")
    void testGetFridays13WithNegativeYear() {
        // given
        int year1925 = -1925;

        // when
        LocalDate[] ans1925 = Task2.getFridays13(year1925);

        // then
        assertNull(ans1925);
    }

    @Test
    @DisplayName("Тестирование getNextFriday13 на null")
    void testNullCaseGetNextFriday13() {
        // given
        LocalDate ld = null;

        // when
        LocalDate ans = Task2.getNextFriday13(ld);

        // then
        assertNull(ans);
    }
}
