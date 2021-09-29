package de.dhbwka.java.exercise.classes.vehicles;

public class Racecar extends Car {

    public Racecar(final double speed) {
        super(speed);
        wheels = 4;
        this.maxSpeed.set(220);
    }
}
