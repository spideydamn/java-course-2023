package edu.hw3;

import java.util.HashMap;

public class Task3 {
    private Task3() {}

    public static HashMap<Object, Integer> freqDict(Object[] elements) {
        if (elements == null) {
            return null;
        }

        HashMap<Object, Integer> amountOfElements = new HashMap<>();
        int len = elements.length;

        for (Object element : elements) {
            amountOfElements.merge(element, 1, Integer::sum);
        }

        return amountOfElements;
    }
}
