package de.dhbwka.java.exercise.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottery {

    List<Integer> zahlen;

    Lottery() {
        zahlen = new ArrayList<>();
        while (zahlen.size() < 7) {
            drawNumber();
        }
        printNumbers();
    }

    private void printNumbers() {
        sortNumbers();
        for (int i = 0; i < zahlen.size() - 1; i++) {
            System.out.println("Die " + (i + 1) + "-te Zahl lautet: " + zahlen.get(i));
        }
        System.out.println("Und die Superzahl lautet: " + zahlen.get(zahlen.size() - 1));
    }

    private void sortNumbers() {
        int superzahl = zahlen.get(zahlen.size() - 1);
        zahlen.remove(zahlen.size() - 1);
        Collections.sort(zahlen);
        zahlen.add(superzahl);
    }

    private void drawNumber() {
        int newNum = ((int) (Math.random() * 49 + 1));
        if (zahlen.stream().anyMatch(n -> n.equals(newNum))) {
            drawNumber();
        } else {
            zahlen.add(newNum);
        }
    }

    public static void main(String[] args) {
        Lottery lottery = new Lottery();
    }
}
