package edu.project1;

import java.util.Random;

@SuppressWarnings("RegexpSinglelineJava")
class Dictionary {
    private Dictionary() {}

    private static final Random RANDOM = new Random();

    private static final String[] WORDS =
        new String[] {"helicopter", "tea", "hello", "wallet", "watches", "lamp", "cube", "square", "rectangle", "table",
            "bed", "civilization", "reservation", "mother", "car", "sport", "wonderful", "basketball"};

    public static void setRandomSeed(long seed) { // for testing
        RANDOM.setSeed(seed);
    }

    public static String getRandomWord() {
        int indexOfWord = RANDOM.nextInt(WORDS.length);
        return WORDS[indexOfWord];
    }
}
