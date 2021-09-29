package de.dhbwka.java.exercise.control;

import java.util.Scanner;

public class NumberGuess {

    static Scanner sc = new Scanner(System.in);
    static String name;

    public static void main(String[] args) {
        System.out.println("Wie lautet dein Name?");
        name = sc.next();
        play();

    }

    private static void play() {

        int randNum = (int) Math.floor(Math.random() * 100) + 1;
        boolean guessed = false;
        int i = 0;

        while (!guessed) {
            System.out.println(name + ", rate eine Zahl [0-100]: ");
            int guess = sc.nextInt();
            if (randNum < guess) {
                System.out.println("Versuch " + ++i + ": " + guess + " ist zu hoch.");
            } else if (randNum > guess) {
                System.out.println("Versuch " + ++i + ": " + guess + " ist zu niedrig.");
            } else if (randNum == guess) {
                System.out.println("Versuch " + ++i + ": " + guess + ": ist korrekt.");
                System.out.println("Was möchtest Du tun?");
                System.out.println("0 - Das Spiel beenden?");
                System.out.println("2 - Das Spiel fortsetzen");
                int choice = sc.nextInt();
                if (choice == 0) {
                    System.exit(0);
                } else {
                    play();
                }
                break;
            }
        }
    }
}
