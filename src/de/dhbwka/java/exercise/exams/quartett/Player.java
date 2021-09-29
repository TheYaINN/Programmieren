package de.dhbwka.java.exercise.exams.quartett;

import java.util.ArrayList;
import java.util.List;

public class Player implements QuartetsClient {

    private String name;
    private List<Card> playerDeck = new ArrayList<>();

    public boolean isActive() {
        return active;
    }

    private boolean active;

    public Player(final String name, final List<Card> playerDeck) {
        this.name = name;
        this.playerDeck = playerDeck;
    }

    public String getName() {
        return name;
    }

    public void addCard(Card card) {
        playerDeck.add(card);
    }

    public boolean hasCards() {
        return !playerDeck.isEmpty();
    }

    public Card getTopCard() {
        return hasCards() ? playerDeck.get(playerDeck.size() - 1) : null;
    }

    public Card drawTopCard() {
        if (!playerDeck.isEmpty()) {
            Card card = getTopCard();
            playerDeck.remove(playerDeck.size() - 1);
            return card;
        }
        return null;
    }

    public List<Card> getPlayerDeck() {
        return playerDeck;
    }

    @Override
    public Player getPlayer() {
        return this;
    }

    public void showTopCard(final boolean active) {
        this.active = active;
    }

    @Override
    public void setPlayedSeconds(final int secs) {

    }
}
