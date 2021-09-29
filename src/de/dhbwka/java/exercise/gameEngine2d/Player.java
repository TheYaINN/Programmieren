package de.dhbwka.java.exercise.gameEngine2d;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {

    public Player(final ID id, final int coordinateX, final int coordinateY) {
        super(id, coordinateX, coordinateY);
    }

    @Override
    public void tick() {
        setCoordinateX(getCoordinateX() + getVelocityX());
        setCoordinateY(getCoordinateY() + getVelocityY());
    }

    @Override
    public void render(final Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(getCoordinateX(), getCoordinateY(), 32, 32);
    }
}
