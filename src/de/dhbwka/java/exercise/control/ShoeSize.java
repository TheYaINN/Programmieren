package de.dhbwka.java.exercise.control;

public class ShoeSize {

    public static void main(String[] args) {

        for (int i = 30; i < 50; i++) {
            double shoeSize = i / 1.5;
            double shoeSize1 = shoeSize - (1 / 1.5);
            System.out.println(shoeSize1 + " - " + shoeSize + " | " + i);
        }
    }
}
