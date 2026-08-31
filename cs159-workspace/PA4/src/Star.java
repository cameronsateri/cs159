/**
 * File for the Star class.
 * 
 * @author cameron sateri
 * @version 4/3/23
 */
public class Star implements Drawable {
    public static final int STAR_RADIUS = 1;
    private Point location;

    /**
     * 2 arg constructor for the Star class.
     * 
     * @param x the x-point that the star will be.
     * @param y the y-point that the star will be.
     */
    public Star(double x, double y) {
        this.location = new Point(x, y);
    }

    public Point getLocation() {
        return this.location;
    }

    /**
     * Draws the star object at location with a radius of 1.
     */
    public void draw() {
        StdDraw.filledCircle(location.getX(), location.getY(), STAR_RADIUS);
    }
}
