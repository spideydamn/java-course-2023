package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task6Test {
    @Test
    @DisplayName("Тестирование подходящих подпоследовательностей последовательностей")
    void testTrueSubsequences() {
        // given
        final int CASES_NUMBER = 5;
        String[] seqences = new String[CASES_NUMBER];
        seqences[0] = "225462abcde4562562";
        seqences[1] = "22a546b2456c25d6e2";
        seqences[2] = "abcde2254624562562";
        seqences[3] = "2254624562562abcde";
        seqences[4] = "2254624a562562";

        String[] subseqences = new String[CASES_NUMBER];
        subseqences[0] = "abcde";
        subseqences[1] = "abcde";
        subseqences[2] = "abcde";
        subseqences[3] = "abcde";
        subseqences[4] = "a";

        // when
        boolean[] validations = new boolean[CASES_NUMBER];
        validations[0] = Task6.ifSubsequenceOfSequence(subseqences[0], seqences[0]);
        validations[1] = Task6.ifSubsequenceOfSequence(subseqences[1], seqences[1]);
        validations[2] = Task6.ifSubsequenceOfSequence(subseqences[2], seqences[2]);
        validations[3] = Task6.ifSubsequenceOfSequence(subseqences[3], seqences[3]);
        validations[4] = Task6.ifSubsequenceOfSequence(subseqences[4], seqences[4]);

        // then
        assertTrue(validations[0]);
        assertTrue(validations[1]);
        assertTrue(validations[2]);
        assertTrue(validations[3]);
        assertTrue(validations[4]);
    }

    @Test
    @DisplayName("Тестирование не подходящих номеров")
    void testWrongSubsequences() {
        // given
        final int CASES_NUMBER = 5;
        String[] seqences = new String[CASES_NUMBER];
        seqences[0] = "1345134abcd51345134";
        seqences[1] = "abcd134513451345134";
        seqences[2] = "134513451345134bcde";
        seqences[3] = "1345134aa51345134";
        seqences[4] = "13a4513451a34513a4";

        String[] subseqences = new String[CASES_NUMBER];
        subseqences[0] = "abcde";
        subseqences[1] = "abcde";
        subseqences[2] = "abcde";
        subseqences[3] = "aaa";
        subseqences[4] = "aaaa";

        // when
        boolean[] validations = new boolean[CASES_NUMBER];
        validations[0] = Task6.ifSubsequenceOfSequence(subseqences[0], seqences[0]);
        validations[1] = Task6.ifSubsequenceOfSequence(subseqences[1], seqences[1]);
        validations[2] = Task6.ifSubsequenceOfSequence(subseqences[2], seqences[2]);
        validations[3] = Task6.ifSubsequenceOfSequence(subseqences[3], seqences[3]);
        validations[4] = Task6.ifSubsequenceOfSequence(subseqences[4], seqences[4]);

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


        // when
        boolean validation1 = Task6.ifSubsequenceOfSequence("abc", null);
        boolean validation2 = Task6.ifSubsequenceOfSequence(null, "abc");

        // then
        assertFalse(validation1);
        assertFalse(validation2);
    }
}
