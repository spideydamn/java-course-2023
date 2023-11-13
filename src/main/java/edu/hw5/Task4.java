package edu.hw5;

import static java.util.regex.Pattern.matches;

public class Task4 {
    private Task4() {}

    public static boolean passwordValidation(String password) {
        if (password == null) {
            return false;
        }
        String regex = ".*[~!@#$%^&*|].*";
        return matches(regex, password);
    }
}
