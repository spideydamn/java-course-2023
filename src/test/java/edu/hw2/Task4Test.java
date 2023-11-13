package edu.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test
    @DisplayName("Тестирование функции CallingInfo")
    void testCallingInfo() {
        assertEquals("edu.hw2.Task4", Task4.callingInfo().className());
        assertEquals("testCallingInfo", Task4.callingInfo().methodName());
    }
}
