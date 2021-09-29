package de.dhbwka.java.exercise.test;

public class PotenzMenge {

    public static void main(String[] args) {

        for (int i = 1; i < 20; i++) {
            int zahl = 2;
            System.out.println("Anzahl elemente: " + i + ", Anzahl mengen: " + (int) Math.pow(i, zahl));
        }
    }
}
