package de.dhbwka.java.exercise.exams.soedermemory;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class MemoryGameTerm {

    private final static String title = "Soeder Memory";
    private final MemoryGame game;
    private List<JToggleButton> buttons = new ArrayList<>();
    private List<JLabel> labels = new ArrayList<>();
    private Path pathToFile = new File("src/de/dhbwka/java/exercise/exams/soedermemory/highscores.txt").toPath();
    private JFrame frame;
    private Thread t;

    MemoryGameTerm(final MemoryGame game) {
        this.game = game;
        initGUI();
    }

    private void initGUI() {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        JPanel main = new JPanel();
        main.setLayout(new GridLayout(2, 1));
        JPanel players = new JPanel();
        players.setLayout(new GridLayout(game.getPlayers().size(), 0));
        for (Player p : game.getPlayers()) {
            JLabel playerLabel = new JLabel(p.getName() + " (" + p.getPoints() + ")");
            playerLabel.setForeground(p.getStatus().getColor());
            labels.add(playerLabel);
            players.add(playerLabel);
        }
        JPanel pictures = new JPanel();
        pictures.setLayout(new GridLayout(game.getRows(), game.getCols()));
        for (MemoryImages.MemoryImage mi : game.getImages()) {
            for (int i = 0; i < 2; i++) {
                JToggleButton image = new JToggleButton(MemoryImages.getBackside());
                image.setDisabledIcon(mi.getImage());
                image.setActionCommand(mi.getId());
                image.addActionListener(e -> {
                            image.setEnabled(false);
                            if (CardsSelectedForPair()) {
                                if (isPair()) {
                                    game.getCurrentPlayer().addPoint();
                                    updateGUI();
                                    removeCards();
                                    if (endGame()) {
                                        game.getPlayers().forEach(p -> p.setStatus(PlayerStatus.FINISHED));
                                        updateGUI();
                                        showEndDialog();
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Sorry, those don't match", "Game Error", JOptionPane.ERROR_MESSAGE);
                                    game.nextPlayer();
                                    resetCards();
                                    updateGUI();
                                }
                            }
                        }
                );
                buttons.add(image);
                Collections.shuffle(buttons);
                for (JToggleButton btn : buttons) {
                    pictures.add(btn);
                }
            }
            main.add(players, BorderLayout.WEST);
            main.add(pictures, BorderLayout.CENTER);
            frame.add(main);
            frame.setVisible(true);
        }
        startTimer();
    }

    private void startTimer() {
        t = new Thread(() -> {
            int time = 0;
            while (buttons.size() > 0) {
                frame.setTitle(title + " (" + time + ")");
                time++;
                try {
                    Thread.sleep(999);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }

    private void showEndDialog() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Game ends after %s rounds, score: ", game.getRounds()));
        for (Player p : game.getPlayers()) {
            sb.append(p.getName() + " (" + p.getPoints() + "), ");
        }
        try {
            if (pathToFile.toFile().exists()) {
                sb.append("\n Last games: \n");
                List<String> lines = Files.readAllLines(pathToFile);
                for (String line : lines) {
                    sb.append(line + " \n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        saveCurrentRound();
        JOptionPane.showMessageDialog(null, sb.toString(), "Score", JOptionPane.INFORMATION_MESSAGE);
    }

    private void saveCurrentRound() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Game ends after %s rounds, score: ", game.getRounds()));
        for (Player p : game.getPlayers()) {
            sb.append(p.getName() + " (" + p.getPoints() + "), ");
        }
        if (pathToFile.toFile().exists()) {
            try {
                Files.write(pathToFile, sb.toString().getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Files.write(pathToFile, sb.toString().getBytes(), StandardOpenOption.CREATE_NEW);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean endGame() {
        return buttons.size() == 0;
    }

    private void removeCards() {
        buttons.removeAll(buttons.stream().filter(c -> !c.isEnabled()).collect(Collectors.toList()));
    }

    private void resetCards() {
        buttons.forEach(c -> c.setEnabled(true));
    }

    private void updateGUI() {
        for (int i = 0; i < labels.size(); i++) {
            Player p = game.getPlayers().get(i);
            labels.get(i).setText(p.getName() + " (" + p.getPoints() + ")");
            labels.get(i).setForeground(p.getStatus().getColor());
        }
    }


    private boolean isPair() {
        for (JToggleButton btn : buttons) {
            for (JToggleButton btn2 : buttons) {
                if (!btn.isEnabled() && !btn2.isEnabled() && btn != btn2) {
                    return btn.getActionCommand().equals(btn2.getActionCommand());
                }
            }
        }
        return false;
    }

    private boolean CardsSelectedForPair() {
        return buttons.stream().filter(c -> !c.isEnabled()).count() == 2;
    }
}
