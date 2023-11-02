package edu.hw1;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Task3 {
    private Task3() {}

    private static int arrayMin(int[] array) {
        int minElement = Integer.MAX_VALUE;
        for (int j : array) {
            minElement = min(minElement, j);
        }
        return minElement;
    }

    private static int arrayMax(int[] array) {
        int maxElement = Integer.MIN_VALUE;
        for (int j : array) {
            maxElement = max(maxElement, j);
        }
        return maxElement;
    }

    public static boolean isNestable(int[] array1, int[] array2) {
        return arrayMin(array1) > arrayMin(array2) && arrayMax(array1) < arrayMax(array2);
    }
}
