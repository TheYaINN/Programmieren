package de.dhbwka.java.exercise.exams.quartett;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    public List<Category> getCategories() {
        return categories;
    }

    private List<Category> categories = new ArrayList<>();
    private Integer categoriesAmount;

    private List<PlayerTerm> players = new ArrayList<>();

    public Game(final List<Category> categoryPool, final int amount) {
        categoriesAmount = amount;
        try {
            chooseRandomCategories(categoryPool);
        } catch (QuartetsException e) {
            e.printStackTrace();
        }
    }

    private void chooseRandomCategories(final List<Category> categoryPool) throws QuartetsException {
        if (categoryPool.size() < categoriesAmount) {
            throw new QuartetsException("Too few categories available");
        } else {
            Random ran = new Random();
            while (categoriesAmount >= 0) {
                int ranNum = ran.nextInt(categoryPool.size());
                categories.add(categoryPool.get(ranNum));
                categoriesAmount--;
            }
        }
    }

    public void start() throws QuartetsException {
        if (players.size() != 2) {
            throw new QuartetsException("Both players are required!");
        } else {
            players.get(0).getPlayer().showTopCard(true);
            players.get(1).getPlayer().showTopCard(true);
            if (players.get(0).getPlayer().isActive()) {
                players.get(0).getPlayer().showTopCard(false);
                players.get(1).getPlayer().showTopCard(true);
            } else if (players.get(1).getPlayer().isActive()) {
                players.get(0).getPlayer().showTopCard(true);
                players.get(1).getPlayer().showTopCard(false);
            }
        }
    }

    public void categorySelected(Category cat) {
        Card card1 = players.get(0).getPlayer().drawTopCard();
        Card card2 = players.get(1).getPlayer().drawTopCard();

        if (card1.getValue(cat) == (card2.getValue(cat))) {
            players.get(0).getPlayer().addCard(card1);
            players.get(1).getPlayer().addCard(card2);
        } else {
            if (card1.getValue(cat) > (card2.getValue(cat))) {
                players.get(0).getPlayer().addCard(card1);
                players.get(0).getPlayer().addCard(card2);
            } else {
                players.get(1).getPlayer().addCard(card1);
                players.get(1).getPlayer().addCard(card2);
            }
        }
    }

    public void registerClient1(PlayerTerm player1) {
        players.add(player1);
    }

    public void registerClient2(PlayerTerm player1) {
        players.add(player1);
    }

}
