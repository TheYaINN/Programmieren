package de.dhbwka.java.exercise.classes;

import java.util.Arrays;

public class Polynomial {

    double a; // first term
    double b; // second term
    double c; // third term

    public Polynomial(final double a, final double b, final double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double value(final int x) {
        return Math.pow(a * x, 2) + b * x + c;
    }

    public Polynomial add(final Polynomial p) {
        return new Polynomial(a + p.getA(), b + p.getB(), c + p.getC());
    }

    public Polynomial sub(final Polynomial p) {
        return new Polynomial(a - p.getA(), b - p.getB(), this.c - p.getC());
    }

    public void mult(final int multiplier) {
        a *= multiplier;
        b *= multiplier;
        c *= multiplier;
    }

    public double[] root() {
        final double p = b / a;
        final double q = c / a;
        final double t1 = -(p / 2);
        final double t2 = Math.sqrt(Math.pow((p / 2), 2) - q);
        final double x1 = t1 + t2;
        final double x2 = t1 - t2;
        if (!Double.isNaN(x1) && Double.isNaN(x2)) {
            return new double[] {x1};
        } else if (Double.isNaN(x1) && !Double.isNaN(x2)) {
            return new double[] {x2};
        } else if (Double.isNaN(x1) && Double.isNaN(x2)) {
            return new double[] {};
        } else {
            return new double[] {x1, x2};
        }
    }

    public void scale(final int scale) {
        a *= scale;
        b *= scale;
        c *= scale;
    }

    public double getA() {
        return a;
    }

    public void setA(final double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(final double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(final double c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return String.format("f(x) = %sx^2 + %sx + %s", a, b, c);
    }

    public static void main(final String[] args) {
        final Polynomial p1 = new Polynomial(2, 0, 0);
        final Polynomial p2 = new Polynomial(0, -4, 1);
        final Polynomial p3 = p1.add(p2);
        System.out.println("P1: " + p1.toString());
        System.out.println("P2: " + p2.toString());
        System.out.println("P3: " + p3.toString());
        p3.mult(2);
        System.out.println("P3 * 2: " + p3.toString());

        System.out.println("Nulstellen von P3:");
        System.out.println(Arrays.toString(p3.root()).replaceAll("[\\[\\]]", ""));

        System.out.println("P1: " + Arrays.toString(p1.root()).replaceAll("[\\[\\]]", ""));
        System.out.println("P2: " + Arrays.toString(p2.root()).replaceAll("[\\[\\]]", ""));

    }

}
