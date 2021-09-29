package de.dhbwka.java.exercise.classes;

import java.util.ArrayList;
import java.util.List;

public class Complex {

    double real;
    double imag;

    public Complex(final double real, final double imag) {
        this.real = real;
        this.imag = imag;
    }

    public Complex add(final Complex comp) {
        return new Complex(real + comp.getReal(), imag + comp.getImag());
    }

    public Complex sub(final Complex comp) {
        return new Complex(real - comp.getReal(), imag - comp.getImag());
    }

    public Complex div(final Complex comp) {
        final double scale = comp.getReal() * comp.getReal() + comp.getImag() * comp.getImag();
        return mult(new Complex(real / scale, -imag / scale));
    }

    public Complex mult(final Complex comp) {
        final double newReal = this.getReal() * comp.getReal() - this.getImag() * comp.getImag();
        final double newImag = this.getReal() * comp.getImag() + this.getImag() * comp.getReal();
        return new Complex(newReal, newImag);
    }

    private double getMagnitude() {
        return Math.sqrt(Math.pow(real, 2) + Math.pow(imag, 2));
    }

    public boolean isLess(final Complex comp) {
        return this.getMagnitude() < comp.getMagnitude() ? true : false;
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    @Override
    public String toString() {
        return String.format("%,.1f + %,.1fi, Betrag: %s", real, imag, getImag());
    }

    public static void main(final String[] args) {
        final List<Complex> start = new ArrayList<>();

        final Complex c1 = new Complex(1, 2);
        final Complex c2 = new Complex(2, 1);
        final Complex c3 = c1.add(c2);
        final Complex c4 = c1.sub(c2);
        final Complex c5 = c1.div(c2);
        final Complex c6 = c1.mult(c2);

        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());
        System.out.println(c4.toString());
        System.out.println(c6.toString());
        System.out.println(c5.toString());
        System.out.println(c1.isLess(c2));

        start.add(c1);
        start.add(c2);
        start.add(c3);
        start.add(c4);
        start.add(c5);
        start.add(c6);

        // Sortieren
        for (int j = 0; j < start.size(); j++) {
            for (int i = 0; i < start.size() - 1; i++) {
                if ((start.get(i + 1).isLess(start.get(i)))) {
                    final Complex temp = start.get(i + 1);
                    start.set(i + 1, start.get(i));
                    start.set(i, temp);
                }
            }
        }

        // Ausgabe 1
        System.out.println("\nAusgabe 2: ");
        for (final Complex complex : start) {
            System.out.println(complex.toString());
        }
    }

}
