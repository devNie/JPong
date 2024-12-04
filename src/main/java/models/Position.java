package main.java.models;

public class Position {
    private double x, y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Position() {
        this.x = 0;
        this.y = 0;
    }

    public double x() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void addToX(double x) {
        this.x += x;
    }

    public double y() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void addToY(double y) {
        this.y += y;
    }
}
