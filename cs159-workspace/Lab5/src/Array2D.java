/**
 * Array2D - Utility methods for working with ragged 2d double arrays.
 * 
 * @author - YOUR NAME GOES HERE
 * @version - V1 - YOUR DATE GOES HERE
 */
public class Array2D {

    /**
     * Return true if the indicated row exists in this 2d array.
     * 
     * A row exists if:
     * <ul>
     * <li>The index is valid
     * <li>The row is not null
     * <li>The length of the row is not 0.
     * </ul>
     * 
     * @param values The two dimensional array
     * @param row The row index to check
     * @return true if the row exists in this array, false otherwise
     */
    public static boolean isRowValid(double[][] values, int row) {
        if (row >= 0 && row < values.length && values[row] != null && values[row].length > 0) {
            return true;
        }
        return false;
    }

    /**
     * Return true if the indicated column exists in this 2d array.
     * 
     * A column exists if:
     * <ul>
     * <li>The column index is non-negative
     * <li>At least one row is long enough to contain the column entry
     * </ul>
     * 
     * @param values The two dimensional array
     * @param col The column to check
     * @return true if the row exists in this array, false otherwise
     */
    public static boolean isColumnValid(double[][] values, int col) {
        if (col < 0 || values == null) {
            return false;
        }
        for (int i = 0; i < values.length; i++) {
            if (values[i] != null && col < values[i].length) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return the number of doubles stored in the array.
     * 
     * @param values The two dimensional array
     * @return The number of entries.
     */
    public static int countEntries(double[][] values) {
        // HINT: This method should -not- use a nested for loop.
        int ret = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] != null) {
                ret += values[i].length;
            }
        }
        return ret;
    }

    /**
     * Return the sum of all the values in one row of the array.
     * 
     * @param values The two dimensional array
     * @param row The index (0 based) of the row to sum
     * 
     * @return The sum of the row array elements. Returns Double.MIN_VALUE if the row is not valid.
     * 
     */
    public static double getRowTotal(double[][] values, int row) {
        if (!isRowValid(values, row)) {
            return Double.MIN_VALUE;
        }
        double ret = 0.0;
        for (double x : values[row]) {
            ret += x;
        }
        return ret;
    }

    /**
     * Return the sum of all the values in the the array.
     * 
     * @param values The two dimensional array
     * @return The sum of the array elements. Returns Double.MIN_VALUE if there are no entries in the array
     */
    public static double getTotal(double[][] values) {
        if (values == null) {
            return Double.MIN_VALUE;
        }
        double ret = 0.0;
        for (int x = 0; x < values.length; x++) {
            if (isRowValid(values, x)) {
                for (int y = 0; y < values[x].length; y++) {
                    ret = ret + values[x][y];
                }
            }
        }
        return ret;
    }

    // --------------------------------------------------------------------
    // METHODS BELOW ARE OPTIONAL. COMPLETE THEM IF YOU WANT MORE PRACTICE.
    // --------------------------------------------------------------------

    /**
     * Return the average of all the values of the array.
     * 
     * 
     * @param values The two dimensional array
     * @return The average of the array elements. Returns Double.MIN_VALUE if there are no entries in the array
     */

    public static double getAverage(double[][] values) {
        // HINT: No loops. Use the methods you implemented above.
        return 0;
    }

    /**
     * Return the sum of all the values in one column of the array.
     * 
     * @param values The two dimensional array
     * @param col The number (0 based) of the column to sum
     * 
     * @return The sum of the array elements in that column. Returns Double.MIN_VALUE if the column is not valid.
     * 
     */
    public static double getColumnTotal(double[][] values, int col) {
        return 0;
    }

    /**
     * Return the the largest value in one row of the array.
     * 
     * @param values The two dimensional array
     * @param row The number (0 based) of the row to examine
     * 
     * @return The highest of the row array elements. Returns Double.MIN_VALUE if the row does not exist.
     */
    public static double getHighestInRow(double[][] values, int row) {
        return 0;
    }

    /**
     * This method returns a new two dimensional array in which the rows and columns have been exchanged. In other
     * words, the first row from the original array will be the first column in the new array, the second row from the
     * original array will be the second column in the original array, etc. This method may only be applied to
     * rectangular arrays.
     * 
     * 
     * @param values The two dimensional array
     * 
     * @return A newly created transpose array
     */
    public static double[][] transpose(double[][] values) {
        return new double[0][0];
    }

}