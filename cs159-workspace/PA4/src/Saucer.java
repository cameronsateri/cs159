/**
 * File for the Saucer class.
 * 
 * @author cameron sateri
 * @version 4/14/23
 */
public class Saucer extends Enemy {
    public static final int HALF_WIDTH = 10;
    public static final int HALF_HEIGHT = 5;
    public static final int SAUCER_SPEED = 2;
    public static final int SAUCER_POINTS = 400;
    public static final double SPAWN_PROB = 0.002;
    public static final double TURN_PROB = 0.05;

    /**
     * 0 arg constructor for the Saucer class.
     */
    public Saucer() {
        super(Saucer.SAUCER_SPEED, Saucer.HALF_WIDTH, Saucer.SAUCER_POINTS);
    }

    @Override
    public void draw() {
        StdDraw.rectangle(super.pose.getX(), super.pose.getY(), Saucer.HALF_WIDTH, Saucer.HALF_HEIGHT);
    }

    @Override
    public void update() {
        super.pose = super.pose.move(velocity);
        if (super.pose.getX() <= 0 || super.pose.getX() >= GameDriver.SCREEN_WIDTH || super.pose.getY() <= 0
                || super.pose.getY() >= GameDriver.SCREEN_HEIGHT) {
            super.points = 0;
            super.destroyed = true;
        }
        if (Math.random() <= Saucer.TURN_PROB) {
            super.pose = super.pose.newHeading(AsteroidsGame.randomHeading());
            super.velocity = super.velocity.newHeading(super.pose.getHeading());
        }
    }
}