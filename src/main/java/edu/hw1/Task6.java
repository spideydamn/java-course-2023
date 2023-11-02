package edu.hw1;

import static java.util.Arrays.sort;

public class Task6 {
    private Task6() {}

    static final int KAPREKARS_CONST = 6174;
    static final int NUMBER_LEN = 4;
    static final int RADIX = 10;
    static final int LOWER_LIMIT_OF_THOUSANDS = 1000;
    static final int UPPER_LIMIT_OF_THOUSANDS = 10000;

    private static int[] toArr(int givenNumber) {
        int copyGivenNumber = givenNumber;
        int[] res = new int[NUMBER_LEN];
        for (int i = 0; i < NUMBER_LEN; ++i) {
            res[i] = copyGivenNumber % RADIX;
            copyGivenNumber /= RADIX;
        }
        return res;
    }

    private static int recursion(int number, int count) {

        if (number == KAPREKARS_CONST) {
            return count;
        }

        int[] digitsIncNum = toArr(number);
        int incNum = 0;
        int decNum = 0;

        sort(digitsIncNum);

        int rank = 1;
        for (int i = 0; i < NUMBER_LEN; ++i) {
            incNum += digitsIncNum[NUMBER_LEN - (i + 1)] * rank;
            decNum += digitsIncNum[i] * rank;
            rank *= RADIX;
        }

        return recursion(decNum - incNum, count + 1);
    }

    public static int countK(int number) {
        if (number <= LOWER_LIMIT_OF_THOUSANDS || number >= UPPER_LIMIT_OF_THOUSANDS) {
            return -1;
        }

        boolean isSameNumbers = true;
        int[] digits = toArr(number);
        for (int i = 0; i < NUMBER_LEN - 1; i++) {
            if (digits[i] != digits[i + 1]) {
                isSameNumbers = false;
                break;
            }
        }
        if (isSameNumbers) {
            return -1;
        }

        return recursion(number, 0);
    }
}
