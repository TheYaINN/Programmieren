package de.dhbwka.java.exercise.threads;

import javax.swing.*;
import java.awt.*;

public class DancingText extends JComponent {

    char[] text;
    int x = 80;
    int y = 140;
    int yOffset = 10;
    Color current;
    Color next;


    DancingText() {
        text = "Hello World! :)".toCharArray();
        current = Color.RED;
        Runnable r = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                        repaint();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t = new Thread(r);
        t.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        for (char c : text) {
            g.setColor(getAndSetNextColor());
            g.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
            g.drawString(Character.toString(c), updateX(), updateY());
        }
    }

    private int updateX() {
        if (x > 300) {
            x = 60;
        }
        x += 5;
        return x;
    }

    private int updateY() {
        if (yOffset > 150) {
            yOffset = 10;
        }
        yOffset += 5;
        return (y + yOffset);
    }

    private Color getAndSetNextColor() {
        if (current == Color.RED) {
            next = Color.ORANGE;
        } else if (current == Color.ORANGE) {
            next = Color.YELLOW;
        } else if (current == Color.YELLOW) {
            next = Color.GREEN;
        } else if (current == Color.GREEN) {
            next = Color.CYAN;
        } else if (current == Color.CYAN) {
            next = Color.BLUE;
        } else if (current == Color.BLUE) {
            next = Color.MAGENTA;
        } else if (current == Color.MAGENTA) {
            next = Color.RED;
        }
        current = next;
        return next;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("DancingText");
        frame.setSize(350, 350);
        frame.add(new DancingText());
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
