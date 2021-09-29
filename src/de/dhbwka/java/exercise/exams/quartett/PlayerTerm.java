package de.dhbwka.java.exercise.exams.quartett;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerTerm implements QuartetsClient {

    private Player player;
    private Game game;
    private List<Component> labels = new ArrayList<>();

    public PlayerTerm(Player player, Game game) {
        this.player = player;
        this.game = game;

        createUI();
    }

    private void createUI() {
        JFrame frame = new JFrame(getWindowTitle());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        JPanel top = new JPanel();
        JLabel cardName = new JLabel(player.getTopCard().getTitle());
        top.add(cardName);
        labels.add(top);

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(0, 3));
        labels.add(center);

        Card card = player.getTopCard();
        for (Category cat : game.getCategories()) {
            JLabel catLabel = new JLabel(cat.getTitle());
            center.add(catLabel);
            JLabel catValue = new JLabel(card.getValue(cat) + " " + cat.getUnit());
            center.add(catValue);
            JButton catButton = new JButton("Go!");
            catButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    game.categorySelected(cat);
                }
            });
            center.add(catButton);
        }
        JPanel bottom = new JPanel();
        JLabel cardsAvailable = new JLabel(player.getPlayerDeck().size() + " Karten");
        bottom.add(cardsAvailable);


        frame.add(top, BorderLayout.NORTH);
        frame.add(center, BorderLayout.CENTER);
        frame.add(bottom, BorderLayout.SOUTH);
    }

    private String getWindowTitle() {
        return player.getName();
    }


    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public void showTopCard(final boolean active) {
        if (!active) {
            for (Component c : labels) {
                Arrays.stream(((JPanel) c).getComponents()).forEach(component -> c.setEnabled(false));
            }
        }
    }

    @Override
    public void setPlayedSeconds(final int secs) {

    }
}
