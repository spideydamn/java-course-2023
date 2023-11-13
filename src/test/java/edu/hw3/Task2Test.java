package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Task2Test {
    @Test
    @DisplayName("Проверка общих случаев")
    void checkGeneralCases() {
        // given
        String brackets1 = "()()()";
        String brackets2 = "((()))";
        String brackets3 = "((()))(())()()(()())";
        String brackets4 = "((())())(()(()()))";

        //when
        String[] clusteredBrackets1 = Task2.clusterize(brackets1);
        String[] clusteredBrackets2 = Task2.clusterize(brackets2);
        String[] clusteredBrackets3 = Task2.clusterize(brackets3);
        String[] clusteredBrackets4 = Task2.clusterize(brackets4);

        // then
        assertEquals("[(), (), ()]", Arrays.toString(clusteredBrackets1));
        assertEquals("[((()))]", Arrays.toString(clusteredBrackets2));
        assertEquals("[((())), (()), (), (), (()())]", Arrays.toString(clusteredBrackets3));
        assertEquals("[((())()), (()(()()))]", Arrays.toString(clusteredBrackets4));
    }

    @Test
    @DisplayName("Проверка null")
    void checkNullCase() {
        // given
        String brackets = null;

        //when
        String[] clusteredBrackets = Task2.clusterize(brackets);

        // then
        assertNull(clusteredBrackets);
    }

    @Test
    @DisplayName("Проверка неверных наборов")
    void checkWrongCase() {
        // given
        String brackets1 = "()()(";
        String brackets2 = "(()))";
        String brackets3 = "((()))(())()()(()(";
        String brackets4 = "((()(((((())(()(()()))";

        //when
        String[] clusteredBrackets1 = Task2.clusterize(brackets1);
        String[] clusteredBrackets2 = Task2.clusterize(brackets2);
        String[] clusteredBrackets3 = Task2.clusterize(brackets3);
        String[] clusteredBrackets4 = Task2.clusterize(brackets4);

        // then
        assertEquals(null, clusteredBrackets1);
        assertEquals(null, clusteredBrackets2);
        assertEquals(null, clusteredBrackets3);
        assertEquals(null, clusteredBrackets4);
    }
}
