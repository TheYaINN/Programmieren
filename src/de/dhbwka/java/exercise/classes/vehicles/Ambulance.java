package de.dhbwka.java.exercise.classes.vehicles;

public class Ambulance extends Car {

    boolean lights;

    public Ambulance(final double speed, final boolean lights) {
        super(speed);
        this.lights = lights;
    }

    public void toggleLights() {
        if (!lights) {
            lights = true;
        } else {
            lights = false;
        }
    }
}
