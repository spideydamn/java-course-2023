package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Task3Test {
    @Test
    @DisplayName("Проверка общих случаев")
    void checkGeneralCases() {
        // given
        String[] Array1 = new String[]{"a", "bb", "a", "bb"};
        String[] Array2 = new String[]{"this", "and", "that", "and"};
        String[] Array3 = new String[]{"код", "код", "код", "bug"};
        Integer[] Array4 = new Integer[]{1, 1, 2, 2};
        Double[] Array5 = new Double[]{1.12, 1.4, 2.3, 1.12, 2.3};

        // when
        HashMap<Object, Integer> freqDict1 = Task3.freqDict(Array1);
        HashMap<Object, Integer> freqDict2 = Task3.freqDict(Array2);
        HashMap<Object, Integer> freqDict3 = Task3.freqDict(Array3);
        HashMap<Object, Integer> freqDict4 = Task3.freqDict(Array4);
        HashMap<Object, Integer> freqDict5 = Task3.freqDict(Array5);

        //then
        assertEquals(2, freqDict1.get("a"));
        assertEquals(2, freqDict1.get("bb"));

        assertEquals(1, freqDict2.get("this"));
        assertEquals(2, freqDict2.get("and"));
        assertEquals(1, freqDict2.get("that"));

        assertEquals(3, freqDict3.get("код"));
        assertEquals(1, freqDict3.get("bug"));

        assertEquals(2, freqDict4.get(1));
        assertEquals(2, freqDict4.get(2));

        assertEquals(2, freqDict5.get(1.12));
        assertEquals(2, freqDict5.get(2.3));
        assertEquals(1, freqDict5.get(1.4));
    }

    @Test
    @DisplayName("Проверка крайних случаев")
    void checkEdgeCases() {
        // given
        Integer[] Array1 = new Integer[]{0};
        Integer[] Array2 = new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Integer[] Array3 = new Integer[]{};

        //when
        HashMap<Object, Integer> freqDict1 = Task3.freqDict(Array1);
        HashMap<Object, Integer> freqDict2 = Task3.freqDict(Array2);
        HashMap<Object, Integer> freqDict3 = Task3.freqDict(Array3);

        // then
        assertEquals(1, freqDict1.get(0));
        assertEquals(10, freqDict2.get(0));
        assertEquals(0, freqDict3.size());
    }

    @Test
    @DisplayName("Проверка null")
    void checkNullCase() {
        // given
        String[] Array = null;

        //when
        HashMap<Object, Integer> freqDict = Task3.freqDict(Array);

        // then
        assertNull(freqDict);
    }
}
