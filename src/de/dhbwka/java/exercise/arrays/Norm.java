package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

public class Norm {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte Anzahl der Elemente n eingeben: ");
        int amountOfNumbers = sc.nextInt();
        double amount = 0;

        for (int i = 0; i < amountOfNumbers; i++) {
            System.out.println("Bitte x_" + i + "eingeben: ");
            int num = sc.nextInt();
            amount += num * num;
        }

        sc.close();
        System.out.println("Der Betrag ist: " + Math.sqrt(amount));
    }
}
