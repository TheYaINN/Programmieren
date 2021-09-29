package de.dhbwka.java.exercise.control;

import java.util.Scanner;

public class Babylon {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Aus welcher Zahl wollen Sie die Wurzel ziehen?");

        double num = sc.nextDouble();
        sc.close();

        double xn = num / 2;
        double diff = Double.MAX_VALUE;
        double xn1 = xn;

        while (Math.abs(diff) > 0.000001) {
            double a = num / xn;
            xn = (xn + a) / 2;
            diff = ((xn - xn1) / xn1);
            xn1 = xn;
            System.out.println(xn);
        }
    }
}
