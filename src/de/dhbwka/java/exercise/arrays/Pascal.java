package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

public class Pascal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Anzahl der Zeilen: ");
        int size = sc.nextInt();
        sc.close();
        int[][] triangle = new int[size][size];
        int num = 1;

        for (int i = 0; i < triangle.length; i++) {
            System.out.print(" ");
            for (int j = 0; j < i; j++) {
                if (j == 0 || i == 0) {
                    num = 1;
                    System.out.print(" " + num);
                } else {
                    num = num * (i - j + 1) / j;
                    System.out.print(" " + num);
                }
            }
            num = 1;
            System.out.println(" " + num + "\n");
        }
    }
}
