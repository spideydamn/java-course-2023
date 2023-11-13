package edu.hw5;

import static java.util.regex.Pattern.matches;

public class Task6 {
    private Task6() {}

    public static boolean ifSubsequenceOfSequence(String subsequence, String sequence) {
        if (sequence == null || subsequence == null) {
            return false;
        }
        StringBuilder regex = new StringBuilder(".*");
        for (int i = 0; i < subsequence.length(); ++i) {
            regex.append(subsequence.charAt(i)).append(".*");
        }
        return matches(regex.toString(), sequence);
    }
}
