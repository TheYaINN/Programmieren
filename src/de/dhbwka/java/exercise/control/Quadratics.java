package de.dhbwka.java.exercise.control;

import java.util.Scanner;

public class Quadratics {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte geben Sie die erste Zahl ein: ");
        int a = sc.nextInt();
        System.out.println("Bitte geben Sie die zweite Zahl ein: ");
        int b = sc.nextInt();
        System.out.println("Bitte geben Sie die dritte Zahl ein: ");
        int c = sc.nextInt();

        sc.close();

        if (a == 0) {
            if (b == 0) {
                System.out.println("Die Gleichung ist degeneriert.");
            } else {
                System.out.println("Die Lösung ist: " + -(c / b));
            }
        } else if (a != 0) {
            double d = Math.pow(b, b) - 4 * a * c;
            if (d >= 0) {
                System.out.println("Die Lösung für x1 ist: " + (-b + Math.sqrt(d)) / (2 * a));
                System.out.println("Die Lösung für x2 ist: " + (-b - Math.sqrt(d)) / (2 * a));
            } else {
                System.out.println("Die Lösung ist konjugiert komplex.");
            }
        }
    }
}
