package de.dhbwka.java.exercise.exams.soedermemory;

import java.util.List;

class MemoryGame {

    private final List<Player> players;
    private Player currentPlayer;
    private final List<MemoryImages.MemoryImage> images;
    private final int rows;
    private final int cols;
    private int rounds = 0;

    MemoryGame(final List<Player> players, final List<MemoryImages.MemoryImage> images, final int rows, final int cols) {
        this.rows = rows;
        this.cols = cols;
        if (players.size() < 2) {
            try {
                throw new memoryException("At least two players are required.");
            } catch (memoryException e) {
                e.printStackTrace();
            }
        }
        int boardSize = rows * cols;
        if ((images.size() * 2) < boardSize) {
            try {
                throw new memoryException("„Too few images available.");
            } catch (memoryException e) {
                e.printStackTrace();
            }
        }
        this.players = players;
        this.currentPlayer = players.get(0);
        this.images = images.subList(0, boardSize);
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isBlankRequired() {
        return images.size() % 2 != 0;
    }

    public void nextPlayer() {
        currentPlayer.setStatus(PlayerStatus.WAITING);
        int index = players.indexOf(currentPlayer) + 1;
        int newIndex = players.size() >= index ? index % players.size() : index;
        currentPlayer = players.get(newIndex);
        currentPlayer.setStatus(PlayerStatus.ACTIVE);
        rounds++;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setCurrentPlayer(final Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public List<MemoryImages.MemoryImage> getImages() {
        return images;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(final int rounds) {
        this.rounds = rounds;
    }
}
