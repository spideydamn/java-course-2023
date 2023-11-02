package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Task1Test {
    @Test
    @DisplayName("Проверка строчных букв")
    void checkingLowerCases() {
        // given
        String string = "abcdefghijklmnopqrstuvwxyz";

        // when
        String newString = Task1.atBash(string);

        // then
        assertEquals("zyxwvutsrqponmlkjihgfedcba", newString);
    }

    @Test
    @DisplayName("Проверка заглавных букв")
    void checkingUpperCases() {
        // given
        String string = "abcdefghijklmnopqrstuvwxyz".toUpperCase();

        // when
        String newString = Task1.atBash(string);

        // then
        assertEquals("zyxwvutsrqponmlkjihgfedcba".toUpperCase(), newString);
    }

    @Test
    @DisplayName("Проверка разных регистров в одной строке")
    void checkingDifferentRegisters() {
        // given
        String string = "aBcDeFgHiJkLmNoPqRsTuVwXyZ";

        // when
        String newString = Task1.atBash(string);

        //when
        assertEquals("zYxWvUtSrQpOnMlKjIhGfEdCbA", newString);
    }

    @Test
    @DisplayName("Проверка null")
    void checkingNullCase() {
        //given
        String string = null;

        //then
        String newString = Task1.atBash(string);

        //when
        assertNull(newString);
    }
}
