package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BinaryNumber extends JFrame {

    public String getResult() {
        return result.getText();
    }

    public void setResult(String inText) {
        this.result.setText(inText);
    }

    JLabel result;
    List<JToggleButton> btns = new ArrayList<>();

    BinaryNumber() {
        setTitle("BinaryNumber");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        JPanel bitpanel = new JPanel();
        bitpanel.setLayout(new GridLayout(2, 8));

        // Reihe 1
        JToggleButton bit7 = new JToggleButton();
        bit7.setActionCommand("7");
        JToggleButton bit6 = new JToggleButton();
        bit6.setActionCommand("6");
        JToggleButton bit5 = new JToggleButton();
        bit5.setActionCommand("5");
        JToggleButton bit4 = new JToggleButton();
        bit4.setActionCommand("4");
        JToggleButton bit3 = new JToggleButton();
        bit3.setActionCommand("3");
        JToggleButton bit2 = new JToggleButton();
        bit2.setActionCommand("2");
        JToggleButton bit1 = new JToggleButton();
        bit1.setActionCommand("1");
        JToggleButton bit0 = new JToggleButton();
        bit0.setActionCommand("0");

        btns.add(bit7);
        btns.add(bit6);
        btns.add(bit5);
        btns.add(bit4);
        btns.add(bit3);
        btns.add(bit2);
        btns.add(bit1);
        btns.add(bit0);

        btns.stream().peek(btn -> btn.addActionListener(new BTNList())).forEach(btn -> bitpanel.add(btn));

        // Reihe 2
        JLabel bit7l = new JLabel("2^7");
        JLabel bit6l = new JLabel("2^6");
        JLabel bit5l = new JLabel("2^5");
        JLabel bit4l = new JLabel("2^4");
        JLabel bit3l = new JLabel("2^3");
        JLabel bit2l = new JLabel("2^2");
        JLabel bit1l = new JLabel("2^1");
        JLabel bit0l = new JLabel("2^0");

        List<JLabel> lbls = new ArrayList<>();

        lbls.add(bit7l);
        lbls.add(bit6l);
        lbls.add(bit5l);
        lbls.add(bit4l);
        lbls.add(bit3l);
        lbls.add(bit2l);
        lbls.add(bit1l);
        lbls.add(bit0l);

        lbls.stream().peek(lbl -> lbl.setHorizontalAlignment(SwingConstants.CENTER)).forEach(lbl -> bitpanel.add(lbl));

        JPanel resultpanel = new JPanel(new GridLayout());

        result = new JLabel("0");
        resultpanel.add(result);


        JPanel mainpanel = new JPanel();
        mainpanel.add(bitpanel);
        mainpanel.add(resultpanel);
        add(mainpanel);
        revalidate();
    }

    public static void main(String[] args) {
        BinaryNumber bn = new BinaryNumber();
    }

    private class BTNList implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int num = 0;
            for (JToggleButton btn : btns) {
                if (btn.isSelected()) {
                    num += Math.pow(2, Integer.valueOf(btn.getActionCommand()));
                }
            }
            setResult(String.valueOf(num));
        }
    }
}
