package de.dhbwka.java.exercise.exams.slf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static java.lang.Thread.sleep;

public class Game {

    private final int seconds;
    private Random r = new Random();

    private int min;
    private int max;

    private char startLetter;
    private boolean running = false;
    private List<ColumnType> columns;
    private int remainingTime;

    private List<Sheet> players = new ArrayList<>();
    private Validator validator;
    private boolean exit;

    public Game(final int inMin, final int inMax, final int inSeconds) {
        if (inMin < 3) {
            min = 3;
        }
        if (inMax < min) {
            min = inMax;
        }
        min = inMin;
        max = inMax;
        seconds = inSeconds;
        validator = new Validator();
        validator.init(this);
    }


    void startGame() {
        if (!running) {
            remainingTime = seconds;
            running = true;
            exit = false;
            createFirstCharacter();
            createColumns();
            players.forEach(Sheet::start);
            Runnable r = (() -> {
                while (!exit) {
                    remainingTime--;
                    players.forEach(Sheet::updateTime);
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (remainingTime <= 0) {
                        exit = true;
                        players.forEach(Sheet::stop);
                    }
                }
            });
            Thread t = new Thread(r);
            t.start();
        }
    }


    void stopGame() {
        running = false;
        players.forEach(Sheet::stop);
        checkWords();
        exit = true;
    }

    private void checkWords() {
        for (ColumnType t : columns) {
            List<Sheet> validPlayers = players.stream().filter(p -> p.getTypeTextField(t).length() > 1).filter(p -> validator.isValidWord(p.getTypeTextField(t))).collect(Collectors.toList());
            players.stream().filter(p -> !validPlayers.contains(p)).forEach(p -> p.setPoints(t, 0));
            for (Sheet s : validPlayers) {
                if (validPlayers.stream().filter(p -> p != s).anyMatch(p -> p.getTypeTextField(t).equalsIgnoreCase(s.getTypeTextField(t)))) {
                    s.setPoints(t, 5);
                } else if (validPlayers.stream().filter(p -> p != s).filter(p -> !p.getTypeTextField(t).equalsIgnoreCase(s.getTypeTextField(t))).count() == 1) {
                    s.setPoints(t, 10);
                } else {
                    s.setPoints(t, 20);
                }
            }
        }
    }

    private void createColumns() {
        HashSet<ColumnType> columnTypes = new HashSet<>();

        columnTypes.add(ColumnType.CITY);
        columnTypes.add(ColumnType.COUNTRY);
        columnTypes.add(ColumnType.RIVER);

        int columnSize = min + r.nextInt(max - min);

        while (columnTypes.size() < columnSize) {
            int myVal = r.nextInt(ColumnType.values().length);
            columnTypes.add(ColumnType.values()[myVal]);
        }
        columns = new ArrayList<>(columnTypes);
    }


    private void createFirstCharacter() {
        startLetter = (char) ('A' + r.nextInt(26));
    }

    public char getStartLetter() {
        return startLetter;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void register(final Sheet sheet) {
        players.add(sheet);
    }

    public List<ColumnType> getColumns() {
        return columns;
    }
}
