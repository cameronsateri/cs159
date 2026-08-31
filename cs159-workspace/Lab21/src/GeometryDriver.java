/**
 * An application that uses the Analytic, Iterative, and Recursive classes
 */
public class GeometryDriver {
    /**
     * The entry point of the application
     *
     * @param args The areas of interest
     */
    public static void main(String[] args) {
        double area, perimeter;

        for (int i = 0; i < args.length; i++) {
            try {
                area = Double.parseDouble(args[i]);
                perimeter = Recursive.findPerimeterOfSquare(area);

                System.out.println("A square with area " + area + " has a perimeter of " + perimeter);
            } catch (NumberFormatException nfe) {
                System.out.println(args[i] + " is not a valid area.");
            }
        }
    }
}