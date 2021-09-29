package de.dhbwka.java.exercise.arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MatrixSubtraction {

    public static void main(final String[] args) {

        final Scanner sc = new Scanner(System.in);
        System.out.println("Bitte Anzahl der Zeilen n eingeben: ");
        final int n = sc.nextInt();
        System.out.println("Bitte Anzahl der Spalten m eingeben: ");
        final int m = sc.nextInt();
        sc.close();

        final int[][] xNumbers = new int[n][m];
        final int[][] yNumbers = new int[n][m];
        final int[][] finalNumbers = new int[n][m];

        final Random r = new Random();

        for (int i = 0; i < xNumbers.length; i++) {
            for (int j = 0; j < xNumbers.length; j++) {
                xNumbers[i][j] = r.nextInt(101);
                yNumbers[i][j] = r.nextInt(101);
                finalNumbers[i][j] = xNumbers[i][j] - yNumbers[i][j];
            }
        }

        System.out.println(Arrays.deepToString(xNumbers));
        System.out.println(Arrays.deepToString(yNumbers));
        System.out.println(Arrays.deepToString(finalNumbers));
    }
}
