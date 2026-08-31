import java.util.Collections;
import java.util.Random;

/**
 * This file contains the SortedAisle class, which extends Aisle.
 * 
 * @author cameron sateri
 * @version 3/24/23
 */
public class SortedAisle extends Aisle {
    /**
     * 1 arg constructor that extends from Aisle.
     * 
     * @param random A random generator.
     */
    public SortedAisle(Random random) {
        super(random);
    }

    /**
     * Adds a customer to the line and sorts the line from least items to most.
     * 
     * @param customer The next customer to add.
     */
    public void addCustomer(Customer customer) {
        super.addCustomer(customer);
        Collections.sort(line);
    }
}
