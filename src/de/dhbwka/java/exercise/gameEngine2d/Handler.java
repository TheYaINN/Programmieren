package de.dhbwka.java.exercise.gameEngine2d;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

    private LinkedList<GameObject> gameObjects = new LinkedList<>();

    public void tick() {
        for (GameObject object : gameObjects) {
            object.tick();
        }
    }

    public void render(Graphics g) {
        for (GameObject object : gameObjects) {
            object.render(g);
        }
    }

    public void addGameObject(GameObject object) {
        gameObjects.add(object);
    }

    public void removeGameObject(GameObject object) {
        gameObjects.remove(object);
    }

    public LinkedList<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void setGameObjects(final LinkedList<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }
}
