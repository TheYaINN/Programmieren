package de.dhbwka.java.exercise.exams.slf;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Validator {

    private List<String> words = new ArrayList<>();
    private Game game;


    public void init(Game game) {
        this.game = game;
        getValidWordsList();
    }

    private void getValidWordsList() {
        try {
            words = Files.readAllLines(Paths.get("src/de/dhbwka/java/exercise/exams/slf/validwords.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isValidWord(String s) {
        return words.stream()
                .filter(w -> w.startsWith(String.valueOf(game.getStartLetter()).toLowerCase()))
                .anyMatch(w -> w.equalsIgnoreCase(s));
    }
}


