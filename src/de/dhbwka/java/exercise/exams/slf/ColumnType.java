package de.dhbwka.java.exercise.exams.slf;

public enum ColumnType {

    CITY("Stadt"),
    COUNTRY("Land"),
    RIVER("Fluss"),
    PROFESSION("Beruf"),
    ANIMAL("Tier"),
    NAME("Vorname"),
    SPORT("Sportart"),
    FOOD("Lebensmittel"),
    BEVERAGE("Getränk"),
    GAME("Spiel");


    private String title;

    ColumnType(final String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }
}
