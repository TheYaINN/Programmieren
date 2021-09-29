package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

public class DotProduct {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte Anzahl der Elemente n eingeben: ");

        int amountOfNumbers = sc.nextInt();
        double scalarProdukt = 0;

        for (int i = 0; i < amountOfNumbers; i++) {
            System.out.println("Bitte x_" + i + " eingeben: ");
            int xVariable = sc.nextInt();
            System.out.println("Bitte y_" + i + " eingeben: ");
            int yVariable = sc.nextInt();
            scalarProdukt += xVariable * yVariable;
        }

        sc.close();
        System.out.println("Das Skalarprodukt von x und y ist: " + scalarProdukt);
    }

}
