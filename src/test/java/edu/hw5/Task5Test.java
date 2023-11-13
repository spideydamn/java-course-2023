package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {
    @Test
    @DisplayName("Тестирование подходящих номеров")
    void testTrueNumbers() {
        // given
        final int CASES_NUMBER = 5;
        String[] numbers = new String[CASES_NUMBER];
        numbers[0] = "А123ВЕ777";
        numbers[1] = "О777ОО177";
        numbers[2] = "О999ОО999";
        numbers[3] = "Е991КХ092";
        numbers[4] = "О777ОО177";

        // when
        boolean[] validations = new boolean[CASES_NUMBER];
        validations[0] = Task5.russianNumberValidation(numbers[0]);
        validations[1] = Task5.russianNumberValidation(numbers[1]);
        validations[2] = Task5.russianNumberValidation(numbers[2]);
        validations[3] = Task5.russianNumberValidation(numbers[3]);
        validations[4] = Task5.russianNumberValidation(numbers[4]);

        // then
        assertTrue(validations[0]);
        assertTrue(validations[1]);
        assertTrue(validations[2]);
        assertTrue(validations[3]);
        assertTrue(validations[4]);
    }

    @Test
    @DisplayName("Тестирование не подходящих номеров")
    void testWrongNumbers() {
        // given
        final int CASES_NUMBER = 5;
        String[] numbers = new String[CASES_NUMBER];
        numbers[0] = "123АВЕ777";
        numbers[1] = "А123ВГ77";
        numbers[2] = "А123ВЕ7777";
        numbers[3] = "А123АФ777";
        numbers[4] = "А12АА01";

        // when
        boolean[] validations = new boolean[CASES_NUMBER];
        validations[0] = Task5.russianNumberValidation(numbers[0]);
        validations[1] = Task5.russianNumberValidation(numbers[1]);
        validations[2] = Task5.russianNumberValidation(numbers[2]);
        validations[3] = Task5.russianNumberValidation(numbers[3]);
        validations[4] = Task5.russianNumberValidation(numbers[4]);

        // then
        assertFalse(validations[0]);
        assertFalse(validations[1]);
        assertFalse(validations[2]);
        assertFalse(validations[3]);
        assertFalse(validations[4]);
    }

    @Test
    @DisplayName("Тестирование null")
    void testNullCase() {
        // given
        String number = null;

        // when
        boolean validation = Task5.russianNumberValidation(number);

        // then
        assertFalse(validation);
    }
}
