package edu.hw3;

import static java.lang.Character.isUpperCase;

public class Task1 {
    private Task1() {}

    public static String atBash(String s) {
        if (s == null) {
            return null;
        }
        char[] newString = new char[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            if (isUpperCase(s.charAt(i))) {
                newString[i] = (char) ('Z' - (s.charAt(i) - 'A'));
            } else {
                newString[i] = (char) ('z' - (s.charAt(i) - 'a'));
            }
        }
        return new String(newString);
    }
}
