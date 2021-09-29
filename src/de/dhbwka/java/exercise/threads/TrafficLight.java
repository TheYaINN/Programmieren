package de.dhbwka.java.exercise.threads;

import javax.swing.*;
import java.awt.*;

public class TrafficLight extends JComponent {


    LightPhase lp;

    TrafficLight() {
        lp = new LightPhase();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(lp.getDuration());
                        lp = lp.getNext();
                        repaint();
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        };
        Thread t = new Thread(r);
        t.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(100, 50, 50, 145);
        g.setColor(lp.isRed() ? Color.RED : Color.WHITE);
        g.fillOval(105, 55, 40, 40);
        g.setColor(lp.isYellow() ? Color.YELLOW : Color.WHITE);
        g.fillOval(105, 100, 40, 40);
        g.setColor(lp.isGreen() ? Color.GREEN : Color.WHITE);
        g.fillOval(105, 145, 40, 40);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("TrafficLight");
        frame.setSize(350, 350);
        frame.add(new TrafficLight());
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    class LightPhase {
        private boolean red;
        private boolean yellow;
        private boolean green;
        private int duration;
        private LightPhase next;

        public int getDuration() {
            return duration;
        }

        LightPhase() {
            red = true;
            duration = 2000;
        }

        LightPhase(boolean red, boolean yellow, boolean green, int duration) {
            this.red = red;
            this.yellow = yellow;
            this.green = green;
            this.duration = duration;
        }

        public LightPhase getNext() {
            if (red && !yellow && !green) {
                next = new LightPhase(true, true, false, 500);
            } else if (red && yellow && !green) {
                next = new LightPhase(false, false, true, 2000);
            } else if (!red && !yellow && green) {
                next = new LightPhase(false, true, false, 500);
            } else if (!red && yellow && !green) {
                next = new LightPhase(true, false, false, 2000);
            }
            return next;
        }

        public boolean isRed() {
            return red;
        }

        public boolean isYellow() {
            return yellow;
        }

        public boolean isGreen() {
            return green;
        }
    }

}

