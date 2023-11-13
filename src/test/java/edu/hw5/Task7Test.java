package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task7Test {
    @Test
    @DisplayName("Тестирование подходящих содержит не менее 3 символов, причем третий символ равен 0")
    void testTrueIfContainsAtLeastThreeCharactersWithTheThirdCharacterBeingZero() {
        // given
        final int CASES_NUMBER = 5;
        String[] sequences = new String[CASES_NUMBER];
        sequences[0] = "110";
        sequences[1] = "1101";
        sequences[2] = "0000000";
        sequences[3] = "000";
        sequences[4] = "110111111";

        // when
        boolean[] validations = new boolean[CASES_NUMBER];
        validations[0] = Task7.ifContainsAtLeastThreeCharactersWithTheThirdCharacterBeingZero(sequences[0]);
        validations[1] = Task7.ifContainsAtLeastThreeCharactersWithTheThirdCharacterBeingZero(sequences[1]);
        validations[2] = Task7.ifContainsAtLeastThreeCharactersWithTheThirdCharacterBeingZero(sequences[2]);
        validations[3] = Task7.ifContainsAtLeastThreeCharactersWithTheThirdCharacterBeingZero(sequences[3]);
        validations[4] = Task7.ifContainsAtLeastThreeCharactersWithTheThirdCharacterBeingZero(sequences[4]);

        // then
        assertTrue(validations[0]);
        assertTrue(validations[1]);
        assertTrue(validations[2]);
        assertTrue(validations[3]);
        assertTrue(validations[4]);
    }

    @Test
    @DisplayName("Тестирование не подходящих содержит не менее 3 символов, причем третий символ равен 0")
    void testWrongIfContainsAtLeastThreeCharactersWithTheThirdCharacterBeingZero() {
        // given
        final int CASES_NUMBER = 5;
        String[] sequences = new String[CASES_NUMBER];
        sequences[0] = "001";
        sequences[1] = "0";
        sequences[2] = "ab0";
        sequences[3] = "001000000";
        sequences[4] = "";

        // when
        boolean[] validations = new boolean[CASES_NUMBER];
        validations[0] = Task7.ifContainsAtLeastThreeCharactersWithTheThirdCharacterBeingZero(sequences[0]);
        validations[1] = Task7.ifContainsAtLeastThreeCharactersWithTheThirdCharacterBeingZero(sequences[1]);
        validations[2] = Task7.ifContainsAtLeastThreeCharactersWithTheThirdCharacterBeingZero(sequences[2]);
        validations[3] = Task7.ifContainsAtLeastThreeCharactersWithTheThirdCharacterBeingZero(sequences[3]);
        validations[4] = Task7.ifContainsAtLeastThreeCharactersWithTheThirdCharacterBeingZero(sequences[4]);

        // then
        assertFalse(validations[0]);
        assertFalse(validations[1]);
        assertFalse(validations[2]);
        assertFalse(validations[3]);
        assertFalse(validations[4]);
    }

    @Test
    @DisplayName("Тестирование null содержит не менее 3 символов, причем третий символ равен 0")
    void testNullCaseIfContainsAtLeastThreeCharactersWithTheThirdCharacterBeingZero() {
        // given
        String sequence = null;

        // when
        boolean validation = Task7.ifContainsAtLeastThreeCharactersWithTheThirdCharacterBeingZero(sequence);

        // then
        assertFalse(validation);
    }

    @Test
    @DisplayName("Тестирование подходящих начинается и заканчивается одним и тем же символом")
    void testTrueStartsAndEndsWithTheSameCharacter() {
        // given
        final int CASES_NUMBER = 5;
        String[] sequences = new String[CASES_NUMBER];
        sequences[0] = "11001010101011";
        sequences[1] = "0101010011010";
        sequences[2] = "0";
        sequences[3] = "1";
        sequences[4] = "00";

        // when
        boolean[] validations = new boolean[CASES_NUMBER];
        validations[0] = Task7.startsAndEndsWithTheSameCharacter(sequences[0]);
        validations[1] = Task7.startsAndEndsWithTheSameCharacter(sequences[1]);
        validations[2] = Task7.startsAndEndsWithTheSameCharacter(sequences[2]);
        validations[3] = Task7.startsAndEndsWithTheSameCharacter(sequences[3]);
        validations[4] = Task7.startsAndEndsWithTheSameCharacter(sequences[4]);

        // then
        assertTrue(validations[0]);
        assertTrue(validations[1]);
        assertTrue(validations[2]);
        assertTrue(validations[3]);
        assertTrue(validations[4]);
    }

    @Test
    @DisplayName("Тестирование не подходящих начинается и заканчивается одним и тем же символом")
    void testWrongStartsAndEndsWithTheSameCharacter() {
        // given
        final int CASES_NUMBER = 5;
        String[] sequences = new String[CASES_NUMBER];
        sequences[0] = "010101001011";
        sequences[1] = "01";
        sequences[2] = "11010010201010101";
        sequences[3] = "10";
        sequences[4] = "";

        // when
        boolean[] validations = new boolean[CASES_NUMBER];
        validations[0] = Task7.startsAndEndsWithTheSameCharacter(sequences[0]);
        validations[1] = Task7.startsAndEndsWithTheSameCharacter(sequences[1]);
        validations[2] = Task7.startsAndEndsWithTheSameCharacter(sequences[2]);
        validations[3] = Task7.startsAndEndsWithTheSameCharacter(sequences[3]);
        validations[4] = Task7.startsAndEndsWithTheSameCharacter(sequences[4]);

        // then
        assertFalse(validations[0]);
        assertFalse(validations[1]);
        assertFalse(validations[2]);
        assertFalse(validations[3]);
        assertFalse(validations[4]);
    }

    @Test
    @DisplayName("Тестирование null начинается и заканчивается одним и тем же символом")
    void testNullCaseStartsAndEndsWithTheSameCharacter() {
        // given
        String sequence = null;

        // when
        boolean validation = Task7.startsAndEndsWithTheSameCharacter(sequence);

        // then
        assertFalse(validation);
    }

    @Test
    @DisplayName("Тестирование подходящих длина не менее 1 и не более 3")
    void testTrueLengthNoLessThanOneAndNoMoreThanThree() {
        // given
        final int CASES_NUMBER = 5;
        String[] sequences = new String[CASES_NUMBER];
        sequences[0] = "1";
        sequences[1] = "10";
        sequences[2] = "101";
        sequences[3] = "0";
        sequences[4] = "01";

        // when
        boolean[] validations = new boolean[CASES_NUMBER];
        validations[0] = Task7.lengthNoLessThanOneAndNoMoreThanThree(sequences[0]);
        validations[1] = Task7.lengthNoLessThanOneAndNoMoreThanThree(sequences[1]);
        validations[2] = Task7.lengthNoLessThanOneAndNoMoreThanThree(sequences[2]);
        validations[3] = Task7.lengthNoLessThanOneAndNoMoreThanThree(sequences[3]);
        validations[4] = Task7.lengthNoLessThanOneAndNoMoreThanThree(sequences[4]);

        // then
        assertTrue(validations[0]);
        assertTrue(validations[1]);
        assertTrue(validations[2]);
        assertTrue(validations[3]);
        assertTrue(validations[4]);
    }

    @Test
    @DisplayName("Тестирование не подходящих длина не менее 1 и не более 3")
    void testWrongLengthNoLessThanOneAndNoMoreThanThree() {
        // given
        final int CASES_NUMBER = 5;
        String[] sequences = new String[CASES_NUMBER];
        sequences[0] = "";
        sequences[1] = "1010";
        sequences[2] = "abc";
        sequences[3] = "222";
        sequences[4] = "1.0";

        // when
        boolean[] validations = new boolean[CASES_NUMBER];
        validations[0] = Task7.lengthNoLessThanOneAndNoMoreThanThree(sequences[0]);
        validations[1] = Task7.lengthNoLessThanOneAndNoMoreThanThree(sequences[1]);
        validations[2] = Task7.lengthNoLessThanOneAndNoMoreThanThree(sequences[2]);
        validations[3] = Task7.lengthNoLessThanOneAndNoMoreThanThree(sequences[3]);
        validations[4] = Task7.lengthNoLessThanOneAndNoMoreThanThree(sequences[4]);

        // then
        assertFalse(validations[0]);
        assertFalse(validations[1]);
        assertFalse(validations[2]);
        assertFalse(validations[3]);
        assertFalse(validations[4]);
    }

    @Test
    @DisplayName("Тестирование null длина не менее 1 и не более 3")
    void testNullCaseLengthNoLessThanOneAndNoMoreThanThree() {
        // given
        String sequence = null;

        // when
        boolean validation = Task7.lengthNoLessThanOneAndNoMoreThanThree(sequence);

        // then
        assertFalse(validation);
    }
}
