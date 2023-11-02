package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test
    @DisplayName("Проверка String четной длины")
    void evenString() {
        // given
        String s = "abracadabr";

        // when
        String rightS = Task4.fixString(s);

        //then
        assertEquals("baaracadrb", rightS);
    }

    @Test
    @DisplayName("Проверка char[] четной длины")
    void evenCharArray() {
        // given
        char[] s = new char[]{'a', 'b', 'r', 'a', 'c', 'a', 'd', 'a', 'b', 'r'};

        // when
        String rightS = Task4.fixString(s);

        //then
        assertEquals("baaracadrb", rightS);
    }

    @Test
    @DisplayName("Проверка String нечетной длины")
    void oddString() {
        // given
        String s = "abracadabra";

        // when
        String rightS = Task4.fixString(s);

        //then
        assertEquals("baaracadrba", rightS);
    }

    @Test
    @DisplayName("Проверка char[] нечетной длины")
    void oddCharArray() {
        // given
        char[] s = new char[]{'a', 'b', 'r', 'a', 'c', 'a', 'd', 'a', 'b', 'r', 'a'};

        // when
        String rightS = Task4.fixString(s);

        //then
        assertEquals("baaracadrba", rightS);
    }

    @Test
    @DisplayName("Проверка String длины один")
    void oneString() {
        // given
        String s = "a";

        // when
        String rightS = Task4.fixString(s);

        //then
        assertEquals("a", rightS);
    }

    @Test
    @DisplayName("Проверка char[] длины один")
    void oneCharArray() {
        // given
        char[] s = new char[]{'a'};

        // when
        String rightS = Task4.fixString(s);

        //then
        assertEquals("a", rightS);
    }

    @Test
    @DisplayName("Проверка String нулевой длины")
    void zeroString() {
        // given
        String s = "";

        // when
        String rightS = Task4.fixString(s);

        //then
        assertEquals("", rightS);
    }

    @Test
    @DisplayName("Проверка char[] нулевой длины")
    void zeroCharArray() {
        // given
        char[] s = new char[]{};

        // when
        String rightS = Task4.fixString(s);

        //then
        assertEquals("", rightS);
    }
}
