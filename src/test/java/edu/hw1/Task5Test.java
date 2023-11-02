package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {
    @Test
    @DisplayName("Проверка однозначных чисел")
    void oneDigit() {
        // given
        int[] number = new int[10];
        for (int i = 0; i < 10; i++) {
            number[i] = i;
        }

        // when
        boolean[] isPalindromeDescendantAns = new boolean[10];
        for (int i = 0; i < 10; i++) {
            isPalindromeDescendantAns[i] = Task5.isPalindromeDescendant(number[i]);
        }

        // then
        for (int i = 0; i < 10; i++) {
            assertFalse(isPalindromeDescendantAns[i]);
        }
    }

    @Test
    @DisplayName("Проверка двухзначных чисел")
    void twoDigit() {
        // given
        int wrongNumber = 12;
        int rightNumber = 22;

        // when
        boolean wrongIsPalindromeDescendantAns = Task5.isPalindromeDescendant(wrongNumber);
        boolean rightIsPalindromeDescendantAns = Task5.isPalindromeDescendant(rightNumber);

        // then
        assertFalse(wrongIsPalindromeDescendantAns);
        assertTrue(rightIsPalindromeDescendantAns);
    }

    @Test
    @DisplayName("Проверка двухзначных чисел c нулем в конце")
    void twoDigitWithZero() {
        // given
        int number = 10;

        // when
        boolean isPalindromeDescendantAns = Task5.isPalindromeDescendant(number);

        // then
        assertFalse(isPalindromeDescendantAns);
    }

    @Test
    @DisplayName("Проверка трехзначных чисел")
    void threeDigit() {
        // given
        int[] number = new int[6];
        number[0] = 100;
        number[1] = 101;
        number[2] = 124;
        number[3] = 421;
        number[4] = 111;
        number[5] = 110;

        // when
        boolean[] isPalindromeDescendantAns = new boolean[6];
        isPalindromeDescendantAns[0] = Task5.isPalindromeDescendant(number[0]);
        isPalindromeDescendantAns[1] = Task5.isPalindromeDescendant(number[1]);
        isPalindromeDescendantAns[2] = Task5.isPalindromeDescendant(number[2]);
        isPalindromeDescendantAns[3] = Task5.isPalindromeDescendant(number[3]);
        isPalindromeDescendantAns[4] = Task5.isPalindromeDescendant(number[4]);
        isPalindromeDescendantAns[5] = Task5.isPalindromeDescendant(number[5]);
        // then
        assertFalse(isPalindromeDescendantAns[0]);
        assertTrue(isPalindromeDescendantAns[1]);
        assertFalse(isPalindromeDescendantAns[2]);
        assertFalse(isPalindromeDescendantAns[3]);
        assertTrue(isPalindromeDescendantAns[4]);
        assertTrue(isPalindromeDescendantAns[5]);
    }

    @Test
    @DisplayName("Проверка других подходящих чисел")
    void rightMoreDigit() {
        // given
        int[] number = new int[9];
        number[0] = 11211230;
        number[1] = 13001120;
        number[2] = 23336014;
        number[3] = 11111000;
        number[4] = 50011111;
        number[5] = 51111111;
        number[6] = 50111111;
        number[7] = 1001001011;
        number[8] = 200102011;

        // when
        boolean[] isPalindromeDescendantAns = new boolean[9];
        isPalindromeDescendantAns[0] = Task5.isPalindromeDescendant(number[0]);
        isPalindromeDescendantAns[1] = Task5.isPalindromeDescendant(number[1]);
        isPalindromeDescendantAns[2] = Task5.isPalindromeDescendant(number[2]);
        isPalindromeDescendantAns[3] = Task5.isPalindromeDescendant(number[3]);
        isPalindromeDescendantAns[4] = Task5.isPalindromeDescendant(number[4]);
        isPalindromeDescendantAns[5] = Task5.isPalindromeDescendant(number[5]);
        isPalindromeDescendantAns[6] = Task5.isPalindromeDescendant(number[6]);
        isPalindromeDescendantAns[7] = Task5.isPalindromeDescendant(number[7]);
        isPalindromeDescendantAns[8] = Task5.isPalindromeDescendant(number[8]);

        // then
        assertTrue(isPalindromeDescendantAns[0]);
        assertTrue(isPalindromeDescendantAns[1]);
        assertTrue(isPalindromeDescendantAns[2]);
        assertTrue(isPalindromeDescendantAns[3]);
        assertTrue(isPalindromeDescendantAns[4]);
        assertTrue(isPalindromeDescendantAns[5]);
        assertTrue(isPalindromeDescendantAns[6]);
        assertTrue(isPalindromeDescendantAns[7]);
        assertFalse(isPalindromeDescendantAns[8]);
    }
}
