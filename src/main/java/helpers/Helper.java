package helpers;

import java.util.Random;

public class Helper {

    public static String generateString() {
        Random random = new Random();
        String SOURCES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        char[] text = new char[6];
        for (int i = 0; i < 6; i++) {
            text[i] = SOURCES.charAt(random.nextInt(SOURCES.length()));
        }
        return new String(text);
    }
}
