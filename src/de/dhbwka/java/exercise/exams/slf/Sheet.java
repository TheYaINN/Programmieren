package de.dhbwka.java.exercise.exams.slf;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

public class Sheet {

    private final Player player;
    private final Game game;

    private JPanel mid = new JPanel();

    private JLabel remainingSecondsLabel = new JLabel();
    private JLabel startingLetterLabel = new JLabel();
    private JLabel pointsLabel = new JLabel();

    private JButton start = new JButton("Start");
    private JButton stop = new JButton("Stop");

    private Map<ColumnType, JTextField> map1 = new HashMap<>();
    private Map<ColumnType, JLabel> map2 = new HashMap<>();

    public Sheet(final Player player, final Game game) {
        this.player = player;
        this.game = game;
        createUI();
    }

    private void createUI() {
        JFrame frame = new JFrame(player.getName());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JLabel points = new JLabel("Points");
        JLabel remainingSeconds = new JLabel("Verbleibende Sekunden");
        JLabel startingLetter = new JLabel("Anfangsbuchstabe");

        JPanel top = new JPanel();
        top.setLayout(new GridLayout(0, 2));

        top.add(points);
        top.add(pointsLabel);
        top.add(remainingSeconds);
        top.add(remainingSecondsLabel);
        top.add(startingLetter);
        top.add(startingLetterLabel);
        updateTime();
        updatePlayerPoints();
        updateStartLetter();

        mainPanel.add(top, BorderLayout.NORTH);

        mid.setLayout(new GridLayout(0, 3));
        mid.add(new JLabel("Kein Spiel Aktiv."));

        mainPanel.add(mid, BorderLayout.CENTER);

        JPanel bottom = new JPanel();

        start.addActionListener(e -> game.startGame());
        stop.addActionListener(e -> game.stopGame());

        stop.setEnabled(false);

        bottom.add(start);
        bottom.add(stop);

        mainPanel.add(bottom, BorderLayout.SOUTH);
        frame.add(mainPanel);
        frame.setVisible(true);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    void updateTime() {
        remainingSecondsLabel.setText(String.valueOf(game.getRemainingTime()));
        remainingSecondsLabel.revalidate();
    }

    private void updatePlayerPoints() {
        pointsLabel.setText(String.valueOf(player.getPoints()));
    }

    private void updateStartLetter() {
        startingLetterLabel.setText(String.valueOf(game.getStartLetter()));
    }

    public void stop() {
        map1.values().forEach(t -> t.setEnabled(false));
        start.setEnabled(true);
        stop.setEnabled(false);
    }


    public void start() {
        map1.clear();
        map2.clear();
        mid.removeAll();
        for (ColumnType col : game.getColumns()) {
            JLabel type = new JLabel(col.getTitle());
            JTextField textfield = new JTextField();
            textfield.setText(String.valueOf(game.getStartLetter()));
            JLabel fieldPoints = new JLabel("0");

            mid.add(type);
            mid.add(textfield);
            mid.add(fieldPoints);

            map1.put(col, textfield);
            map2.put(col, fieldPoints);
        }
        updateStartLetter();
        mid.revalidate();
        start.setEnabled(false);
        stop.setEnabled(true);
    }

    public String getTypeTextField(final ColumnType type) {
        return map1.get(type).getText();
    }

    public void setPoints(final ColumnType t, final int points) {
        map2.get(t).setText(String.valueOf(points));
        pointsLabel.setText(String.valueOf(Integer.parseInt(pointsLabel.getText()) + points));
    }
}
