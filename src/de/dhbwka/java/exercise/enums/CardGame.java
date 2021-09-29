package de.dhbwka.java.exercise.enums;

public class CardGame {

    enum Suit {
        Diamonds, Heart, Spade, Clubs
    }

    enum CardValue {
        SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }

    abstract class PlayingCard implements Comparable {

        Suit s;
        CardValue cv;

        PlayingCard() {

        }

        private int compareTo(PlayingCard c) {
            int comp = this.s.compareTo(c.s);
            switch (comp) {
                case -1:
                    return -1;
                case 0:
                    return 0;
                case 1:
                    return 1;
                default:
                    return 0;
            }
        }

        @Override
        public String toString() {
            return String.format("Die Karte %s hat den Wert %s", s.name(), cv.name());
        }
    }

}
