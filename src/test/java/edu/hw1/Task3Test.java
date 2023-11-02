package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3Test {
    @Test
    @DisplayName("Проверка крайних случаев снизу")
    void lowerEdgeCase() {
        // given
        int[] wrongArray1 = new int[]{2, 4};
        int[] wrongArray2 = new int[]{2, 4, 5};

        int[] rightArray1 = new int[]{3, 4};
        int[] rightArray2 = new int[]{2, 4, 5};

        //when
        boolean wrongNesting = Task3.isNestable(wrongArray1, wrongArray2);
        boolean rightNesting = Task3.isNestable(rightArray1, rightArray2);

        //then
        assertFalse(wrongNesting);
        assertTrue(rightNesting);
    }

    @Test
    @DisplayName("Проверка крайних случаев сверху")
    void upperEdgeCase() {
        // given
        int[] wrongArray1 = new int[]{3, 5};
        int[] wrongArray2 = new int[]{2, 4, 5};

        int[] rightArray1 = new int[]{3, 4};
        int[] rightArray2 = new int[]{2, 4, 5};

        //when
        boolean wrongNesting = Task3.isNestable(wrongArray1, wrongArray2);
        boolean rightNesting = Task3.isNestable(rightArray1, rightArray2);

        //then
        assertFalse(wrongNesting);
        assertTrue(rightNesting);
    }

    @Test
    @DisplayName("Проверка крайних случаев")
    void EdgeCase() {
        // given
        int[] wrongArray1 = new int[]{2, 4, 5};
        int[] wrongArray2 = new int[]{2, 4, 5};

        int[] rightArray1 = new int[]{2, 3, 4};
        int[] rightArray2 = new int[]{1, 2, 3, 4, 5};

        //when
        boolean wrongNesting = Task3.isNestable(wrongArray1, wrongArray2);
        boolean rightNesting = Task3.isNestable(rightArray1, rightArray2);

        //then
        assertFalse(wrongNesting);
        assertTrue(rightNesting);
    }
}
