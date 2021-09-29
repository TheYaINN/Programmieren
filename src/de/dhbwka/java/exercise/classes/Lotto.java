package de.dhbwka.java.exercise.classes;

import java.util.Scanner;

public class Lotto {

    int m;
    int n;
    int tn = 0;

    int[] tipp;
    int[] drawn;
    int amountOfRightNumbers = 0;

    public Lotto(final int m, final int n) {
        this.m = m;
        this.n = n;

        tipp = new int[m];
        drawn = new int[m];
    }

    public void tippen() {
        final Scanner sc = new Scanner(System.in);

        boolean arrayFull = false;
        int input = 0;

        while (!arrayFull) {

            System.out.println("Bitte geben Sie ihren Tipp nr. " + (tn + 1) + " an: ");
            input = sc.nextInt();

            if (input > 0 && input < n && checkArray(input)) {
                tipp[tn] = input;
                tn++;
            }

            if (tn == m) {
                arrayFull = true;
            }
        }
        sc.close();
    }

    private boolean checkArray(final int input) {
        boolean isValid = true;
        for (int i = 0; i < tipp.length; i++) {
            if (tipp[i] == input) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    public void tippen(final int[] tippInp) {
        for (int i = 0; i < tippInp.length; i++) {
            tipp[i] = tippInp[i];
        }
    }

    public void ziehen() {
        for (int j = 0; j < drawn.length; j++) {
            drawn[j] = (int) Math.floor(Math.random() * n) + 1;
        }
    }

    public void richtige() {
        for (int i = 0; i < drawn.length; i++) {
            for (int j = 0; j < tipp.length; j++) {
                if (drawn[i] == tipp[j]) {
                    amountOfRightNumbers++;
                }
            }
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Getippte Zahlen: ");
        for (final int i : tipp) {
            sb.append(i + ", ");
        }
        sb.append("\nGezogene Zahlen: ");
        for (final int i : drawn) {
            sb.append(i + ", ");
        }
        sb.append("\nSie haben " + amountOfRightNumbers + " richtig getippt.");
        return sb.toString();
    }

    public static void main(final String[] args) {
        final Lotto deutschesLotto = new Lotto(6, 49);
        deutschesLotto.tippen();
        deutschesLotto.ziehen();
        deutschesLotto.richtige();
        System.out.println(deutschesLotto.toString());

    }

}
