package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Task4Test {
    @Test
    @DisplayName("Проверка общих случаев")
    void checkGenerealCases() {
        // given
        int number1 = 2;
        int number2 = 4;
        int number3 = 12;
        int number4 = 16;
        int number5 = 19;

        // when
        String romanNumber1 = Task4.convertToRoman(number1);
        String romanNumber2 = Task4.convertToRoman(number2);
        String romanNumber3 = Task4.convertToRoman(number3);
        String romanNumber4 = Task4.convertToRoman(number4);
        String romanNumber5 = Task4.convertToRoman(number5);

        // then
        assertEquals("II", romanNumber1);
        assertEquals("IV", romanNumber2);
        assertEquals("XII", romanNumber3);
        assertEquals("XVI", romanNumber4);
        assertEquals("XIX", romanNumber5);
    }

    @Test
    @DisplayName("Проверка крайних случаев")
    void checkEdgeCases() {
        // given
        int negativeNumber = -228;
        int number0 = 0;
        int number1 = 1;
        int number2 = 9;
        int number3 = 99;
        int number4 = 999;
        int number5 = 9999;

        // when
        String romanNegativeNumber = Task4.convertToRoman(negativeNumber);
        String romanNumber0 = Task4.convertToRoman(number0);
        String romanNumber1 = Task4.convertToRoman(number1);
        String romanNumber2 = Task4.convertToRoman(number2);
        String romanNumber3 = Task4.convertToRoman(number3);
        String romanNumber4 = Task4.convertToRoman(number4);
        String romanNumber5 = Task4.convertToRoman(number5);

        // then
        assertNull(romanNegativeNumber);
        assertNull(romanNumber0);
        assertEquals("I", romanNumber1);
        assertEquals("IX", romanNumber2);
        assertEquals("XCIX", romanNumber3);
        assertEquals("CMXCIX", romanNumber4);
        assertEquals("MMMMMMMMMCMXCIX", romanNumber5);
    }
}
