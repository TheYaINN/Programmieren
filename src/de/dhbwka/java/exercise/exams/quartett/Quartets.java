package de.dhbwka.java.exercise.exams.quartett;

import javax.swing.JOptionPane;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Quartets Game
 */
public class Quartets {

    /**
     * Card value types in order of the provided example data and cards.txt file (used in {@link #parseCard(String)})
     */
    private final static Category[] CARD_TYPES = new Category[]{Category.EUROROUTE, Category.FREEWAY, Category.PIPELINE, Category.RAILS, Category.INTERNET, Category.INTERNET_MOBILE};

    /**
     * Entry point of application
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        try {
            final List<Card> deck = Quartets.loadCards();
            final int sizePerPlayer = deck.size() / 2; // integer division takes care of odd deck sizes

            final List<Category> categoryPool = Arrays.asList(Category.values());

            final Game game = new Game(categoryPool, 5);
            final Player alex = new Player("Alex", new LinkedList<>(deck.subList(0, sizePerPlayer)));
            final Player andy = new Player("Andy", new LinkedList<>(deck.subList(sizePerPlayer, sizePerPlayer * 2)));

            game.registerClient1(new PlayerTerm(alex, game));
            game.registerClient2(new PlayerTerm(andy, game));

            game.start();
        } catch (final QuartetsException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Loads list of all available cards for the game
     *
     * @return list of available card for game
     */
    private static List<Card> loadCards() {
        final List<Card> cards = new LinkedList<>();

        // START: replace this code
        final String[] exampleData = new String[]{
                "Estland;953;154;0;1161;90;68",
                "Finnland;4286;893;0;5926;94;74",
                "Frankreich;12797;11618;6400;28120;89;68",
                "Griechenland;0;280;53;2240;76;52"
        };
        for (final String example : exampleData) {
            final Card card = Quartets.parseCard(example);
            if (card != null) {
                cards.add(card);
            }
        }
        // END: replace this code

        return cards;
    }

    /**
     * Parse card instance
     *
     * @param line line to parse
     * @return parsed card instance
     */
    private static Card parseCard(final String line) {
        try {
            final String[] lineData = line.split("[;]");
            final Card card = new Card(lineData[0]);
            for (int i = 0; i < Quartets.CARD_TYPES.length; i++) {
                card.setValue(Quartets.CARD_TYPES[i], Integer.parseInt(lineData[1 + i]));
            }
            return card;
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
