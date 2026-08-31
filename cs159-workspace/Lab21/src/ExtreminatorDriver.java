/**
 * A driver for the Extreminator class
 *
 * @author Prof. David Bernstein, James Madison University
 * @version 1.0
 */
public class ExtreminatorDriver {
    /**
     * The entry point
     *
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        Extreminator calc;
        int answer;
        int[] data = { 10, 8, 22, 58, 6, 75, 11 };

        calc = new Extreminator();

        answer = calc.findInf(data);
        System.out.println("The answer is: " + answer);
    }
}