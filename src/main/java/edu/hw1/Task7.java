package edu.hw1;

public class Task7 {
    private Task7() {}

    static final int RADIX = 2;

    private static int[] toBinArr(int givenNumber) {
        int lenArr = 0;
        int copyGivenNumber = givenNumber;
        while (copyGivenNumber != 0) {
            copyGivenNumber /= RADIX;
            lenArr++;
        }

        if (lenArr == 0) {
            return new int[]{0};
        }

        int[] binArr = new int[lenArr];
        int itBinArr = lenArr - 1;

        copyGivenNumber = givenNumber;
        while (copyGivenNumber != 0) {
            binArr[itBinArr] = copyGivenNumber % RADIX;
            copyGivenNumber /= RADIX;
            --itBinArr;
        }

        return binArr;
    }

    private static int toDecInt(int[] binArr) {
        int res = 0;

        int multiplier = 1;
        for (int i = binArr.length - 1; i >= 0; --i) {
            res += binArr[i] * multiplier;
            multiplier *= RADIX;
        }

        return res;
    }

    private static void cyclicArrShift(int[] arr, int givenShift) {
        int len = arr.length;
        int swap;

        int shift = givenShift % len;
        if (shift < 0) {
            shift = len + shift;
        }

        for (int i = len - shift; i < len; i++) {
            for (int j = i - 1; j >= i - len + shift; j--) {
                swap = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = swap;
            }
        }
    }

    public static int rotateLeft(int n, int shift) {
        int[] binArr = toBinArr(n);
        cyclicArrShift(binArr, -shift);
        return toDecInt(binArr);
    }

    public static int rotateRight(int n, int shift) {
        int[] binArr = toBinArr(n);
        cyclicArrShift(binArr, +shift);
        return toDecInt(binArr);
    }
}
