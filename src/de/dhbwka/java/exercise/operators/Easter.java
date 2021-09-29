package de.dhbwka.java.exercise.operators;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Scanner;

public class Easter {

    public static void main(final String[] args) {
        int year;
        final Scanner sc = new Scanner(System.in);
        year = sc.nextInt();
        sc.close();
        System.out.println("Der Tag ist: " + calcYear(year));
    }

    private static OffsetDateTime calcYear(final int year) {
        final int a = year % 19;
        final int b = year % 4;
        final int c = year % 7;
        final int k = year / 100;
        final int p = (8 * k + 13) / 25;
        final int q = k / 4;
        final int m = (15 + k - p - q) % 30;
        final int n = (4 + k - q) % 7;
        final int d = (19 * a + m) % 30;
        final int e = (2 * b + 4 * c + 6 * d + n) % 7;
        final int daysToAdd = (22 + d + e); //(bezogen auf 1. März)
        final OffsetDateTime time = OffsetDateTime.of(year, 3, 1, 0, 0, 0, 0, ZoneOffset.ofHours(0));
        return time.plusDays(daysToAdd - 1);
    }
}
