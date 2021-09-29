package de.dhbwka.java.exercise.classes.vehicles;

public class Car extends Vehicle {

    public Car(final double speed) {
        wheels = 4;
        maxSpeed.set(140);
        this.setSpeed(speed);
    }
}
