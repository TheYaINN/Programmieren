package de.dhbwka.java.exercise.classes;

public class Point {

    private double coordX;
    private double coordY;

    public Point(final double d, final double e) {
        this.coordX = d;
        this.coordY = e;
    }

    public double getX() {
        return this.coordX;
    }

    public double getY() {
        return this.coordY;
    }

    public double getDistToOrig() {
        return Math.sqrt(Math.pow(coordX - 0, 2) + Math.pow(coordY - 0, 2));
    }

    public double getDistToPoint(final Point point) {
        return Math.sqrt(Math.pow(coordX - point.getX(), 2) + Math.pow(coordY - point.getY(), 2));
    }

    public Point mirrorX() {
        return new Point(coordX, this.coordY * -1);
    }

    public Point mirrorY() {
        return new Point(this.coordX * -1, coordY);
    }

    public Point mirrorOrigin() {
        return new Point(this.coordX * -1, this.coordY * -1);
    }

    public void add(final Point point) {
        coordX = coordX + point.getX();
        coordY = coordY + point.getY();
    }

    public void sub(final Point point) {
        coordX = coordX - point.getX();
        coordY = coordY - point.getY();
    }

    public void multiply(final double number) {
        coordX = coordX * number;
        coordY = coordY * number;
    }

    public void divide(final double number) {
        coordX = coordX / number;
        coordY = coordY / number;
    }

    public double getMagnitude() {
        return Math.sqrt((coordX * coordX) + (coordY * coordY));
    }

    public void normalize() {
        final double m = getMagnitude();
        if (m != 0) {
            divide(m);
        }
    }

    public void setPoint(final int coordX, final int coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public Point getPoint() {
        return new Point(coordX, coordY);
    }

    @Override
    public String toString() {
        return "(" + coordX + "|" + coordY + ")";
    }

    public static void main(final String[] args) {

        Point pointA = new Point(4.0, 2.0);
        System.out.println("A: " + pointA);
        System.out.println("Betrag: " + pointA.getMagnitude());
        final Point pointB = new Point(-1.0, -1.0);
        System.out.println("B: " + pointB);
        System.out.println("Abstand A-B: " + pointA.getDistToPoint(pointB));
        pointA = pointA.mirrorOrigin();
        System.out.println("A': " + pointA);
        System.out.println("Abstand A’-B: " + pointA.getDistToPoint(pointB));
        pointA = pointA.mirrorOrigin();
        System.out.println(pointA.getPoint());
        System.out.println(pointB.getDistToOrig());
    }
}
