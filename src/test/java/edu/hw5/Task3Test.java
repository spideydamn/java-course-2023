package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {
    @Test
    @DisplayName("Тестирование основных случаев")
    void testGeneralCases() {
        // given
        String[] dates = new String[9];
        dates[0] = "2020-10-10";
        dates[1] = "2020-12-2";
        dates[2] = "1/3/1976";
        dates[3] = "1/3/20";
        dates[4] = "tomorrow";
        dates[5] = "today";
        dates[6] = "yesterday";
        dates[7] = "1 day ago";
        dates[8] = "2234 days ago";

        // when
        Optional[] parsedDates = new Optional[9];
        parsedDates[0] = Task3.parseDate(dates[0]);
        parsedDates[1] = Task3.parseDate(dates[1]);
        parsedDates[2] = Task3.parseDate(dates[2]);
        parsedDates[3] = Task3.parseDate(dates[3]);
        parsedDates[4] = Task3.parseDate(dates[4]);
        parsedDates[5] = Task3.parseDate(dates[5]);
        parsedDates[6] = Task3.parseDate(dates[6]);
        parsedDates[7] = Task3.parseDate(dates[7]);
        parsedDates[8] = Task3.parseDate(dates[8]);

        //then
        assertEquals(LocalDate.of(2020, 10, 10), parsedDates[0].get());
        assertEquals(LocalDate.of(2020, 12, 2), parsedDates[1].get());
        assertEquals(LocalDate.of(1976, 3, 1), parsedDates[2].get());
        assertEquals(LocalDate.of(2020, 3, 1), parsedDates[3].get());
        assertEquals(LocalDate.now().plusDays(1), parsedDates[4].get());
        assertEquals(LocalDate.now(), parsedDates[5].get());
        assertEquals(LocalDate.now().minusDays(1), parsedDates[6].get());
        assertEquals(LocalDate.now().minusDays(1), parsedDates[7].get());
        assertEquals(LocalDate.now().minusDays(2234), parsedDates[8].get());
    }

    @Test
    @DisplayName("Тестирование основных случаев")
    void testGeneralCases() {
        // given
        String[] dates = new String[9];
        dates[0] = "2020-10-10";
        dates[1] = "2020-12-2";
        dates[2] = "1/3/1976";
        dates[3] = "1/3/20";
        dates[4] = "tomorrow";
        dates[5] = "today";
        dates[6] = "yesterday";
        dates[7] = "1 day ago";
        dates[8] = "2234 days ago";

        // when
        Optional[] parsedDates = new Optional[9];
        parsedDates[0] = Task3.parseDate(dates[0]);
        parsedDates[1] = Task3.parseDate(dates[1]);
        parsedDates[2] = Task3.parseDate(dates[2]);
        parsedDates[3] = Task3.parseDate(dates[3]);
        parsedDates[4] = Task3.parseDate(dates[4]);
        parsedDates[5] = Task3.parseDate(dates[5]);
        parsedDates[6] = Task3.parseDate(dates[6]);
        parsedDates[7] = Task3.parseDate(dates[7]);
        parsedDates[8] = Task3.parseDate(dates[8]);

        //then
        assertEquals(LocalDate.of(2020, 10, 10), parsedDates[0].get());
        assertEquals(LocalDate.of(2020, 12, 2), parsedDates[1].get());
        assertEquals(LocalDate.of(1976, 3, 1), parsedDates[2].get());
        assertEquals(LocalDate.of(2020, 3, 1), parsedDates[3].get());
        assertEquals(LocalDate.now().plusDays(1), parsedDates[4].get());
        assertEquals(LocalDate.now(), parsedDates[5].get());
        assertEquals(LocalDate.now().minusDays(1), parsedDates[6].get());
        assertEquals(LocalDate.now().minusDays(1), parsedDates[7].get());
        assertEquals(LocalDate.now().minusDays(2234), parsedDates[8].get());
    }
}
