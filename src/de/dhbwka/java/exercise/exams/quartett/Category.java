package de.dhbwka.java.exercise.exams.quartett;

public enum Category {

    FREEWAY("Autobahnen", "km"),
    EUROROUTE("EuropaStraﬂen", "km"),
    PIPELINE("÷l-Pipelines", "km"),
    RAILS("Schienennetz", "km"),
    INTERNET("Internet", "%"),
    INTERNET_MOBILE("Internet (Mobil)", "%");

    private String title;
    private String unit;

    Category(final String title, final String unit) {
        this.title = title;
        this.unit = unit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(final String unit) {
        this.unit = unit;
    }
}
