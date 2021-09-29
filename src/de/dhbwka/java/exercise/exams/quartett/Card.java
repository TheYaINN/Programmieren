package de.dhbwka.java.exercise.exams.quartett;

import java.util.HashMap;
import java.util.Map;

public class Card {

    private String title;
    private Map<Category, Integer> values = new HashMap<>();

    public Card(final String title) {
        this.title = title;
    }

    public void setValue(Category cat, int val) {
        values.put(cat, val);
    }

    public Integer getValue(Category cat) {
        return values.get(cat);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }
}
