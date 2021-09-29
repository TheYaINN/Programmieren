package de.dhbwka.java.exercise.ui;

import javax.swing.*;

public class ComponentFrame extends JFrame {

    ComponentFrame() {
        setVisible(true);
        setSize(650, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("ComponentFrame");
        JPanel mainpanel = new JPanel();
        mainpanel.add(new JLabel("JLabel"));
        JTextField txtf = new JTextField("TextField");
        txtf.setColumns(6);
        mainpanel.add(txtf);
        JPasswordField pwf = new JPasswordField("TestText");
        pwf.setColumns(6);
        mainpanel.add(pwf);
        JButton btn = new JButton("JButton");
        btn.setToolTipText("Jbutton hier!");
        mainpanel.add(btn);
        mainpanel.add(new JToggleButton("JToggleButton"));
        mainpanel.add(new JCheckBox("JCheckBox"));
        JComboBox cmb = new JComboBox();
        cmb.addItem("Item 1");
        cmb.addItem("Item 2");
        cmb.addItem("Item 3");
        cmb.addItem("Item 4");
        mainpanel.add(cmb);
        ButtonGroup grp = new ButtonGroup();
        JRadioButton btn1 = new JRadioButton("Radio-Button-1");
        JRadioButton btn2 = new JRadioButton("Radio-Button-2");
        JRadioButton btn3 = new JRadioButton("Radio-Button-3");
        grp.add(btn1);
        grp.add(btn2);
        grp.add(btn3);
        mainpanel.add(btn1);
        mainpanel.add(btn2);
        mainpanel.add(btn3);
        add(mainpanel);
        revalidate();
    }

    public static void main(String[] args) {
        ComponentFrame frame = new ComponentFrame();

    }
}