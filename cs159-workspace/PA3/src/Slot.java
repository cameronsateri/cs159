import java.util.ArrayList;

/**
 * This file contains the Slot class and its values/ methods.
 * 
 * @author cameron sateri
 * @version 3/3/23
 */

public class Slot {
    public static final int SLOT_SIZE = 10;
    private ArrayList<Product> products;

    /**
     * Default constructor for the Slot class.
     */
    public Slot() {
        this.products = new ArrayList<Product>();
    }

    /**
     * Constructor of the Slot class with all 10 slots filled with product.
     * 
     * @param product The product to fill the Slot object with.
     */
    public Slot(Product product) {
        this.products = new ArrayList<Product>();
        for (int i = 0; i < SLOT_SIZE; i++) {
            this.products.add(new Product(product.getName(), product.getCost(), product.getPrice()));
        }
    }

    /**
     * Loads the designated product into all spots in the Slot object.
     * 
     * @param product The product to fill the Slot object with.
     * @return The amount of Slots that were filled with product.
     */
    public int load(Product product) {
        int counter = 0;
        for (int i = products.size(); i < SLOT_SIZE; i++) {
            this.products.add(i, new Product(product.getName(), product.getCost(), product.getPrice()));
            counter++;
        }
        return counter;
    }

    /**
     * Loads the designated product into spots in the Slot object.
     * 
     * @param product The product to fill in the Slot object count number of times.
     * @param count The max number of products to put in the Slot object.
     * @return The amount of Slots that were filled with product (return <= count).
     */
    public int load(Product product, int count) {
        int counter = 0;
        while (counter != count && this.products.size() < SLOT_SIZE) {
            this.products.add(new Product(product.getName(), product.getCost(), product.getPrice()));
            counter++;
        }
        return counter;
    }

    /**
     * Returns the next available product in the Slot object.
     * 
     * @return Next available product, or null if empty.
     */
    public Product nextProduct() {
        if (this.products.size() == 0 || this.products.get(0) == null) {
            return null;
        }
        return this.products.get(0);
    }

    /**
     * Takes one product from the Slot object and returns it to the user.
     * 
     * @return product removed from Slot object.
     */
    public Product buyOne() {
        if (this.products.size() == 0 || this.products.get(0) == null) {
            return null;
        }
        return this.products.remove(0);
    }

    @Override
    public String toString() {
        String slot = "SlotCount: " + this.products.size() + " of\n";
        for (int i = 0; i < this.products.size(); i++) {
            slot += this.products.get(i).toString() + "\n";
        }
        return slot;
    }
}
