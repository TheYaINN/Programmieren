package de.dhbwka.java.exercise.control;

public class TemperatureTable {

    public static void main(String[] args) {
        System.out.println("Fahrenheit    |   Celsius");
        System.out.println("-------------------------");
        for (int i = 0; i <= 300; i += 20) {
            double c = (5.0 / 9.0) * (i - 32.0);
            System.out.println(String.format("%d  |  %.2f", i, c));
        }
    }
}
