package de.dhbwka.java.exercise.gameEngine2d;

import java.awt.Graphics;

public abstract class GameObject {

    private ID id;

    private int coordinateX;
    private int coordinateY;

    private int velocityX;
    private int velocityY;

    public GameObject(final ID id, final int coordinateX, final int coordinateY) {
        this.id = id;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public abstract void tick();

    public abstract void render(Graphics g);


    public ID getId() {
        return id;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(final int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(final int coordinateY) {
        this.coordinateY = coordinateY;
    }


    public int getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(final int velocityX) {
        this.velocityX = velocityX;
    }

    public int getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(final int velocityY) {
        this.velocityY = velocityY;
    }
}
