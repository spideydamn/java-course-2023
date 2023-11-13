package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.text.ParseException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    @DisplayName("Тестирование общих случаев")
    void testGeneralCases() throws ParseException {
        // given
        String[] s = {"2022-03-12, 20:20 - 2022-03-12, 23:50", "2022-04-01, 21:30 - 2022-04-02, 01:20"};

        // when
        String middleDuration = Task1.getMiddleTime(s);

        // then
        assertEquals("3ч 40м", middleDuration);
    }

    @Test
    @DisplayName("Тестирование null")
    void testNullCase() throws ParseException {
        // given
        String[] s = null;

        // when
        String middleDuration = Task1.getMiddleTime(s);

        // then
        assertEquals("0ч 0м", middleDuration);
    }
}
