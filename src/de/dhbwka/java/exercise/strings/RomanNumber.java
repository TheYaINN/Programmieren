package de.dhbwka.java.exercise.strings;

import java.util.Scanner;

public class RomanNumber {

    public static void main(final String[] args) {
        final String roman = new Scanner(System.in).nextLine().toUpperCase();
        final int value = roman //
                .replace("CM", "DCD") //
                .replace("M", "DD") //
                .replace("CD", "CCCC") //
                .replace("D", "CCCCC") //
                .replace("XC", "LXL") //
                .replace("C", "LL") //
                .replace("XL", "XXXX") //
                .replace("L", "XXXXX") //
                .replace("IX", "VIV") //
                .replace("X", "VV") //
                .replace("IV", "IIII") //
                .replace("V", "IIIII").length();
        System.out.println("Der Wert ist: " + value);
    }
}
