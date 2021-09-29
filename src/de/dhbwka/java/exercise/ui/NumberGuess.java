package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class NumberGuess extends JFrame {

    Random r = new Random();
    int num = r.nextInt(1000);

    int guessint;
    int attempts = 1;
    JTextField output;
    JTextField playerNameTF;
    JTextField guessTF;

    NumberGuess() {
        setTitle("NumberGuess");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(450, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(new GridLayout());
        JPanel mainpanel = new JPanel(new GridLayout(0, 1));

        JLabel playerName = new JLabel("Player Name:");
        playerNameTF = new JTextField("Please enter your name.");
        JPanel playerPanel = new JPanel(new GridLayout(0, 2));
        playerPanel.add(playerName);
        playerPanel.add(playerNameTF);

        playerNameTF.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (((JTextField) e.getSource()).getText().equalsIgnoreCase("Please enter your name.")) {
                    ((JTextField) e.getSource()).setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (!((JTextField) e.getSource()).getText().isEmpty()) {
                    ((JTextField) e.getSource()).setText(((JTextField) e.getSource()).getText());
                } else {
                    ((JTextField) e.getSource()).setText("Please enter your name.");
                }
            }
        });


        JLabel guess = new JLabel("enter number between 1 and 1000");
        guessTF = new JTextField("E.g: 576");
        JPanel guessPanel = new JPanel(new GridLayout(0, 2));
        guessPanel.add(guess);
        guessPanel.add(guessTF);
        guessTF.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                ((JTextField) e.getSource()).setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (!((JTextField) e.getSource()).getText().isEmpty()) {
                    ((JTextField) e.getSource()).setText(((JTextField) e.getSource()).getText());
                }
            }
        });

        JButton newGame = new JButton("New Game");
        JButton okbtn = new JButton("OK");
        JButton bestPlayer = new JButton("Best Player");
        JButton exit = new JButton("Exit");
        JPanel optionsPanel = new JPanel(new GridLayout(0, 4));
        optionsPanel.add(newGame);
        optionsPanel.add(okbtn);
        optionsPanel.add(bestPlayer);
        optionsPanel.add(exit);

        System.out.println(num);
        newGame.addActionListener(e -> {
            attempts = 1;
            num = r.nextInt(1000);
        });

        okbtn.addActionListener(e -> {
            updateGuess();
            if (guessint == num) {
                outputWin();
                writeWinnerFiler();
            } else {
                outputUpdate();
            }
        });
        bestPlayer.addActionListener(e -> {

        });

        exit.addActionListener(e -> {
            System.exit(0);
        });

        output = new JTextField();
        output.setEditable(false);

        mainpanel.add(playerPanel);
        mainpanel.add(guessPanel);
        mainpanel.add(optionsPanel);
        mainpanel.add(output);
        this.add(mainpanel);
        revalidate();
    }

    private void writeWinnerFiler() {
        String fileName = "winners.txt";
        String fileContent = getPlayerNameTF() + " " + output.getText();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(fileContent);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPlayerNameTF() {
        return playerNameTF.getText();
    }

    private void outputWin() {
        this.output.setText("Attempt #" + attempts++ + ": " + guessint + " => Was Right!");
    }

    public int getGuessTF() {
        return Integer.valueOf(guessTF.getText());
    }

    public void updateGuess() {
        this.guessint = getGuessTF();
    }

    public void outputUpdate() {
        this.output.setText("Attempt #" + attempts++ + ": " + guessint + " => " + (guessint > num ? "Too high!" : "Too low!"));
    }

    public static void main(String[] args) {
        NumberGuess ng = new NumberGuess();
    }
}
