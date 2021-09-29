package de.dhbwka.java.exercise.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MasterMind {

    String guess;
    char[] answer = new char[5];
    List<String> prevGuess = new ArrayList<>();
    int amountOfGuesses;
    int rnrp;
    int rnwp;

    final Scanner sc = new Scanner(System.in);

    public MasterMind(final int amountOfGuesses) {
        this.amountOfGuesses = amountOfGuesses;
        generateAnswer();
    }

    private void generateAnswer() {
        for (int i = 0; i < answer.length; i++) {
            answer[i] = (char) Math.floor(Math.random() * 5 + 65);
        }
    }

    public void guessCode() {
        boolean isGuessed = false;
        while (!isGuessed) {
            input();
            if (checkStrings()) {
                isGuessed = true;
                System.out.println(toString());
                System.out.println("Sie haben richtig geraten in " + prevGuess.size() + " Zügen.");
            } else {
                System.out.println(toString());
            }
        }
        sc.close();
    }

    private void input() {
        boolean isCorrectInput = false;
        while (!isCorrectInput) {
            System.out.println("\nGeben Sie ihren 5 Buchstaben-Tipp ab: ");
            guess = sc.next().toUpperCase();
            if (guess.length() == 5 && guess.matches("^[A-Z]+$")) {
                isCorrectInput = true;
            } else {
                System.out.println("Keine Gültige eingabe.");
            }
        }
    }

    private boolean checkStrings() {
        rnrp = 0;
        rnwp = 0;
        boolean isCorrectAnswer = false;
        for (int i = 0; i < answer.length; i++) {
            if (guess.charAt(i) == answer[i]) {
                rnrp++;
            }
        }
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < guess.length(); j++) {
                if (answer[i] == guess.charAt(j)) {
                    rnwp++;
                }
            }
        }
        if (guess.equals(new String(answer))) {
            isCorrectAnswer = true;
        }
        prevGuess.add(String.format("%s : %s : %s", guess, rnrp, rnwp));
        return isCorrectAnswer;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (final String str : prevGuess) {
            sb.append(str + "\n");
        }
        return sb.toString();
    }

    public static void main(final String[] args) {

        final MasterMind mm = new MasterMind(20);
        mm.guessCode();
    }
}
