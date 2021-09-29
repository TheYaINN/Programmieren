package de.dhbwka.java.exercise.arrays;

public class Fibonacci {

    public static void main(String... args) {
        generateFibonacci();
    }

    private static void generateFibonacci() {
        int count = 50;
        double[] fibNum = new double[count];
        double fn1 = 1;
        double fn2 = 1;
        double fn3 = 0;

        while (count > 0) {
            fn1 = fn2;
            fn2 = fn3;
            fn3 = fn1 + fn2;
            fibNum[fibNum.length - count] = fn3;
            count--;
        }

        //Print all numbers
        for (double num : fibNum) {
            System.out.println(num);
        }
    }
}
