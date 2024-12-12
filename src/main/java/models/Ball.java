package main.java.models;


public class Ball {

    // Object Fields
    private Position position;
    private double radius;          // Used for scaling the collider tied to game scale
    private final Direction[] direction;  // Used for scaling the collider
    private double delta;           // Absolute rate of change in each axis equivalent to speed/frame-rate
    private final Collider collider;

    // Constructor
    public Ball(Position position, double radius, int delta) {
        this.position = position;
        this.radius = radius;
        this.direction = new Direction[] {Direction.NONE, Direction.NONE};
        this.delta = delta;
        this.collider = new Collider(this.position,this.radius*2, this.radius*2);
    }


    // Picks a random direction for the ball to start moving in (used when resetting the ball)
    public void push() {
        direction[0] = (Math.random() > 0.5) ? Direction.RIGHT : Direction.LEFT;
        direction[1] = (Math.random() > 0.5) ? Direction.UP : Direction.DOWN;
    }

    // Stops the ball dead in its tracks
    public void stop() {
        direction[0] = Direction.NONE;
        direction[1] = Direction.NONE;
    }

    // Stop the ball and set new delta
    public void stop(double delta) {
        this.delta = delta;
        stop();
    }

    // Determines ball movement after colliding with a face of a collider
    public void bounce(Face collisionFace) {
        switch (collisionFace) {
            case RIGHT:
                direction[0] = Direction.RIGHT;
                break;
            case LEFT:
                direction[0] = Direction.LEFT;
                break;
            case TOP:
                direction[0] = Direction.UP;
                break;
            case BOTTOM:
                direction[0] = Direction.DOWN;
                break;
            case NONE:
                break;
        }
    }

    // Move the ball by one frame
    public void move() {
        position.addToX(delta * (direction[0] != Direction.NONE ? (direction[1] == Direction.RIGHT ? 1 : -1) : 0));

        // Reduced vertical momentum by 20% to get irregular bounce patterns (might introduce a random vertical factor later)
        position.addToY(delta * (direction[1] != Direction.NONE ? (direction[1] == Direction.DOWN ? 0.8f : -0.8f) : 0));
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return this.position;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

}
