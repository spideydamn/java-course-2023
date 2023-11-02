package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    @DisplayName("Тестирование положительных крайних левых значений разрядов")
    void leftmostPositiveRanks() {
        // given
        int[] rank = new int[9];
        rank[0] = 0;
        rank[1] = 10;
        for (int i = 2; i < 9; i++) {
            rank[i] = rank[i - 1] * 10;
        }

        // when
        int[] count = new int[9];
        for (int i = 0; i < 9; i++) {
            count[i] = Task2.countDigits(rank[i]);
        }

        // then
        for (int i = 0; i < 9; i++) {
            assertEquals(i + 1, count[i]);
        }
    }

    @Test
    @DisplayName("Тестирование положительных крайних правых значений разрядов")
    void rightmostPositiveRanks() {
        // given
        int[] rank = new int[8];
        rank[0] = 9;
        for (int i = 1; i < 8; i++) {
            rank[i] = rank[i - 1] * 10 + 9;
        }

        // when
        int[] count = new int[8];
        for (int i = 0; i < 8; i++) {
            count[i] = Task2.countDigits(rank[i]);
        }

        // then
        for (int i = 0; i < 8; i++) {
            assertEquals(i + 1, count[i]);
        }
    }

    @Test
    @DisplayName("Тестирование отрицательных крайних правых значений разрядов")
    void rightmostNegativeRanks() {
        // given
        int[] rank = new int[8];
        rank[0] = -1;
        for (int i = 1; i < 8; i++) {
            rank[i] = rank[i - 1] * 10;
        }

        // when
        int[] count = new int[8];
        for (int i = 0; i < 8; i++) {
            count[i] = Task2.countDigits(rank[i]);
        }

        // then
        for (int i = 0; i < 8; i++) {
            assertEquals(i + 1, count[i]);
        }
    }

    @Test
    @DisplayName("Тестирование отрицательных крайних левых значений разрядов")
    void leftmostNegativeRanks() {
        // given
        int[] rank = new int[8];
        rank[0] = -9;
        for (int i = 1; i < 8; i++) {
            rank[i] = rank[i - 1] * 10 - 9;
        }

        // when
        int[] count = new int[8];
        for (int i = 0; i < 8; i++) {
            count[i] = Task2.countDigits(rank[i]);
        }

        // then
        for (int i = 0; i < 8; i++) {
            assertEquals(i + 1, count[i]);
        }
    }
}
