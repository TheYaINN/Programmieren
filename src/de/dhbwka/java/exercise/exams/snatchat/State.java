package de.dhbwka.java.exercise.exams.snatchat;

public enum State {

    AVAILABLE("Available"),
    AWAY("Away"),
    DND("Do Not Disturb");

    String state;

    State(String state) {
        this.state = state;
    }
}
