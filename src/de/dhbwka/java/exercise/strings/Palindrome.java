package de.dhbwka.java.exercise.strings;

import java.util.Scanner;

public class Palindrome {

    public static void main(final String[] args) {
        final String word = new Scanner(System.in).nextLine();
        final String word2 = new StringBuilder(word).reverse().toString();
        System.out.println("Dein Wort: " + word + "\nDein Wort umgekehrt: " + word2);
        System.out.println(word.equalsIgnoreCase(word2) ? "Palindrom!" : "Kein Palindrom!");
    }
}
