package de.dhbwka.java.exercise.ciphers;

public class CaesarCipher {

    public static String encrypt(String input, int shift) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (Character.isSpaceChar(input.charAt(i))) {
                char ch = (char) ((int) input.charAt(i) + shift);
                result.append(ch);
            } else if (Character.isUpperCase(input.charAt(i))) {
                char ch = (char) (((int) input.charAt(i) + shift - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) input.charAt(i) + shift - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static String decrypt(String input, int shift) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '"') {
                char ch = (char) ((int) input.charAt(i) - shift);
                result.append(ch);
            } else if (Character.isUpperCase(input.charAt(i))) {
                char ch = (char) (((int) input.charAt(i) - shift - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = input.charAt(i);
                char ch2;
                if (ch == 'a') {
                    ch2 = (char) ((ch - shift - 97) % 26 + 97 + 26);
                } else {
                    ch2 = (char) ((ch - shift - 97) % 26 + 97);
                }

                result.append(ch2);
            }
        }
        return result.toString();
    }
}
