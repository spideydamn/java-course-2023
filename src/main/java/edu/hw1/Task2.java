package edu.hw1;

public class Task2 {
    private Task2() {}

    static final int REGEX = 10;

    public static int countDigits(int givenNumber) {
        if (givenNumber == 0) {
            return 1;
        }

        int countDigits = 0;
        int copyGivenNumber = givenNumber;
        while (copyGivenNumber != 0) {
            copyGivenNumber /= REGEX;
            countDigits += 1;
        }

        return countDigits;
    }
}
