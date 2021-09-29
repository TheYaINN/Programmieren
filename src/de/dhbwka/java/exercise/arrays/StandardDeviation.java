package de.dhbwka.java.exercise.arrays;

import java.util.Random;

public class StandardDeviation {

    public static void main(String[] args) {

        Random r = new Random();
        int[] randNums = new int[100];
        int sum = 0;

        for (int i = 0; i < randNums.length; i++) {
            randNums[i] = r.nextInt(10) + 1;
            sum += randNums[i];
        }

        double average = (double) sum / randNums.length;

        for (int i : randNums) {
            sum += Math.pow(i - average, 2);
        }

        double variance = Math.sqrt(1 / (randNums.length - 1.0) * sum);

        System.out.println("Mittelwert: " + average);
        System.out.println("Abweichung: " + variance);

    }
}
