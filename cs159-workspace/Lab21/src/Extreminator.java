/**
 * Finds extremal elements in an array
 *
 * @author Prof. David Bernstein, James Madison University
 * @version 1.0
 */
public class Extreminator {
    /**
     * Find the infimum
     *
     * @param values The array of values to search
     */
    public int findInf(int[] values) {
        int inf;

        inf = findInf(values, 0, Integer.MAX_VALUE);

        return inf;
    }

    /**
     * The recursive function that does all of the work involved in finding an infimum
     *
     * @param values The array of values to search
     * @param startIndex The index to begin ths search
     * @param soFar The best value found so far
     */
    private int findInf(int[] values, int startIndex, int soFar) {
        if (startIndex >= values.length) {
            // The base case -- don't change soFar
        } else {
            // Refinement -- start at the next index
            if (values[startIndex] < soFar) {
                soFar = values[startIndex];
            }

            soFar = findInf(values, startIndex + 1, soFar);
        }

        return soFar;
    }

}