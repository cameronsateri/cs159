/**
 * A utility class for calculating the perimeter of a square using a recursive algorithm.
 */
public class Recursive {
    /**
     * Find the perimeter of a square that has a given area
     *
     * @param area The area of the square
     * @return The perimtere of the square
     */
    public static double findPerimeterOfSquare(double area) {
        double perimeter, width;

        width = Math.sqrt(area);
        perimeter = increaseBy(0.0, width, 4);

        return perimeter;
    }

    /**
     * Increase a given total by a given amount a given number of times.
     *
     * @param total The value to increase
     * @param amount The amount of the increase
     * @param times The number of times to perform the increase
     */
    private static double increaseBy(double total, double amount, int times) {
        if (times == 1) {
            return total + amount;
        } else {
            return increaseBy(total + amount, amount, times - 1);
        }
    }

}