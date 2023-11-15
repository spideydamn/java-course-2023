package edu.project1;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

@SuppressWarnings("RegexpSinglelineJava")
class Dictionary {
    private Dictionary() {
    }

    public static final Random RANDOM = new Random();
    private static final String[] WORDS;

    static {
        try {
            WORDS = Files.readAllLines(
                Paths.get(System.getProperty("user.dir") + "/src/main/resources/words.txt"),
                Charset.defaultCharset()
            ).toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getRandomWord() {
        int indexOfWord = RANDOM.nextInt(WORDS.length);
        return WORDS[indexOfWord];
    }
}
