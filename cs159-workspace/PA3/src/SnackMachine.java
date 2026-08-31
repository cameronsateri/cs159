import java.util.ArrayList;

/**
 * This file contains the SnackMachine class, which extends the ChangeMakingMachine class.
 * 
 * @author cameron sateri
 * @version 3/17/23
 */
public class SnackMachine extends ChangeMakingMachine {
    private ArrayList<Product> productList;

    /**
     * 1 arg constructor for the SnackMachine class, creates reference ArrayList to know what products are supposed to
     * be in which slots.
     * 
     * @param pList Reference list of products for array slots. The ArrayList itself is not a reference, only the
     * contents.
     */
    public SnackMachine(ArrayList<Product> pList) {
        super(pList.size());
        this.productList = new ArrayList<Product>();
        for (int i = 0; i < pList.size(); i++) {
            this.productList.add(new Product(pList.get(i).getName(), pList.get(i).getCost(), pList.get(i).getPrice()));
        }
        for (int i = 0; i < this.productList.size(); i++) {
            super.load(i, Slot.SLOT_SIZE, new Product(this.productList.get(i).getName(),
                    this.productList.get(i).getCost(), this.productList.get(i).getPrice()));
        }
    }

    /**
     * Loads products from the arraylist productList into slots.
     */
    public void load() {
        for (int i = 0; i < super.slots.length; i++) {
            super.load(i, Slot.SLOT_SIZE, new Product(this.productList.get(i).getName(),
                    this.productList.get(i).getCost(), this.productList.get(i).getPrice()));
        }
    }
}
