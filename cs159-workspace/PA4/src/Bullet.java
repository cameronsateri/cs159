/**
 * File for the Bullet class.
 * 
 * @author cameron sateri
 * @version 4/10/23
 */
public class Bullet extends GameElement {
    public static final double BULLET_RADIUS = 1.5;
    public static final int BULLET_SPEED = 20;
    public static final int BULLET_DURATION = 20;
    private int counter;

    /**
     * 1 arg constructor for the bullet class.
     * 
     * @param pose The pose of the bullet object.
     */
    public Bullet(Pose pose) {
        super(pose, new Vector2D(pose.getHeading(), Bullet.BULLET_SPEED), Bullet.BULLET_RADIUS);
        this.counter = 0;
    }

    /**
     * Updates the current position of the Bullet object.
     */
    public void update() {
        super.update();
        this.counter++;
        if (this.counter > 20) {
            super.setDestroyed(true);
        }
    }

    @Override
    public void draw() {
        StdDraw.filledCircle(super.pose.getX(), super.pose.getY(), Bullet.BULLET_RADIUS);
    }
}
