package de.dhbwka.java.exercise.classes.periodic;

public class Element {

    String name;
    String symbol;
    int ordinal;
    char shell;
    Phase phase;
    boolean group;

    public Element(final String name, final String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public Element(final String name, final String symbol, final int ordinal, final char shell, final Phase phase, final boolean group) {
        this.name = name;
        this.symbol = symbol;
        this.ordinal = ordinal;
        this.shell = shell;
        this.phase = phase;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(final String symbol) {
        this.symbol = symbol;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(final int ordinal) {
        this.ordinal = ordinal;
    }

    public char getShell() {
        return shell;
    }

    public void setShell(final char shell) {
        this.shell = shell;
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(final Phase phase) {
        this.phase = phase;
    }

    public boolean isGroup() {
        return group;
    }

    public void setGroup(final boolean group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return new StringBuilder() //
                .append(name) //
                .append(" (" + symbol + "," + ordinal + ") ") //
                .append("Schale: ") //
                .append(shell + ", ") //
                .append(phase + ", ") //
                .append("Gruppe: ") //
                .append(group) //
                .toString();
    }

}
