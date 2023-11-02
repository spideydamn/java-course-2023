package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6Test {
    @Test
    @DisplayName("Проверка крайних случаев")
    void checkEdgeCases() {
        // given
        int[] number = new int[] {1001, 6174, 9998};

        // when
        int[] countKAns = new int[3];
        for (int i = 0; i < 3; i++) {
            countKAns[i] = Task6.countK(number[i]);
        }

        //then
        assertEquals(4, countKAns[0]);
        assertEquals(0, countKAns[1]);
        assertEquals(5, countKAns[2]);
    }
    @Test
    @DisplayName("Проверка неверных случаев")
    void checkWrongCases() {
        // given
        int[] number = new int[] {999, 1000, 1111, 9999, 10000};

        // when
        int[] countKAns = new int[5];
        for (int i = 0; i < 5; i++) {
            countKAns[i] = Task6.countK(number[i]);
        }

        //then
        for (int i = 0; i < 5; i++) {
            assertEquals(-1, countKAns[0]);
        }
    }
    @Test
    @DisplayName("Проверка других случаев")
    void checkAnotherCases() {
        // given
        int[] number = new int[] {1311, 1110, 2228, 1488, 8889};

        // when
        int[] countKAns = new int[5];
        for (int i = 0; i < 5; i++) {
            countKAns[i] = Task6.countK(number[i]);
        }

        //then
        assertEquals(4, countKAns[0]);
        assertEquals(5, countKAns[1]);
        assertEquals(6, countKAns[2]);
        assertEquals(3, countKAns[3]);
        assertEquals(5, countKAns[4]);
    }
}
