package edu.hw3;

import java.util.TreeMap;

@SuppressWarnings("MagicNumber")
public class Task4 {
    private Task4() {}

    private final static TreeMap<Integer, String> MAP = new TreeMap<>();

    static {
        MAP.put(1000, "M");
        MAP.put(900, "CM");
        MAP.put(500, "D");
        MAP.put(400, "CD");
        MAP.put(100, "C");
        MAP.put(90, "XC");
        MAP.put(50, "L");
        MAP.put(40, "XL");
        MAP.put(10, "X");
        MAP.put(9, "IX");
        MAP.put(5, "V");
        MAP.put(4, "IV");
        MAP.put(1, "I");
    }

    public static String convertToRoman(int num) {
        int highestDigits;
        try {
            highestDigits =  MAP.floorKey(num);
        } catch (NullPointerException e) {
            return null;
        }

        if (num == highestDigits) {
            return MAP.get(num);
        }
        return MAP.get(highestDigits) + convertToRoman(num - highestDigits);
    }
}
