package main.java.models;

public class Collider {
    private Position position;
    private double width, height;

    public Collider(Position position, double width, double height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public Face checkCollision(Collider target, Direction direction) {
        return switch (direction) {
            case LEFT -> (this.position.x()+this.width > target.position.x()) ? Face.RIGHT : Face.NONE;
            case RIGHT -> (target.position.x()+target.width > this.position.x()) ? Face.LEFT : Face.NONE;
            case UP -> (this.position.y()+this.height > target.position.y()) ? Face.BOTTOM : Face.NONE;
            case DOWN -> (target.position.y()+target.height > this.position.y()) ? Face.TOP : Face.NONE;
            case NONE -> Face.NONE;
        };
    }

    public Position getPosition() {
        return position;
    }

    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

}
