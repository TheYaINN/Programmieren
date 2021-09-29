package de.dhbwka.java.exercise.classes.vehicles;

public class Bicycle extends Vehicle {

    public Bicycle(final double speed) {
        wheels = 2;
        maxSpeed = new Speed().of(30);
        this.setSpeed(speed);
    }
}
