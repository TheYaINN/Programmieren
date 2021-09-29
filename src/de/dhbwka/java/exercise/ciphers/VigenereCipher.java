package de.dhbwka.java.exercise.ciphers;

public class VigenereCipher {


    public static String encrypt(String input, String key) {
        char[] origin = input.toUpperCase().toCharArray();
        char[] originKey = key.toCharArray();
        for (int i = 0; i < origin.length; i++) {
            origin[i] = (char) ((origin[i] + originKey[(i % originKey.length)]) % 26 + 'A');
        }
        return new String(origin);
    }

    public static String decrypt(String input, String key) {
        char[] origin = input.toUpperCase().toCharArray();
        char[] originKey = key.toCharArray();
        for (int i = 0; i < origin.length; i++) {
            origin[i] = (char) ((origin[i] - originKey[(i % originKey.length)]) % 26 + 'A');
        }
        return new String(origin);
    }
}
