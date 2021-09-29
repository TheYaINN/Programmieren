package de.dhbwka.java.exercise.classes.periodic;

public class Metal extends Element {

    boolean metalloid;
    double conductivity;

    public Metal(final String name, final String symbol) {
        super(name, symbol);
    }

    public Metal(final String name, final String symbol, final int ordinal, final char shell, final Phase phase, final boolean group, final boolean metalloid,
            final double conductivity) {
        super(name, symbol, ordinal, shell, phase, group);
        this.metalloid = metalloid;
        this.conductivity = conductivity;
    }

    public String isMetalloid() {
        return metalloid ? "Halbleiter" : "Leiter";
    }

    public String getConductivity() {
        return " σ " + conductivity + "S/m";
    }

    @Override
    public String toString() {
        return new StringBuilder().append(super.toString()).append(isMetalloid()).append(conductivity).toString();
    }

}
