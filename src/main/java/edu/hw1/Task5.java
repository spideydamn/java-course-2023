package edu.hw1;

public class Task5 {
    private Task5() {}

    static final int REGEX = 10;

    private static int countDigits(int givenNumber) {
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

    public static boolean isPalindromeDescendant(int givenNumber) {
        int numberLen = countDigits(givenNumber);
        if (numberLen == 1) {
            return false;
        }

        int copyGivenNumber = givenNumber;
        int[] digits = new int[numberLen];
        for (int i = numberLen - 1; i >= 0; --i) {
            digits[i] = copyGivenNumber % REGEX;
            copyGivenNumber /= REGEX;
        }

        int leftSum = digits[0];
        int left = 1;
        int rightSum = digits[numberLen - 1];
        int right = numberLen - 2;
        int countPairs = 0;

        while (left <= right) {
            while (left <= right && leftSum < rightSum) {
                leftSum += digits[left];
                ++left;

            }
            while (left <= right && leftSum > rightSum) {
                rightSum += digits[right];
                --right;
            }
            if (left <= right && leftSum == rightSum) {
                leftSum = digits[left];
                rightSum = digits[right];
                ++left;
                --right;
                ++countPairs;
            }
        }
        return leftSum == rightSum || (leftSum * rightSum == 0 && countPairs > 0);
    }
}
