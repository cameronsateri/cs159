/**
 * Represents a position in 2D space.
 * 
 * @author stewarmc
 * @version s23
 *
 */
public class Point {
    private double x;
    private double y;

    /**
     * Constructs an instance of the Point class with the provided x and y values.
     * 
     * @param x value of this point
     * @param y value of this point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Accessor for the x value of this point.
     * 
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * Mutator for the x value of this point.
     * 
     * @param newX the x to set
     */
    public void setX(double newX) {
        this.x = newX;
    }

    /**
     * Accessor for the y value of this point.
     * 
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * Mutator for the y value of this point.
     * 
     * @param newY the y to set
     */
    public void setY(double newY) {
        this.y = newY;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Point)) {
            return false;
        }
        Point otherPoint = (Point) other;
        // sometimes we are lazy and leverage our toString when it happens to contain precisely the same fields required
        // to consider 2 instances equal, so have that version for your reference in the next comment return other
        // !=null && this.toString().equals(other.toString());
        return x == otherPoint.x && y == otherPoint.y;
    }

    @Override
    public String toString() {
        // this would totally work, but this seems like a nice opportunity to demonstrate String.format
        // return "(" + x + "," + y + ")";
        return String.format("(%.1f, %.1f)", x, y);
    }

}
