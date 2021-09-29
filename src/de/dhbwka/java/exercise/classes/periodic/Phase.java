package de.dhbwka.java.exercise.classes.periodic;

public class Phase {

    String[] state = {"SOLID", "LIQUID", "GAS"};

    int phase;

    public void setPhase(final int phase) {
        this.phase = phase;
    }

    public Phase() {
    }

    public Phase createLiquid() {
        final Phase phase = new Phase();
        phase.setPhase(2);
        return phase;
    }

    public Phase createGas() {
        final Phase phase = new Phase();
        phase.setPhase(3);
        return phase;
    }

    public Phase createSolid() {
        final Phase phase = new Phase();
        phase.setPhase(1);
        return phase;
    }

    @Override
    public String toString() {
        if (phase < 2) {
            return state[0];

        } else if (phase > 2) {
            return state[2];

        } else {
            return state[1];
        }
    }
}
