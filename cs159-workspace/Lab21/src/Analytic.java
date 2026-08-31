/**
 * A utility class for calculating the perimeter of a square using an analytic (i.e., closed form) algorithm.
 */
public class Analytic {
    /**
     * Find the perimeter of a square that has a given area
     *
     * @param area The area of the square
     * @return The perimtere of the square
     */
    public static double findPerimeterOfSquare(double area) {
        double perimeter, width;

        width = Math.sqrt(area);
        perimeter = 4.0 * width;

        return perimeter;
    }

}