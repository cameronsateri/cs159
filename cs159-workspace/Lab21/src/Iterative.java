/**
 * A utility class for calculating the perimeter of a square using an iterative algorithm.
 */
public class Iterative {
    /**
     * Find the perimeter of a square that has a given area
     *
     * @param area The area of the square
     * @return The perimtere of the square
     */
    public static double findPerimeterOfSquare(double area) {
        double perimeter, width;

        width = Math.sqrt(area);

        perimeter = 0.0;
        for (int i = 0; i < 4; i++) {
            perimeter += width;
        }

        return perimeter;
    }

}