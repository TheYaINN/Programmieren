package de.dhbwka.java.exercise.enums;

import java.util.Arrays;

public enum Months {

    JANUARY(31, "Hartung", "Eismond"),
    FEBRUARY(28, "Hornung", "Schmelzmond", "Taumond", "Narrenmond", "Rebmond", "Hintester"),
    MÄRZ(31, "Lenzing", "Lenzmond"),
    APRIL(30, "Launing", "Ostermond"),
    MAI(31, "Winnemond", "Blumenmond"),
    JUNI(30, "Brachet", "Brachmond"),
    JULI(31, "Heuert", "Heumond"),
    AUGUST(31, "Ernting", "Erntemond", "Bisemond"),
    SEPTEMBER(30, "Scheiding", "Herbstmond"),
    OKTOBER(31, " Gilbhart", "Gilbhard", "Weinmond"),
    NOVEMBER(30, "Nebelung", "Windmond", "Wintermond"),
    DEZEMBER(31, "Julmond", "Heilmond", "Christmond", "Dustermond");

    private int days;
    private String[] oldnames;

    Months(int days, String... oldGermanNames) {
        this.days = days;
        oldnames = new String[oldGermanNames.length];
        int i = 0;
        for (String name : oldGermanNames) {
            oldnames[i] = name;
            i++;
        }
    }

    public static void main(String[] args) {
        Months m = Months.JUNI;
        System.out.printf("Der Monat %s hat %s Tage und hieß früher '%s'", m.name(), m.days, Arrays.toString(m.oldnames));
    }

}
