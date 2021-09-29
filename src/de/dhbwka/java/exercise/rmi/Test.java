package de.dhbwka.java.exercise.rmi;

import java.io.Serializable;

public class Test implements Serializable {

    private final String name;

    public Test(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                '}';
    }
}
