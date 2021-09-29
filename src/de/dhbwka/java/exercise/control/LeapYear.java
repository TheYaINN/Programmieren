package de.dhbwka.java.exercise.control;

import java.util.Scanner;

public class LeapYear {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Welches Jahr wollen sie überprüfen?");
        int year = sc.nextInt();

        if (checkForLeapYear(year)) {
            System.out.println(year + ", ist ein Schaltjahr.");
        } else {
            System.out.println(year + ", ist kein Schaltjahr");
        }
        sc.close();
    }

    private static boolean checkForLeapYear(int year) {
        boolean isLeapYear = false;
        if (year % 4 == 0 || year % 400 == 0 && year % 100 != 0) {
            isLeapYear = true;
        }
        return isLeapYear;
    }

}
