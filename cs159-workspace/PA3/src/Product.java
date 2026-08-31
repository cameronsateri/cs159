/**
 * This file contains the Product class and its values/ methods.
 * 
 * @author cameron sateri
 * @version 3/3/23
 */
public class Product {
    public static final int ROUND_PRICE = 25;
    private String name;
    private int cost;
    private int price;

    /**
     * Default constructor for the Product class.
     */
    public Product() {
        this.name = "Generic";
        this.cost = ROUND_PRICE;
        this.price = 2 * ROUND_PRICE;
    }

    /**
     * Constructor for Product with name, cost, and price.
     * 
     * @param name The name of the product.
     * @param cost The cost of the product (in cents).
     * @param price The price of the product (in cents).
     * @throws IllegalArgumentException When name is null or price/ cost are below 0.
     */
    public Product(String name, int cost, int price) throws IllegalArgumentException {
        if (name == null || cost < 0 || price < 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.cost = cost;
        this.price = price;
        if (this.price < this.cost) {
            this.price = this.cost;
        }
        while (this.price % ROUND_PRICE != 0 || this.price == this.cost) {
            this.price++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getCost() {
        return this.cost;
    }

    public int getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "Product: " + this.name + " Cost: " + String.format("%.02f", this.cost / 100.0) + " Price: "
                + String.format("%.02f", this.price / 100.0) + ".";
    }
}
