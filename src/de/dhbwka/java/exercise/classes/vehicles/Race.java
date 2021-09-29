package de.dhbwka.java.exercise.classes.vehicles;

import java.util.ArrayList;
import java.util.List;

public class Race {

    static List<Vehicle> vehicles = new ArrayList<>();

    public Race() {
        // TODO Auto-generated constructor stub
    }

    private void addVehicle(final Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    private void race() {
        for (final Vehicle v : vehicles) {
            v.drive(60);
        }
    }

    private void generateVehicles(final Race race) {
        race.addVehicle(new Bicycle(20));
        vehicles.get(0).drive(240);
        race.addVehicle(new Car(150));
        race.addVehicle(new Racecar(200));
        race.addVehicle(new Ambulance(80, true));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (final Vehicle vehicle : vehicles) {
            sb.append(vehicle.toString() + "\n");
        }
        return sb.toString();
    }

    public static void main(final String[] args) {
        final Race race = new Race();
        race.generateVehicles(race);
        race.race();
        System.out.println(race.toString());
    }
}
