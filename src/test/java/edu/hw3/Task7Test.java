package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task7Test {
    @Test
    @DisplayName("Проверка работы компартатора")
    void comparatorTest() {
        TreeMap<String, String> tree = new TreeMap<>(new Task7.NullComparator<>());

        tree.put(null, "test1");
        assertTrue(tree.containsKey(null));
        assertEquals("test1", tree.get(null));

        tree.remove(null);
        assertFalse(tree.containsKey(null));

        tree.put(null, "test2");
        assertTrue(tree.containsKey(null));
        assertEquals("test2", tree.get(null));

        tree.put(null, "test3");
        assertTrue(tree.containsKey(null));
        assertEquals("test3", tree.get(null));
    }

    @Test
    @DisplayName("Проверка работы компартатора значений кроме null")
    void comparatorTestNotNull() {
        TreeMap<String, String> tree = new TreeMap<>(new Task7.NullComparator<>());

        tree.put("First name", "Goshan");
        assertTrue(tree.containsKey("First name"));
        assertEquals("Goshan", tree.get("First name"));

        tree.put(null, "addNull");
        assertTrue(tree.containsKey(null));
        assertEquals("addNull", tree.get(null));

        tree.put("Last name", "Goshkin");
        assertTrue(tree.containsKey("Last name"));
        assertEquals("Goshkin", tree.get("Last name"));

        assertEquals("First name", tree.ceilingKey("First Name"));
    }

}
