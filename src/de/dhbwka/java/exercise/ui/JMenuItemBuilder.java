package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import java.awt.event.ActionListener;

public class JMenuItemBuilder {


    private JMenuItem item;

    JMenuItemBuilder() {
        item = new JMenuItem();
    }

    public static JMenuItemBuilder builder() {
        return new JMenuItemBuilder();
    }

    public JMenuItemBuilder text(String inText) {
        item.setText(inText);
        return this;
    }

    public JMenuItemBuilder addAction(ActionListener actionListener) {
        item.addActionListener(actionListener);
        return this;
    }

    public JMenuItem build() {
        return item;
    }

}
