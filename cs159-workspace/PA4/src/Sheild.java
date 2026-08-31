import java.awt.Color;

/**
 * File for the Sheild class.
 * 
 * @author cameron sater8
 * @version idgaf
 */
public class Sheild extends GameElement {

    public static final int SHEILD_RADIUS = Ship.SHIP_HEIGHT;
    private Color color;
    private int colorCounter;

    /**
     * 1 arg constructor for the Sheild.
     * 
     * @param pose The position of the sheild in relation to the ship.
     * @param velocity The velocity of the ship from the ship.
     */
    public Sheild(Pose pose, Vector2D velocity) {
        super(pose, velocity, Sheild.SHEILD_RADIUS);
        this.colorCounter = 1;
        this.color = Color.red;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public void draw() {
        switch (colorCounter) {
            case 1:
                StdDraw.setPenColor(Color.red);
                break;
            case 2:
                StdDraw.setPenColor(Color.orange);
                break;
            case 3:
                StdDraw.setPenColor(Color.yellow);
                break;
            case 4:
                StdDraw.setPenColor(Color.green);
                break;
            case 5:
                StdDraw.setPenColor(Color.blue);
                break;
            case 6:
                StdDraw.setPenColor(Color.magenta);
                break;
        }
        StdDraw.circle(pose.getX(), pose.getY(), radius);
    }

    @Override
    public void update() {
        super.update();
        this.colorCounter++;
        if (this.colorCounter > 6) {
            this.colorCounter = 1;
        }
    }

    /**
     * The position of the Sheild in correlation with the ships pose and velocity.
     * 
     * @param ship The ship to bring the sheild to.
     */
    public void shipPos(Ship ship) {
        this.pose = ship.getPose();
        this.velocity = ship.getVelocity();
    }

}
