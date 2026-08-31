/**
 * This file contains the ChangeMakingMachine class, which extends the VendingMachine class.
 * 
 * @author cameron sateri
 * @version 3/17/23
 */
public class ChangeMakingMachine extends VendingMachine {
    /**
     * Default constructor for the ChangeMakingMachine class, creates empty array with the length of DEFAULT_SIZE.
     */
    public ChangeMakingMachine() {
        super();
    }

    /**
     * 1 arg constructor for the ChangeMakingMachine class, creates empty array with the length of paramater size.
     * 
     * @param size this is the size of the slots array.
     */
    public ChangeMakingMachine(int size) {
        super(size);
    }

    /**
     * 2 arg constructor for the ChangeMakingMachine class, fills the slots array with parameter product and sets the
     * slots array length to parameter size.
     * 
     * @param size The size of the slots array.
     * @param product The predetermiend contents of all product objects in all slot objects in slots.
     */
    public ChangeMakingMachine(int size, Product product) {
        super(size, product);
    }

    /**
     * Attempts to purchase one product from slots at parameter slotNum by determining there is enough money from
     * parameter quarters and parameter dollars to pay for the product.
     * 
     * @param slotNum The location in slots that will have their next product purchased.
     * @param quarters The amount of quarters to pay for the product.
     * @param dollars The amount of dollars to pay for the product.
     * @return -1 if there isn't enough money for the product, otherwise returns the change.
     * @throws IllegalArgumentException If the parameters are out of bounds with the array slots or if paramater
     * quarters or parameter dollars are below 0.
     */
    public int buy(int slotNum, int quarters, int dollars) throws IllegalArgumentException {
        if (slotNum >= super.slots.length || slotNum < 0 || quarters < 0 || dollars < 0) {
            throw new IllegalArgumentException();
        }
        int value = (quarters * 25) + (dollars * 100);
        if (super.slots[slotNum].nextProduct().getPrice() > value) {
            return -1;
        }
        Product p = super.slots[slotNum].buyOne();
        super.machineProfit += p.getPrice();
        VendingMachine.totalProfit += p.getPrice();
        return value - p.getPrice();
    }
}
