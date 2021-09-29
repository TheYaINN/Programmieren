package de.dhbwka.java.exercise.classes;

import java.util.Scanner;

public class NimmSpiel {

    Scanner sc = new Scanner(System.in);

    String[] names = new String[2];
    int turn;

    int stack1;
    int stack2;

    public NimmSpiel(final String name1, final String name2) {
        names[0] = name1;
        names[1] = name2;

        stack1 = (int) Math.floor(Math.random() * 10) + 1;
        stack2 = (int) Math.floor(Math.random() * 10) + 1;

        turn = (int) Math.round(Math.random());
    }

    public void ziehen() {
        System.out.println("\n" + toString());
        System.out.println(String.format("Spieler %s: Von welchen Haufen wollen sie ziehen? 1/2", names[turn]));
        final int stack = sc.nextInt();
        System.out.println(String.format("Spieler %s: Wie viele Kugeln ziehen Sie?", names[turn]));
        final int amount = sc.nextInt();
        if (stack == 1) {
            if (amount > 0 && amount <= stack1 && stack1 - amount >= 0) {
                stack1 -= amount;
            } else {
                System.out.println("Falsche eingabe, nochmal versuchen.");
                ziehen();
            }
        } else {
            if (amount > 0 && amount <= stack2 && stack2 - amount >= 0) {
                stack2 -= amount;
            } else {
                System.out.println("Falsche eingabe, nochmal versuchen.");
                ziehen();
            }
        }
    }

    public void changeTurn() {
        if (turn == 0) {
            turn = 1;
        } else {
            turn = 0;
        }
    }

    private void play() {
        boolean gameEnd = false;
        while (!gameEnd) {
            ziehen();

            final int ballsLeft = stack1 + stack2;
            if (ballsLeft <= 0) {
                gameEnd = true;
                System.out.println(String.format("%s hat gewonnen!!!", names[turn]));
            }
            changeTurn();
        }
    }

    @Override
    public String toString() {
        return String.format("Spieler: %s und %s, Haufen 1: %s Kugel(n), Haufen 2: %s Kugel(n)", names[0], names[1], stack1, stack2);
    }

    public static void main(final String[] args) {
        final NimmSpiel ns = new NimmSpiel("Bengt", "Hans");
        ns.play();
    }
}
