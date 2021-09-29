package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculator extends JFrame {

    JLabel outbodyType;
    JLabel outBMI;
    JTextField weigthtf;
    JTextField bodyHeighttf;

    ButtonGroup btngrp;


    public void setOutBMI(String inOutBMI) {
        this.outBMI.setText(inOutBMI);
    }

    BMICalculator() {
        setTitle("CurrencyCalculator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(new GridLayout(6, 2));

        JLabel weight = new JLabel("Weight (Kg)");
        JLabel bodyHeight = new JLabel("Body Height (m)");
        weigthtf = new JTextField();
        bodyHeighttf = new JTextField();
        JRadioButton male = new JRadioButton("Male");
        male.setActionCommand("male");
        JRadioButton female = new JRadioButton("Female");
        female.setActionCommand("female");
        JButton calc = new JButton("Calculate");
        calc.addActionListener(new CalculateBMI());
        outBMI = new JLabel("");
        outbodyType = new JLabel();


        btngrp = new ButtonGroup();
        btngrp.add(male);
        btngrp.add(female);

        mainpanel.add(weight);
        mainpanel.add(weigthtf);
        mainpanel.add(bodyHeight);
        mainpanel.add(bodyHeighttf);
        mainpanel.add(male);
        mainpanel.add(female);
        mainpanel.add(calc);
        mainpanel.add(new JLabel(""));
        mainpanel.add(outBMI);
        mainpanel.add(outbodyType);

        add(mainpanel);
        revalidate();
    }

    public void setOutbodyType(String inText) {
        this.outbodyType.setText(inText);
    }

    public String getWeigthtf() {
        return weigthtf.getText();
    }

    public void setWeigthtf(String inText) {
        this.weigthtf.setText(inText);
    }

    public String getBodyHeighttf() {
        return bodyHeighttf.getText();
    }

    public void setBodyHeighttf(String inText) {
        this.bodyHeighttf.setText(inText);
    }

    public String getSelectedButton() {
        return btngrp.getSelection().getActionCommand();
    }

    private class CalculateBMI implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int weight = Integer.valueOf(getWeigthtf());
            double height = Double.valueOf(getBodyHeighttf());
            double BMI = weight / (height * height);
            String classification = "default";
            if (getSelectedButton().equalsIgnoreCase("male")) {
                if (BMI < 20) {
                    classification = "Short weight";
                } else if (BMI >= 20 && BMI < 25) {
                    classification = "Normal weight";
                } else if (BMI >= 25 && BMI < 30) {
                    classification = "Overweight";
                } else if (BMI >= 30 && BMI < 40) {
                    classification = "Adiposity";
                } else if (BMI > 40) {
                    classification = "Massive Adiposity";
                } else {
                    classification = "some sort of failure here";
                }
            } else {
                if (BMI < 19) {
                    classification = "Short weight";
                } else if (BMI >= 19 && BMI < 24) {
                    classification = "Normal weight";
                } else if (BMI >= 24 && BMI < 30) {
                    classification = "Overweight";
                } else if (BMI >= 30 && BMI < 40) {
                    classification = "Adiposity";
                } else if (BMI > 40) {
                    classification = "Massive Adiposity";
                } else {
                    classification = "some sort of failure here";
                }
            }
            setBodyHeighttf("");
            setWeigthtf("");
            setOutBMI("BMI: " + BMI);
            setOutbodyType("Body Type: " + classification);

        }
    }


    public static void main(String[] args) {
        BMICalculator bmiCalculator = new BMICalculator();
    }
}