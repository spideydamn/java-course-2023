package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task7Test {
    @Test
    @DisplayName("Проверка циклического сдвига вправо")
    void checkRotateRight() {
        // given
        int[] numbers = new int[] {8, 16, 7};
        int[] shifts = new int[] {1, 8, 128};

        // when
        int[] rotates = new int[3];
        rotates[0] = Task7.rotateRight(numbers[0], shifts[0]);
        rotates[1] = Task7.rotateRight(numbers[1], shifts[1]);
        rotates[2] = Task7.rotateRight(numbers[2], shifts[2]);

        //then
        assertEquals(4, rotates[0]);
        assertEquals(2, rotates[1]);
        assertEquals(7, rotates[2]);
    }
    @Test
    @DisplayName("Проверка циклического сдвига влево")
    void checkRotateLeft() {
        // given
        int[] numbers = new int[] {8, 16, 7};
        int[] shifts = new int[] {1, 8, 128};

        // when
        int[] rotates = new int[3];
        rotates[0] = Task7.rotateLeft(numbers[0], shifts[0]);
        rotates[1] = Task7.rotateLeft(numbers[1], shifts[1]);
        rotates[2] = Task7.rotateLeft(numbers[2], shifts[2]);

        //then
        assertEquals(1, rotates[0]);
        assertEquals(4, rotates[1]);
        assertEquals(7, rotates[2]);
    }
    @Test
    @DisplayName("Проверка крайних случаев")
    void checkEdgeCases() {
        // given
        int[] numbers = new int[] {0, 1, 134217727};
        int[] shifts = new int[] {228, 1337, 999999999};

        // when
        int[] rotates = new int[3];
        rotates[0] = Task7.rotateLeft(numbers[0], shifts[0]);
        rotates[1] = Task7.rotateLeft(numbers[1], shifts[1]);
        rotates[2] = Task7.rotateLeft(numbers[2], shifts[2]);

        //then
        assertEquals(0, rotates[0]);
        assertEquals(1, rotates[1]);
        assertEquals(134217727, rotates[2]);
    }
}
