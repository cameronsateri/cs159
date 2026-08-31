import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This file tests the Slot class using JUNIT5.
 * 
 * @author cameron sateri
 * @version 3/3/23
 */
public class SlotTest {
    private static final String NAME = "M&Ms";
    private static final int COST = 102, PRICE = 125, FULL_SLOT = 10;
    private static final String TOSTRING = "SlotCount: 10 of\n" + "Product: M&Ms Cost: 1.02 Price: 1.25.\n"
            + "Product: M&Ms Cost: 1.02 Price: 1.25.\n" + "Product: M&Ms Cost: 1.02 Price: 1.25.\n"
            + "Product: M&Ms Cost: 1.02 Price: 1.25.\n" + "Product: M&Ms Cost: 1.02 Price: 1.25.\n"
            + "Product: M&Ms Cost: 1.02 Price: 1.25.\n" + "Product: M&Ms Cost: 1.02 Price: 1.25.\n"
            + "Product: M&Ms Cost: 1.02 Price: 1.25.\n" + "Product: M&Ms Cost: 1.02 Price: 1.25.\n"
            + "Product: M&Ms Cost: 1.02 Price: 1.25.\n";
    private static final String DEFAULT_TOSTRING = "SlotCount: 0 of\n";
    private Product p;
    private Slot s1, s2;

    /**
     * This runs before every test in this testing file.
     */
    @BeforeEach
    void setUp() {
        p = new Product(NAME, COST, PRICE);
        s1 = new Slot();
        s2 = new Slot(p);
    }

    /**
     * Tries to load products into a fully empty Slot.
     */
    @Test
    void testFullyLoadEmptySlot() {
        assertEquals(FULL_SLOT, s1.load(p));
    }

    /**
     * Tries to load products into a filled Slot.
     */
    @Test
    void testFullyLoadFullSlot() {
        assertEquals(0, s2.load(p));
    }

    /**
     * Tries to load 5 products into an empty Slot.
     */
    @Test
    void testPartialLoadEmptySlot() {
        assertEquals(5, s1.load(p, 5));
    }

    /**
     * Tries to load 5 products into a filled Slot.
     */
    @Test
    void testPartialLoadFullSlot() {
        assertEquals(0, s2.load(p, 5));
    }

    /**
     * Tries to find the next product in an empty Slot.
     */
    @Test
    void testNextProductEmptySlot() {
        assertEquals(null, s1.nextProduct());
    }

    /**
     * Tries to find the next product in a filled Slot.
     */
    @Test
    void testNextProductFullSlot() {
        assertEquals(NAME, s2.nextProduct().getName());
        assertEquals(COST, s2.nextProduct().getCost());
        assertEquals(PRICE, s2.nextProduct().getPrice());
    }

    /**
     * Tries to buy all products from an empty Slot.
     */
    @Test
    void testBuyEmptySlot() {
        for (int i = 0; i < FULL_SLOT; i++) {
            assertEquals(null, s1.buyOne());
        }
    }

    /**
     * Tries to buy all products from a filled Slot.
     */
    @Test
    void testBuyProductFullSlot() {
        for (int i = 0; i < FULL_SLOT; i++) {
            Product test = s2.buyOne();
            assertEquals(NAME, test.getName());
            assertEquals(COST, test.getCost());
            assertEquals(PRICE, test.getPrice());
        }
    }

    /**
     * Tests the toString of an empty Slot.
     */
    @Test
    void testToStringEmpty() {
        assertEquals(DEFAULT_TOSTRING, s1.toString());
    }

    /**
     * Tests the toString of a filled Slot.
     */
    @Test
    void testToStringFull() {
        assertEquals(TOSTRING, s2.toString());
    }
}
