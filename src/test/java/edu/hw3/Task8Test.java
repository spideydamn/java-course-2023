package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.SortedSet;
import java.util.Stack;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task8Test {
    @Test
    @DisplayName("Тестирование итератора")
    void testIterator() {
        // given
        List<Integer> listInt = List.of(1, 2, 3);

        PriorityQueue<String> queueStr = new PriorityQueue<>();
        queueStr.add("a");
        queueStr.add("bc");
        queueStr.add("def");

        Stack<Double> stackDouble = new Stack<>();
        stackDouble.add(2.28);
        stackDouble.add(1.31);
        stackDouble.add(35.35);


        // when
        Iterator<Integer> iter = new Task8.BackwardIterator<>(listInt);
        Iterator<String> iter2 = new Task8.BackwardIterator<>(queueStr);
        Iterator<Double> iter3 = new Task8.BackwardIterator<>(stackDouble);

        // then
        assertTrue(iter.hasNext());
        assertEquals(3, iter.next());

        assertTrue(iter.hasNext());
        assertEquals(2, iter.next());

        assertTrue(iter.hasNext());
        assertEquals(1, iter.next());

        assertFalse(iter.hasNext());

        try {
            iter.next();
        } catch (Exception E) {
            assertEquals(new NoSuchElementException().toString(), E.toString());
        }


        assertTrue(iter2.hasNext());
        assertEquals("def", iter2.next());

        assertTrue(iter2.hasNext());
        assertEquals("bc", iter2.next());

        assertTrue(iter2.hasNext());
        assertEquals("a", iter2.next());

        assertFalse(iter2.hasNext());

        try {
            iter2.next();
        } catch (Exception E) {
            assertEquals(new NoSuchElementException().toString(), E.toString());
        }


        assertTrue(iter3.hasNext());
        assertEquals(35.35, iter3.next());

        assertTrue(iter3.hasNext());
        assertEquals(1.31, iter3.next());

        assertTrue(iter3.hasNext());
        assertEquals(2.28, iter3.next());

        assertFalse(iter3.hasNext());

        try {
            iter3.next();
        } catch (Exception E) {
            assertEquals(new NoSuchElementException().toString(), E.toString());
        }
    }
}
