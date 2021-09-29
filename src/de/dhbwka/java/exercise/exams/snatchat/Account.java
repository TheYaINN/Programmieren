package de.dhbwka.java.exercise.exams.snatchat;

import java.awt.Color;
import java.util.Random;

public class Account {

    private State state = State.AVAILABLE;
    private final String name;
    private Color chatColor;

    Account(String name) {
        this.name = name;
        Random rnd = new Random();
        chatColor = new Color(rnd.nextInt(201), rnd.nextInt(201), rnd.nextInt(201));
    }

    public State getState() {
        return state;
    }

    public void setState(final State state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public Color getChatColor() {
        return chatColor;
    }

    public void setChatColor(final Color chatColor) {
        this.chatColor = chatColor;
    }
}
