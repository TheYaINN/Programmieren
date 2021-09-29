package de.dhbwka.java.exercise.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {

    public static void main(final String[] args) {

        final Scanner sc = new Scanner(System.in);
        System.out.print("Bitte Anzahl der Elemente n eingeben: ");
        final int amountOfNumbers = sc.nextInt();
        final int[] numbers = new int[amountOfNumbers];

        for (int i = 0; i < amountOfNumbers; i++) {
            System.out.print("Zahl " + (i + 1) + " eingeben: ");
            numbers[i] = sc.nextInt();
        }
        sc.close();

        bubbleSort(numbers);
        printArray(numbers);
    }

    static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }


    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    final int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

}
