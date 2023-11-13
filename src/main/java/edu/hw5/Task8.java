package edu.hw5;

import static java.util.regex.Pattern.matches;

public class Task8 {
    private Task8() {}

    public static boolean ifOddLength(String sequence) {
        if (sequence == null) {
            return false;
        }
        String regex = "^.((0|1)(0|1))*$";
        return matches(regex, sequence);
    }

    public static boolean ifStartsAtZeroAndHasAnOddLengthOrStartsAtOneAndHasAnEvenLength(String sequence) {
        if (sequence == null) {
            return false;
        }
        String regex = "(^1(0|1)((0|1)(0|1))*$)|(^0((0|1)(0|1))*$)";
        return matches(regex, sequence);
    }

    public static boolean ifQuantityZeroIsAMultipleOfThree(String sequence) {
        if (sequence == null) {
            return false;
        }
        String regex = "^(1*01*01*01*)*$";
        return matches(regex, sequence);
    }

    public static boolean ifAnyStringOtherThan11Or111(String sequence) {
        if (sequence == null) {
            return false;
        }
        String regex = "^(?:(?!((^111$)|(^11$)))(0|1))*$";
        return matches(regex, sequence);
    }
}
