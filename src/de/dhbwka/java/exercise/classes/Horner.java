package de.dhbwka.java.exercise.classes;

import java.util.Scanner;

public class Horner {

    static Scanner sc = new Scanner(System.in);

    public static double hornerCalc(final double[] p, final double x) {
        double y = 0;
        for (int i = p.length - 1; i >= 0; i--) {
            y = p[i] + y * x;
        }
        return y;
    }

    public static double[] input() {
        int x;
        System.out.println("Bitte geben Sie den Grad des Polynoms an:");
        do {
            x = sc.nextInt();
        } while (x < 1);

        final double[] p = new double[x + 1];

        for (int i = 0; i < p.length; i++) {
            System.out.println("Bitte geben Sie den Koeffizient " + i + " an:");
            p[i] = sc.nextDouble();
        }
        return p;
    }

    private static void getValue(final double[] p, final double x, final double y) {
        toString(p);
        System.out.println("P( " + x + ") = " + y);
    }

    public static void toString(final double[] p) {
        System.out.print("P(x) =");
        for (int i = p.length; i > 0; i--) {
            if (i != p.length - 1) {
                System.out.print(" +");
            }
            System.out.print(" " + p[i - 1] + "x^" + i);
        }
        System.out.println();
    }

    public static void main(final String[] args) {

        final double[] p1 = input();

        System.out.println("Bitte geben Sie einen x-Wert ein: ");
        final double x = sc.nextDouble();

        getValue(p1, x, hornerCalc(p1, x));
    }

}
