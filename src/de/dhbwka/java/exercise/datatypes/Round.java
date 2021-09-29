package de.dhbwka.java.exercise.datatypes;

public class Round {

    public static void main(String[] args) {
        double pi = -3.1415926; // Naeherung der Kreiszahl Pi
        double e = -2.7182818; // Naeherung der Eulerschen Zahl e
        double ePos = 2.7182818; // Naeherung der Eulerschen Zahl e

        int piInt = (int) pi;
        int eInt = (int) e;

        System.out.println("Pi ganzzahlig: " + piInt); // Ausgabe: 3
        System.out.println("e ganzzahlig: " + eInt + "\n"); // Ausgabe: 2
        System.out.println("Pi ganzzahlig gerundet: " + round(pi)); // Ausgabe 3
        System.out.println("e ganzzahlig gerundet: " + round(e)); // Ausgabe 3
        System.out.println("ePos ganzzahlig gerundet: " + round(ePos)); // Ausgabe 3
    }

    private static int round(double num) {
        int finalNum = (int) num;
        if (num > 0) {
            if (num % 1 >= 0.5) {
                finalNum += 1;
            }
        } else {
            if (num % 1 <= -0.5) {
                finalNum -= 1;
            }
        }
        return finalNum;
    }
}
