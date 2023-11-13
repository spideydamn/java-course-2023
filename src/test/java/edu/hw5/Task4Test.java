package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task4Test {
    @Test
    @DisplayName("Тестирование подходящих паролей")
    void testTruePasswords() {
        // given
        final int CASES_NUMBER = 5;
        String[] passwords = new String[CASES_NUMBER];
        passwords[0] = "~!@#$%^&*|";
        passwords[1] = "gewtrwg23742396fhweirhge~!@#$%^&*|qerigpquherugq425728936572hfqerqierhfg";
        passwords[2] = "gewtrwg23742396fhweirhge%qerigpquherugq425728936572hfqerqierhfg";
        passwords[3] = "gewtrwg23742396fhweirhge~";
        passwords[4] = "|qerigpquherugq425728936572hfqerqierhfg";

        // when
        boolean[] validations = new boolean[CASES_NUMBER];
        validations[0] = Task4.passwordValidation(passwords[0]);
        validations[1] = Task4.passwordValidation(passwords[1]);
        validations[2] = Task4.passwordValidation(passwords[2]);
        validations[3] = Task4.passwordValidation(passwords[3]);
        validations[4] = Task4.passwordValidation(passwords[4]);

        // then
        assertTrue(validations[0]);
        assertTrue(validations[1]);
        assertTrue(validations[2]);
        assertTrue(validations[3]);
        assertTrue(validations[4]);
    }

    @Test
    @DisplayName("Тестирование не подходящих паролей")
    void testWrongPasswords() {
        // given
        final int CASES_NUMBER = 5;
        String[] passwords = new String[CASES_NUMBER];
        passwords[0] = "erfgqer23414562754укепцукпцук";
        passwords[1] = "rewg.wergqerg.regqergq";
        passwords[2] = "нагоршкесиделкороль";
        passwords[3] = "+79082281337";
        passwords[4] = "88005553535";

        // when
        boolean[] validations = new boolean[CASES_NUMBER];
        validations[0] = Task4.passwordValidation(passwords[0]);
        validations[1] = Task4.passwordValidation(passwords[1]);
        validations[2] = Task4.passwordValidation(passwords[2]);
        validations[3] = Task4.passwordValidation(passwords[3]);
        validations[4] = Task4.passwordValidation(passwords[4]);

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
        String password = null;

        // when
        boolean validation = Task4.passwordValidation(password);

        // then
        assertFalse(validation);
    }
}
