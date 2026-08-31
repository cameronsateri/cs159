/**
 * A driver for the ChangeMaker class
 *
 * @author Prof. David Bernstein, James Madison Unversity
 * @version 1.0
 */
public class ChangeMakerDriver {
    /**
     * The entry point
     *
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        ChangeMaker cashier;
        int amount, numCoins;
        int[] coins;

        coins = new int[4]; // Kinds of coins
        coins[0] = 1;
        coins[1] = 5;
        coins[2] = 8;
        coins[3] = 10;

        amount = Integer.parseInt(args[0]);

        cashier = new ChangeMaker();

        numCoins = cashier.change(coins, amount);

        System.out.println("Coins needed for " + amount + " cents: " + numCoins);
    }

}