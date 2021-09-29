package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class CurrencyCalculator {

    public JTextField tf;

    public String getTfValue() {
        return tf.getText();
    }

    public void resetTf() {
        tf.setText("Please enter amount to convert.");
    }


    CurrencyCalculator() {
        JFrame frame = new JFrame();
        frame.setTitle("CurrencyCalculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout(1, 2));

        JPanel mp = new JPanel();
        tf = new JTextField("Please enter amount to convert.");
        tf.setColumns(25);
        tf.addFocusListener(new tfList());
        JButton btn1 = new JButton("EUR -> USD");
        JButton btn2 = new JButton("USD -> EUR");
        JButton btn3 = new JButton("Cancel");
        btn1.addActionListener(new EURUSD());
        btn2.addActionListener(new USDEUR());
        btn3.addActionListener(new EXIT());

        mp.add(tf);
        mp.add(btn1);
        mp.add(btn2);
        mp.add(btn3);
        frame.add(mp);
        frame.revalidate();
    }


    public static void main(String[] args) {
        CurrencyCalculator cc = new CurrencyCalculator();
    }

    private class EURUSD implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Double mon = Double.valueOf(getTfValue());
            mon = mon * 1.14;
            System.out.println(mon + "$");
            resetTf();
        }
    }

    private class USDEUR implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Double mon = Double.valueOf(getTfValue());
            mon = mon / 1.14;
            System.out.println(mon+"€");
            resetTf();
        }
    }

    private class EXIT implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private class tfList implements FocusListener {
        @Override
        public void focusGained(FocusEvent e) {
            ((JTextField) e.getSource()).setText("");
        }

        @Override
        public void focusLost(FocusEvent e) {
            //TODO: methods stub.
        }
    }
}
