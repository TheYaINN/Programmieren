package de.dhbwka.java.exercise.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddUp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int finalNum = 0;

        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            if (num > 0) {
                list.add(num);
            } else {
                break;
            }
        }

        for (int numList : list) {
            finalNum += numList;
        }

        sc.close();
        System.out.println("Das Ergebnis aller Zahlen ist: " + finalNum);
    }
}
