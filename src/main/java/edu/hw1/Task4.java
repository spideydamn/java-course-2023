package edu.hw1;

public class Task4 {
    private Task4() {}

    public static String fixString(String s) {
        int len = s.length();
        char[] newString = new char[len];
        for (int i = 0; i < len - 1; i += 2) {
            newString[i] = s.charAt(i + 1);
            newString[i + 1] = s.charAt(i);
        }
        if (len % 2 == 1) {
            newString[len - 1] = s.charAt(len - 1);
        }
        return String.valueOf(newString);
    }

    public static String fixString(char[] s) {
        int len = s.length;
        char[] newString = new char[len];
        for (int i = 0; i < len - 1; i += 2) {
            newString[i] = s[i + 1];
            newString[i + 1] = s[i];
        }
        if (len % 2 == 1) {
            newString[len - 1] = s[len - 1];
        }
        return String.valueOf(newString);
    }
}
