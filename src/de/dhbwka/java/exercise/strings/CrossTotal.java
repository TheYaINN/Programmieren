package de.dhbwka.java.exercise.strings;

import java.util.Scanner;

public class CrossTotal {

    public static void main(final String[] args) {
        int value = 0;
        final String num = new Scanner(System.in).next();
        for (int i = 0; i < num.length(); i++) {
            value += Character.getNumericValue(num.charAt(i));
        }
        System.out.println(value);
    }

}
