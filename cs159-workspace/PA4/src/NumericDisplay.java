/**
 * File for the NumericDisplay class.
 * 
 * @author cameron sateri
 * @version 4/3/23
 */
public class NumericDisplay implements Drawable {
    private String prefix;
    private int value;
    private Point location;

    /**
     * 4 arg constructor for the NumericDisplay class.
     * 
     * @param xPos the x-posotion of the display.
     * @param yPos the y-position of the display.
     * @param prefix the phrase preceding the following information.
     * @param value the value being stored in the display.
     */
    public NumericDisplay(int xPos, int yPos, String prefix, int value) {
        this.location = new Point(xPos, yPos);
        this.value = value;
        this.prefix = prefix;
    }

    public Point getLocation() {
        return this.location;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Draws the NumericDisplay object at X & Y.
     */
    public void draw() {
        StdDraw.textLeft(location.getX(), location.getY(), prefix + value);
    }
}
