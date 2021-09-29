package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

public class Eratostenes {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Welche Zahl n wollen Sie benutzen?");

        int n = sc.nextInt();
        sc.close();

        findPrimeNumbers(n);

    }

    private static void findPrimeNumbers(int n) {

        boolean[] primes = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            primes[i] = true;
        }

        for (int p = 0; p * p < primes.length; p++) {
            if (primes[p]) {
                for (int i = p * p; i <= n; i += p) {
                    primes[i] = false;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (primes[i]) {
                System.out.println(i);
            }
        }
    }
}
