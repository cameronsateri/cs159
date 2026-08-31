/**
 * This class is designed to illustrate the use of the Point and PointDisplay
 * classes.
 * 
 * @author Nathan Sprague
 * @version 1/19/21
 * 
 */
public class PointDemo {

    /**
     * Create several points and apply illustrate how they may be processed and
     * displayed.
     * 
     * @param args not used.
     */
    public static void main(String[] args) {

        Point[] points = new Point[4];
        double tmp;

        points[0] = new Point(30, 30);
        points[1] = new Point(30, 180);
        points[2] = new Point(80, 30);
        points[3] = new Point(80, 180);

        new PointDisplay(points, "Points on a rectangle!");

        // Now swap all x and y coordinates
        for (int i = 0; i < points.length; i++) {
            tmp = points[i].getX();
            points[i].setX(points[i].getY());
            points[i].setY(tmp);

        }
        new PointDisplay(points, "Flipped rectangle!");
    }

}
