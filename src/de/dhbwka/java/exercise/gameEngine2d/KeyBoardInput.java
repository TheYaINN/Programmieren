package de.dhbwka.java.exercise.gameEngine2d;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.*;

public class KeyBoardInput extends KeyAdapter {

    private Handler handler;

    public KeyBoardInput(final Handler handler) {
        this.handler = handler;
    }

    @Override
    public void keyPressed(final KeyEvent e) {
        int key = e.getKeyCode();
        for (GameObject tempObject : handler.getGameObjects()) {
            if (tempObject.getId() == ID.PLAYER) {
                if (key == VK_W) {
                    tempObject.setVelocityY(-10);
                } else if (key == VK_S) {
                    tempObject.setVelocityY(10);
                } else if (key == VK_A) {
                    tempObject.setVelocityX(-10);
                } else if (key == VK_D) {
                    tempObject.setVelocityX(10);
                }
            }
        }
    }

    @Override
    public void keyReleased(final KeyEvent e) {
        int key = e.getKeyCode();
        for (GameObject tempObject : handler.getGameObjects()) {
            if (tempObject.getId() == ID.PLAYER) {
                if (key == VK_W) {
                    tempObject.setVelocityY(0);
                } else if (key == VK_S) {
                    tempObject.setVelocityY(0);
                } else if (key == VK_A) {
                    tempObject.setVelocityX(0);
                } else if (key == VK_D) {
                    tempObject.setVelocityX(0);
                }
            }
        }
    }
}
