package de.dhbwka.java.exercise.exams.soedermemory;

import java.awt.Color;

public enum PlayerStatus {

    ACTIVE(Color.ORANGE),
    WAITING(Color.BLACK),
    FINISHED(Color.GRAY);

    private Color color;

    PlayerStatus(Color c) {
        this.color = c;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(final Color color) {
        this.color = color;
    }
}
