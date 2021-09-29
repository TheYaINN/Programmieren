package de.dhbwka.java.exercise.classes.vehicles;

public class Vehicle {

    int wheels = 0;
    Speed maxSpeed = new Speed();
    Speed speed = new Speed();
    double position = 0;

    public Vehicle() {
        // can be empty
    }

    public void drive(final double minutes) {
        position += speed.get() * minutes / 60;
    }

    public void setSpeed(final double speedInt) {
        final Speed speed = new Speed().of(speedInt);
        if (speed.compareTo(maxSpeed) > 0) {
            this.speed = speed;
        } else {
            this.speed = maxSpeed;
        }
    }

    public void setMaxSpeed(final Speed maxSpeed) {
        if (maxSpeed.compareTo(new Speed()) > 0) {
            this.maxSpeed = maxSpeed;
        } else {
            System.out.println("Keine negative max Geschwindigkeit");
        }
    }

    @Override
    public String toString() {
        return String.format("%s at position %.2fkm with %s wheels, at speed %s of max. %s", //
                this.getClass().getSimpleName(), position, wheels, speed, maxSpeed);
    }
}
