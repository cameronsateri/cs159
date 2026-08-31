/**
 * This file contains the DrinkMachine class, which extends the VendingMachine class.
 * 
 * @author cameron sateri
 * @version 3/17/23
 */
public class DrinkMachine extends VendingMachine {
    public static final int COOLING_CHARGE = 10;

    /**
     * Default constructor for the DrinkMachine class, creates empty array with the length of DEFAULT_SIZE.
     */
    public DrinkMachine() {
        super();
    }

    /**
     * 2 arg constructor for the DrinkMachine class, fills the slots array with parameter product and sets the array
     * slots length to parameter size.
     * 
     * @param size The size of the slots array.
     * @param product The predetermiend contents of all product objects in all slot objects in slots.
     */
    public DrinkMachine(int size, Product product) {
        super(size, product);
    }

    /**
     * Purchases one product from slots at parameter slotNum, and retreives profit minus COOLING_CHARGE.
     * 
     * @param slotNum The location in slots that will have their next product purchased.
     * @return If there is or if there isn't a product purchased in slots at parameter slotNum.
     * @throws IllegalArgumentException If the parameters are out of bounds with the array slots.
     */
    public boolean buy(int slotNum) throws IllegalArgumentException {
        if (slotNum >= super.slots.length || slotNum < 0) {
            throw new IllegalArgumentException();
        } else if (super.slots[slotNum].nextProduct() == null) {
            return false;
        }
        Product p = super.slots[slotNum].buyOne();
        super.machineProfit += p.getPrice() - COOLING_CHARGE;
        VendingMachine.totalProfit += p.getPrice() - COOLING_CHARGE;
        return true;
    }
}
