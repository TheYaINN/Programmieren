package de.dhbwka.java.exercise.exams.soedermemory;

public class Player {

    private String name;
    private int points = 0;
    private PlayerStatus status = PlayerStatus.WAITING;

    public Player(final String name) {
        this.name = name;
    }

    public void addPoint() {
        points++;
    }
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(final int points) {
        this.points = points;
    }

    public PlayerStatus getStatus() {
        return status;
    }

    public void setStatus(PlayerStatus status) {
        this.status = status;
    }
}
