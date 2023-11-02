package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    @DisplayName("Проверка на отсутствие количества минут")
    void emptyMinutes() {
        // given
        String time = ":37";

        // when
        int seconds = Task1.minutesToSeconds(time);

        // then
        assertEquals(-1, seconds);
    }

    @Test
    @DisplayName("Проверка на отсутствие количества секунд")
    void emptySeconds() {
        // given
        String time = "13:";

        // when
        int seconds = Task1.minutesToSeconds(time);

        // then
        assertEquals(-1, seconds);
    }

    @Test
    @DisplayName("Проверка на отсутствие минут и секунд")
    void emptyMinutesAndSeconds() {
        // given
        String time = ":";

        // when
        int seconds = Task1.minutesToSeconds(time);

        // then
        assertEquals(-1, seconds);
    }

    @Test
    @DisplayName("Проверка на пустой ввод")
    void emptyInput() {
        // given
        String time = "";

        // when
        int seconds = Task1.minutesToSeconds(time);

        // then
        assertEquals(-1, seconds);
    }

    @Test
    @DisplayName("Проверка на неверный ввод")
    void wrongInput() {
        // given
        String time = "fwerfgq2123wertg23";

        // when
        int seconds = Task1.minutesToSeconds(time);

        // then
        assertEquals(-1, seconds);
    }

    @Test
    @DisplayName("Проверка на отрицательное количество минут")
    void negativeMinutes() {
        // given
        String time = "-1:48";

        // when
        int seconds = Task1.minutesToSeconds(time);

        // then
        assertEquals(-1, seconds);
    }

    @Test
    @DisplayName("Проверка на отрицательное количество секунд")
    void negativeSeconds() {
        // given
        String time = "13:-1";

        // when
        int seconds = Task1.minutesToSeconds(time);

        // then
        assertEquals(-1, seconds);
    }

    @Test
    @DisplayName("Проверка на одноразрядность секунд")
    void singleDigitSeconds() {
        // given
        String time = "22:8";

        // when
        int seconds = Task1.minutesToSeconds(time);

        // then
        assertEquals(-1, seconds);
    }

    @Test
    @DisplayName("Проверка нуля секунд")
    void zeroSeconds() {
        // given
        String time = "22:00";

        // when
        int seconds = Task1.minutesToSeconds(time);

        // then
        assertEquals(1320, seconds);
    }

    @Test
    @DisplayName("Проверка нуля минут")
    void zeroMinutes() {
        // given
        String time = "0:12";

        // when
        int seconds = Task1.minutesToSeconds(time);

        // then
        assertEquals(12, seconds);
    }

    @Test
    @DisplayName("Проверка нуля минут и секунд")
    void zeroZero() {
        // given
        String time = "0:00";

        // when
        int seconds = Task1.minutesToSeconds(time);

        // then
        assertEquals(0, seconds);
    }

    @Test
    @DisplayName("Проверка на неограниченное количество минут")
    void unlimitedMinutes() {
        // given
        String time = "35791393:21";

        // when
        int seconds = Task1.minutesToSeconds(time);

        // then
        assertEquals(2147483601, seconds);
    }

    @Test
    @DisplayName("Проверка на ограниченное количество секунд")
    void limitedSeconds() {
        // given
        String wrongTime = "35791393:60";
        String rightTime59 = "35791393:59";
        String rightTime00 = "35791393:00";

        // when
        int wrongSeconds = Task1.minutesToSeconds(wrongTime);
        int rightSeconds59 = Task1.minutesToSeconds(rightTime59);
        int rightSeconds00 = Task1.minutesToSeconds(rightTime00);

        // then
        assertEquals(-1, wrongSeconds);
        assertEquals(2147483639, rightSeconds59);
        assertEquals(2147483580, rightSeconds00);
    }

    @Test
    @DisplayName("Проверка арифметики")
    void arithmeticCheck() {
        for (int minutes = 0; minutes < 1000; ++minutes) {
            for (int seconds = 0; seconds < 60; ++seconds) {
                // given
                String time = Integer.toString(minutes) + ':' +
                    ((seconds < 10) ? "0" + Integer.toString(seconds) : Integer.toString(seconds));
                ;

                // when
                int answer = Task1.minutesToSeconds(time);

                // then
                assertEquals(minutes * 60 + seconds, answer);
            }
        }
    }

    @Test
    @DisplayName("Проверка null")
    void nullCheck() {
        // given
        String time = null;

        // when
        int timeInSeconds = Task1.minutesToSeconds(time);

        // then
        assertEquals(-1, timeInSeconds);
    }
}
