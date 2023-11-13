package edu.hw5;

import static java.util.regex.Pattern.matches;

public class Task7 {
    private Task7() {}

    public static boolean ifContainsAtLeastThreeCharactersWithTheThirdCharacterBeingZero(String sequence) {
        if (sequence == null) {
            return false;
        }
        String regex = "^[0|1][0|1]0[1|0]*$";
        return matches(regex, sequence);
    }

    public static boolean startsAndEndsWithTheSameCharacter(String sequence) {
        if (sequence == null) {
            return false;
        }
        String regex = "^(0(0|1)*0)$|^(1(0|1)*1)$|^(0|1)$";
        return matches(regex, sequence);
    }

    public static boolean lengthNoLessThanOneAndNoMoreThanThree(String sequence) {
        if (sequence == null) {
            return false;
        }
        String regex = "^(0|1){1,3}$";
        return matches(regex, sequence);
    }
}
