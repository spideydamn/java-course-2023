package edu.hw5;

import static java.util.regex.Pattern.matches;

public class Task5 {
    private Task5() {}

    public static boolean russianNumberValidation(String password) {
        if (password == null) {
            return false;
        }
        String regex = "^[АВЕКМНОРСТУХ][0-9]{3}[АВЕКМНОРСТУХ]{2}[0-9]{3}$";
        return matches(regex, password);
    }
}
