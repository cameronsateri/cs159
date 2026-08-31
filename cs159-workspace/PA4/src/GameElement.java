/**
 * File for the GameElement abstract class.
 * 
 * @author cameron sateri
 * @version 4/3/23
 */
public abstract class GameElement implements Updatable, Drawable {
    protected Pose pose;
    protected Vector2D velocity;
    protected double radius;
    protected boolean destroyed;

    /**
     * 3 arg constructor for the GameElement abstract class.
     * 
     * @param pose The position and direction of the element.
     * @param velocity The velocity (in radians) of the element.
     * @param radius The radius of the element.
     */
    public GameElement(Pose pose, Vector2D velocity, double radius) {
        this.pose = pose;
        this.velocity = velocity;
        this.radius = radius;
        this.destroyed = false;
    }

    public Pose getPose() {
        return pose;
    }

    public Vector2D getVelocity() {
        return velocity;
    }

    public double getRadius() {
        return radius;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    /**
     * Checks the other object to determine if it is colliding with the GameElement.
     * 
     * @param other The other object to be checking the collision of.
     * @return true If it is colliding with other, false otherwise.
     */
    public boolean checkCollision(GameElement other) {
        double dx = (this.pose.getX() - other.pose.getX());
        double dy = (this.pose.getY() - other.pose.getY());
        double length = Math.sqrt((dx * dx) + (dy * dy));
        if (length <= (double) this.radius + (double) other.radius) {
            return true;
        }
        return false;
    }

    /**
     * Updates the current position of the GameElement, reapearing on the other side of the screen if it goes off the
     * edge of the screen.
     */
    public void update() {
        this.pose = this.pose.move(velocity);
        if (this.pose.getX() > GameDriver.SCREEN_WIDTH) {
            this.pose = this.pose.newX(0);
        } else if (this.pose.getX() < 0) {
            this.pose = this.pose.newX(GameDriver.SCREEN_WIDTH);
        }
        if (this.pose.getY() > GameDriver.SCREEN_HEIGHT) {
            this.pose = this.pose.newY(0);
        } else if (this.pose.getY() < 0) {
            this.pose = this.pose.newY(GameDriver.SCREEN_HEIGHT);
        }
    }
}
