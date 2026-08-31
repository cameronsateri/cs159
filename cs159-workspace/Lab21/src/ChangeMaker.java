/**
 * A class that uses recursion to make change
 *
 * @author Prof. David Bernstein, James Madison Unversity
 * @verions 1.0
 */
public class ChangeMaker {

    /**
     * Determine the minimum number of coins needed to make change
     *
     * @param coins The array of coin values
     * @param amount The amount of change
     *
     * @returns The number of coins
     */
    public int change(int[] coins, int amount) {
        int i, j, min, number;

        min = amount;

        // If we can make change with one coin then we are done
        //
        for (i = 0; i < coins.length; i++) {

            if (coins[i] == amount)
                return 1; // The base case
        }

        // Refine the solution
        //
        for (j = 1; j <= (amount / 2); j++) {

            number = change(coins, j) + change(coins, amount - j);
            if (number < min)
                min = number;
        }

        return min;
    }

}
