package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task8Test {
    @Test
    @DisplayName("Тестирование нечетной длины")
    void testTrueIfOddLength() {
        // given
        final int CASES_NUMBER = 5;
        String[] sequences = new String[CASES_NUMBER];
        sequences[0] = "110";
        sequences[1] = "11001";
        sequences[2] = "1";
        sequences[3] = "000";
        sequences[4] = "110111111";

        // when
        boolean[] validations = new boolean[CASES_NUMBER];
        validations[0] = Task8.ifOddLength(sequences[0]);
        validations[1] = Task8.ifOddLength(sequences[1]);
        validations[2] = Task8.ifOddLength(sequences[2]);
        validations[3] = Task8.ifOddLength(sequences[3]);
        validations[4] = Task8.ifOddLength(sequences[4]);

        // then
        assertTrue(validations[0]);
        assertTrue(validations[1]);
        assertTrue(validations[2]);
        assertTrue(validations[3]);
        assertTrue(validations[4]);
    }

    @Test
    @DisplayName("Тестирование нечетной длины")
    void testWrongIfOddLength() {
        // given
        final int CASES_NUMBER = 5;
        String[] sequences = new String[CASES_NUMBER];
        sequences[0] = "";
        sequences[1] = "10";
        sequences[2] = "121";
        sequences[3] = "1a1";
        sequences[4] = "1.1";

        // when
        boolean[] validations = new boolean[CASES_NUMBER];
        validations[0] = Task8.ifOddLength(sequences[0]);
        validations[1] = Task8.ifOddLength(sequences[1]);
        validations[2] = Task8.ifOddLength(sequences[2]);
        validations[3] = Task8.ifOddLength(sequences[3]);
        validations[4] = Task8.ifOddLength(sequences[4]);

        // then
        assertFalse(validations[0]);
        assertFalse(validations[1]);
        assertFalse(validations[2]);
        assertFalse(validations[3]);
        assertFalse(validations[4]);
    }

    @Test
    @DisplayName("Тестирование null нечетной длины")
    void testNullCaseIfOddLength() {
        // given
        String sequence = null;

        // when
        boolean validation = Task8.ifOddLength(sequence);

        // then
        assertFalse(validation);
    }

    @Test
    @DisplayName("Тестирование подходящих начинается с 0 и имеет нечетную длину, или начинается с 1 и имеет четную длину")
    void testTrueIfStartsAtZeroAndHasAnOddLengthOrStartsAtOneAndHasAnEvenLength() {
        // given
        final int CASES_NUMBER = 5;
        String[] sequences = new String[CASES_NUMBER];
        sequences[0] = "1010";
        sequences[1] = "01010";
        sequences[2] = "0";
        sequences[3] = "11";
        sequences[4] = "000";

        // when
        boolean[] validations = new boolean[CASES_NUMBER];
        validations[0] = Task8.ifStartsAtZeroAndHasAnOddLengthOrStartsAtOneAndHasAnEvenLength(sequences[0]);
        validations[1] = Task8.ifStartsAtZeroAndHasAnOddLengthOrStartsAtOneAndHasAnEvenLength(sequences[1]);
        validations[2] = Task8.ifStartsAtZeroAndHasAnOddLengthOrStartsAtOneAndHasAnEvenLength(sequences[2]);
        validations[3] = Task8.ifStartsAtZeroAndHasAnOddLengthOrStartsAtOneAndHasAnEvenLength(sequences[3]);
        validations[4] = Task8.ifStartsAtZeroAndHasAnOddLengthOrStartsAtOneAndHasAnEvenLength(sequences[4]);

        // then
        assertTrue(validations[0]);
        assertTrue(validations[1]);
        assertTrue(validations[2]);
        assertTrue(validations[3]);
        assertTrue(validations[4]);
    }

    @Test
    @DisplayName("Тестирование не подходящих начинается с 0 и имеет нечетную длину, или начинается с 1 и имеет четную длину")
    void testWrongIfStartsAtZeroAndHasAnOddLengthOrStartsAtOneAndHasAnEvenLength() {
        // given
        final int CASES_NUMBER = 5;
        String[] sequences = new String[CASES_NUMBER];
        sequences[0] = "01021";
        sequences[1] = "1201";
        sequences[2] = "0111";
        sequences[3] = "100";
        sequences[4] = "";

        // when
        boolean[] validations = new boolean[CASES_NUMBER];
        validations[0] = Task8.ifStartsAtZeroAndHasAnOddLengthOrStartsAtOneAndHasAnEvenLength(sequences[0]);
        validations[1] = Task8.ifStartsAtZeroAndHasAnOddLengthOrStartsAtOneAndHasAnEvenLength(sequences[1]);
        validations[2] = Task8.ifStartsAtZeroAndHasAnOddLengthOrStartsAtOneAndHasAnEvenLength(sequences[2]);
        validations[3] = Task8.ifStartsAtZeroAndHasAnOddLengthOrStartsAtOneAndHasAnEvenLength(sequences[3]);
        validations[4] = Task8.ifStartsAtZeroAndHasAnOddLengthOrStartsAtOneAndHasAnEvenLength(sequences[4]);

        // then
        assertFalse(validations[0]);
        assertFalse(validations[1]);
        assertFalse(validations[2]);
        assertFalse(validations[3]);
        assertFalse(validations[4]);
    }

    @Test
    @DisplayName("Тестирование null начинается с 0 и имеет нечетную длину, или начинается с 1 и имеет четную длину")
    void testNullIfStartsAtZeroAndHasAnOddLengthOrStartsAtOneAndHasAnEvenLength() {
        // given
        String sequence = null;

        // when
        boolean validation = Task8.ifStartsAtZeroAndHasAnOddLengthOrStartsAtOneAndHasAnEvenLength(sequence);

        // then
        assertFalse(validation);
    }

    @Test
    @DisplayName("Тестирование подходящих количество 0 кратно 3")
    void testTrueIfQuantityZeroIsAMultipleOfThree() {
        // given
        final int CASES_NUMBER = 5;
        String[] sequences = new String[CASES_NUMBER];
        sequences[0] = "";
        sequences[1] = "1011011101";
        sequences[2] = "101110101010110";
        sequences[3] = "0101101010011";
        sequences[4] = "111111011101110110111011011101101011111111";

        // when
        boolean[] validations = new boolean[CASES_NUMBER];
        validations[0] = Task8.ifQuantityZeroIsAMultipleOfThree(sequences[0]);
        validations[1] = Task8.ifQuantityZeroIsAMultipleOfThree(sequences[1]);
        validations[2] = Task8.ifQuantityZeroIsAMultipleOfThree(sequences[2]);
        validations[3] = Task8.ifQuantityZeroIsAMultipleOfThree(sequences[3]);
        validations[4] = Task8.ifQuantityZeroIsAMultipleOfThree(sequences[4]);

        // then
        assertTrue(validations[0]);
        assertTrue(validations[1]);
        assertTrue(validations[2]);
        assertTrue(validations[3]);
        assertTrue(validations[4]);
    }

    @Test
    @DisplayName("Тестирование не подходящих количество 0 кратно 3")
    void testWrongIfQuantityZeroIsAMultipleOfThree() {
        // given
        final int CASES_NUMBER = 5;
        String[] sequences = new String[CASES_NUMBER];
        sequences[0] = "1011111";
        sequences[1] = "11010111";
        sequences[2] = "1001101011";
        sequences[3] = "101010101011";
        sequences[4] = "1010100100111101";

        // when
        boolean[] validations = new boolean[CASES_NUMBER];
        validations[0] = Task8.ifQuantityZeroIsAMultipleOfThree(sequences[0]);
        validations[1] = Task8.ifQuantityZeroIsAMultipleOfThree(sequences[1]);
        validations[2] = Task8.ifQuantityZeroIsAMultipleOfThree(sequences[2]);
        validations[3] = Task8.ifQuantityZeroIsAMultipleOfThree(sequences[3]);
        validations[4] = Task8.ifQuantityZeroIsAMultipleOfThree(sequences[4]);

        // then
        assertFalse(validations[0]);
        assertFalse(validations[1]);
        assertFalse(validations[2]);
        assertFalse(validations[3]);
        assertFalse(validations[4]);
    }

    @Test
    @DisplayName("Тестирование null количество 0 кратно 3")
    void testNullCaseIfQuantityZeroIsAMultipleOfThree() {
        // given
        String sequence = null;

        // when
        boolean validation = Task8.ifQuantityZeroIsAMultipleOfThree(sequence);

        // then
        assertFalse(validation);
    }

    @Test
    @DisplayName("Тестирование подходящих любая строка, кроме 11 или 111")
    void testTrueIfAnyStringOtherThan11Or111() {
        // given
        final int CASES_NUMBER = 5;
        String[] sequences = new String[CASES_NUMBER];
        sequences[0] = "1110";
        sequences[1] = "110";
        sequences[2] = "";
        sequences[3] = "1";
        sequences[4] = "000";

        // when
        boolean[] validations = new boolean[CASES_NUMBER];
        validations[0] = Task8.ifAnyStringOtherThan11Or111(sequences[0]);
        validations[1] = Task8.ifAnyStringOtherThan11Or111(sequences[1]);
        validations[2] = Task8.ifAnyStringOtherThan11Or111(sequences[2]);
        validations[3] = Task8.ifAnyStringOtherThan11Or111(sequences[3]);
        validations[4] = Task8.ifAnyStringOtherThan11Or111(sequences[4]);

        // then
        assertTrue(validations[0]);
        assertTrue(validations[1]);
        assertTrue(validations[2]);
        assertTrue(validations[3]);
        assertTrue(validations[4]);
    }

    @Test
    @DisplayName("Тестирование не подходящих любая строка, кроме 11 или 111")
    void testWrongIfAnyStringOtherThan11Or111() {
        // given
        final int CASES_NUMBER = 5;
        String[] sequences = new String[CASES_NUMBER];
        sequences[0] = "11";
        sequences[1] = "111";
        sequences[2] = "1021";
        sequences[3] = "abc";
        sequences[4] = "1.0";

        // when
        boolean[] validations = new boolean[CASES_NUMBER];
        validations[0] = Task8.ifAnyStringOtherThan11Or111(sequences[0]);
        validations[1] = Task8.ifAnyStringOtherThan11Or111(sequences[1]);
        validations[2] = Task8.ifAnyStringOtherThan11Or111(sequences[2]);
        validations[3] = Task8.ifAnyStringOtherThan11Or111(sequences[3]);
        validations[4] = Task8.ifAnyStringOtherThan11Or111(sequences[4]);

        // then
        assertFalse(validations[0]);
        assertFalse(validations[1]);
        assertFalse(validations[2]);
        assertFalse(validations[3]);
        assertFalse(validations[4]);
    }

    @Test
    @DisplayName("Тестирование null любая строка, кроме 11 или 111")
    void testNullIfAnyStringOtherThan11Or111() {
        // given
        String sequence = null;

        // when
        boolean validation = Task8.ifAnyStringOtherThan11Or111(sequence);

        // then
        assertFalse(validation);
    }
}
