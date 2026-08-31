import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This file tests the Product class using JUNIT5.
 * 
 * @author cameron sateri
 * @version 3/3/23
 */
public class ProductTest {
    private static final String NAME = "M&Ms", TOSTRING = "Product: M&Ms Cost: 1.02 Price: 1.25.";
    private static final int COST = 102, PRICE = 90, PRICE_ADJUSTED = 125;
    private static final String DEFAULT_NAME = "Generic", DEFAULT_TOSTRING = "Product: Generic Cost: 0.25 Price: 0.50.";
    private static final int DEFAULT_COST = 25, DEFAULT_PRICE = 50;
    private Product p1, p2, p3;

    /**
     * This runs before every test in this testing file.
     */
    @BeforeEach
    void setUp() {
        p1 = new Product();
        p2 = new Product(NAME, COST, PRICE);
        p3 = new Product(NAME, 100, PRICE_ADJUSTED);
    }

    /**
     * This checks the IllegalArgumentException, and if it works or not.
     */
    @Test
    void testForIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Product(null, 25, 50));
        assertThrows(IllegalArgumentException.class, () -> new Product(NAME, -1, 50));
        assertThrows(IllegalArgumentException.class, () -> new Product(NAME, 25, -1));
    }

    /**
     * Tests the default constructors values.
     */
    @Test
    void testDefaultConstructor() {
        Product t = new Product();
        assertEquals(DEFAULT_NAME, t.getName());
        assertEquals(DEFAULT_COST, t.getCost());
        assertEquals(DEFAULT_PRICE, t.getPrice());
    }

    /**
     * Tests for accurate cost but price isn't divisible by 25.
     */
    @Test
    void testConstructorPriceAdjust() {
        Product t = new Product(NAME, COST, 105);
        assertEquals(125, t.getPrice());
    }

    /**
     * Tests constructor with already accurate values.
     */
    @Test
    void testWorkingConstructor() {
        assertEquals(NAME, p3.getName());
        assertEquals(100, p3.getCost());
        assertEquals(PRICE_ADJUSTED, p3.getPrice());
    }

    /**
     * Tests the name of the default constructor.
     */
    @Test
    void testDefaultConstructor1() {
        assertEquals(DEFAULT_NAME, p1.getName());
    }

    /**
     * Tests the cost of the default constructor.
     */
    @Test
    void testDefaultConstructor2() {
        assertEquals(DEFAULT_COST, p1.getCost());
    }

    /**
     * Tests the price of the default constructor.
     */
    @Test
    void testDefaultConstructor3() {
        assertEquals(DEFAULT_PRICE, p1.getPrice());
    }

    /**
     * Tests the 3 arg constructor.
     */
    @Test
    void testConstructor() {
        Product t = new Product(NAME, COST, PRICE);
        assertEquals(NAME, t.getName());
        assertEquals(COST, t.getCost());
        assertEquals(PRICE_ADJUSTED, t.getPrice());
    }

    /**
     * Tests the name of the constructor.
     */
    @Test
    void testConstructor1() {
        assertEquals(NAME, p2.getName());
    }

    /**
     * Tests the cost of the constructor.
     */
    @Test
    void testConstructor2() {
        assertEquals(COST, p2.getCost());
    }

    /**
     * Tests the price of the constructor.
     */
    @Test
    void testConstructor3() {
        assertEquals(PRICE_ADJUSTED, p2.getPrice());
    }

    /**
     * Test for change in Price from Price < Cost.
     */
    @Test
    void testPriceLessThanCost() {
        Product t = new Product(NAME, 100, 125);
        assertEquals(125, t.getPrice());
    }

    /**
     * Tests the default constructor's toString.
     */
    @Test
    void testDefaultToString() {
        assertEquals(DEFAULT_TOSTRING, p1.toString());
    }

    /**
     * Tests the constructors toString.
     */
    @Test
    void testToString() {
        assertEquals(TOSTRING, p2.toString());
    }
}
