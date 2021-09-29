package de.dhbwka.java.exercise.classes.vehicles;

public class Speed {

    double speed = 0;

    public Speed() {

    }

    public void set(final double speed) {
        this.speed = speed;
    }

    public double get() {
        return speed;
    }

    public int compareTo(final Speed speed) {
        final int bigResult = Double.compare(this.get(), speed.get());

        // DER ZWEITE WERT IST GRÖßER
        if (bigResult > 0) {
            return -1;
            // DER ERSTE WERT IST GRÖßER
        } else if (bigResult < 0) {
            return 1;
            // BEIDE WERTE SIND GLEICH
        } else {
            return 0;
        }

    }

    @Override
    public String toString() {
        return String.format("%sKm/H", speed);
    }

    public Speed of(final double speed) {
        final Speed s = new Speed();
        s.set(speed);
        return s;
    }
}
