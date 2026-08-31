/**
 * This file contains the VendingMachine class.
 * 
 * @author cameron sateri
 * @version 3/17/23
 */
public class VendingMachine {
    public static final int DEFAULT_SIZE = 15;
    protected static int totalProfit = 0;
    protected int machineProfit;
    protected Slot[] slots;

    /**
     * Default constructor for the VendingMachine class, creates empty array with the length of DEFAULT_SIZE.
     */
    public VendingMachine() {
        this.machineProfit = 0;
        this.slots = new Slot[DEFAULT_SIZE];
        for (int i = 0; i < this.slots.length; i++) {
            this.slots[i] = new Slot();
        }
    }

    /**
     * 1 arg constructor for the VendingMachine class, creates empty array with the length of paramater size.
     * 
     * @param size this is the size of the slots array.
     */
    public VendingMachine(int size) {
        this.machineProfit = 0;
        this.slots = new Slot[size];
        for (int i = 0; i < this.slots.length; i++) {
            this.slots[i] = new Slot();
        }
    }

    /**
     * 2 arg constructor for the VendingMachine class, fills the slots array with parameter product and sets the slots
     * array length to parameter size.
     * 
     * @param size The size of the slots array.
     * @param product The predetermiend contents of all product objects in all slot objects in slots.
     */
    public VendingMachine(int size, Product product) {
        this.machineProfit = 0;
        this.slots = new Slot[size];
        for (int i = 0; i < slots.length; i++) {
            slots[i] = new Slot(product);
            this.machineProfit -= product.getCost() * Slot.SLOT_SIZE;
            VendingMachine.totalProfit -= product.getCost() * Slot.SLOT_SIZE;
        }
    }

    /**
     * Loads all of the slot objects in the slots array, gives the contents of the slots generic product values.
     */
    public void load() {
        Product toLoad = new Product();
        for (int i = 0; i < slots.length; i++) {
            int numLoaded = this.slots[i].load(toLoad);
            this.machineProfit -= toLoad.getCost() * numLoaded;
            VendingMachine.totalProfit -= toLoad.getCost() * numLoaded;
        }
    }

    /**
     * Loads paramater product into the slots array at parameter slotNum a total of pamater count number of times.
     * 
     * @param slotNum The slot number that must be loaded.
     * @param count The number of products maximum to be filled into the slot at slotNum.
     * @param product The product to be filling the slot at slotNum.
     * @throws IllegalArgumentException If parameter slotNum is larger than slots.length, parameter count is less than
     * or equal to 0, or if parameter product is null.
     */
    public void load(int slotNum, int count, Product product) throws IllegalArgumentException {
        if (slotNum > this.slots.length || count <= 0 || product == null) {
            throw new IllegalArgumentException();
        }
        int numLoaded = slots[slotNum].load(product, count);
        this.machineProfit -= product.getCost() * numLoaded;
        VendingMachine.totalProfit -= product.getCost() * numLoaded;
    }

    /**
     * Retreives the next product in slots at parameter slotNum.
     * 
     * @param slotNum The location in slots that will have their next product returned.
     * @return The next product in slots at parameter slotNum.
     * @throws IllegalArgumentException If the parameters are out of bounds with the array slots.
     */
    public Product nextProduct(int slotNum) throws IllegalArgumentException {
        if (slotNum >= this.slots.length || slotNum < 0) {
            throw new IllegalArgumentException();
        } else if (this.slots[slotNum].nextProduct() == null) {
            return null;
        }
        return this.slots[slotNum].nextProduct();
    }

    /**
     * Purchases one product from slots at parameter slotNum, and retreives profit.
     * 
     * @param slotNum The location in slots that will have their next product purchased.
     * @return If there is or if there isn't a product purchased in slots at parameter slotNum.
     * @throws IllegalArgumentException If the parameters are out of bounds with the array slots.
     */
    public boolean buy(int slotNum) throws IllegalArgumentException {
        if (slotNum >= this.slots.length || slotNum < 0) {
            throw new IllegalArgumentException();
        } else if (this.slots[slotNum].nextProduct() == null) {
            return false;
        }
        Product p = this.slots[slotNum].buyOne();
        this.machineProfit += p.getPrice();
        VendingMachine.totalProfit += p.getPrice();
        return true;
    }

    public int getSlotCount() {
        return this.slots.length;
    }

    public static int getTotalProfit() {
        return VendingMachine.totalProfit;
    }

    /**
     * Resets the total profit earned across all VendingMachine objects.
     */
    public static void resetTotalProfit() {
        VendingMachine.totalProfit = 0;
    }

    public int getMachineProfit() {
        return this.machineProfit;
    }

    @Override
    public String toString() {
        String vm = "Vending Machine\n";
        for (int i = 0; i < this.slots.length; i++) {
            vm += this.slots[i].toString();
        }
        return vm + "Total Profit: " + String.format("%.02f", VendingMachine.totalProfit / 100.0) + " Machine Profit: "
                + String.format("%.02f", this.machineProfit / 100.0) + ".";
    }
}
