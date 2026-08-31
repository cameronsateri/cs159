/**
 * File for the Ship class.
 * 
 * @author cameron sateri
 * @version 4/10/23
 */
public class Ship extends GameElement {
    public static final int SHIP_WIDTH = 10;
    public static final int SHIP_HEIGHT = 20;
    public static final double SHIP_TURN = 0.1;
    public static final double SHIP_MOVE = 0.1;
    public static final double FRICTION = 0.02;

    /**
     * No arg constructor for the Ship class.
     */
    public Ship() {
        super(new Pose(GameDriver.SCREEN_WIDTH / 2.0, GameDriver.SCREEN_HEIGHT / 2.0, Math.PI / 2),
                new Vector2D(Math.PI / 2, 0), Ship.SHIP_HEIGHT / 2.0);
    }

    /**
     * Turns the ship left by SHIP_TURN.
     */
    public void turnLeft() {
        this.pose = this.pose.newHeading(this.pose.getHeading() + Ship.SHIP_TURN);
    }

    /**
     * Turns the ship right by SHIP_TURN.
     */
    public void turnRight() {
        this.pose = this.pose.newHeading(this.pose.getHeading() - Ship.SHIP_TURN);
    }

    /**
     * Moves the ship forward with SHIP_MOVE. Updates the heading.
     */
    public void thrust() {
        this.velocity = this.velocity.add(new Vector2D(this.pose.getHeading(), Ship.SHIP_MOVE));
    }

    /**
     * Updates the position of Ship based on velocity and thrust.
     */
    public void update() {
        super.update();
        if (this.velocity.getMagnitude() > Ship.FRICTION) {
            this.velocity = this.velocity.newMagnitude(this.velocity.getMagnitude() - Ship.FRICTION);
            if (this.velocity.getMagnitude() < Ship.FRICTION) {
                this.velocity = this.velocity.newMagnitude(0);
            }
        }
    }

    @Override
    public void draw() {
        GameUtils.drawPoseAsTriangle(this.getPose(), Ship.SHIP_WIDTH, Ship.SHIP_HEIGHT);
    }
}
