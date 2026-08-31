import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * File for the testing Ship.
 * 
 * @author cameron sateri
 * @version 4/5/23
 */

public class ShipTest {
    private Ship ship;
    private Pose basePose;
    private Vector2D baseVelocity;

    /**
     * Base setup for all Ship tests.
     */
    @BeforeEach
    public void setup() {
        ship = new Ship();
        basePose = new Pose(GameDriver.SCREEN_WIDTH / 2, GameDriver.SCREEN_HEIGHT / 2, Math.PI / 2);
        baseVelocity = new Vector2D(Math.PI / 2, 0);
    }

    /**
     * Tests the constant SHIP_WIDTH.
     */
    @Test
    public void testConstantShipWidth() {
        assertEquals(10, Ship.SHIP_WIDTH);
    }

    /**
     * Tests the constant SHIP_HEIGHT.
     */
    @Test
    public void testConstantShipHeight() {
        assertEquals(20, Ship.SHIP_HEIGHT);
    }

    /**
     * Tests the constant SHIP_TURN.
     */
    @Test
    public void testConstantShipTurn() {
        assertEquals(0.1, Ship.SHIP_TURN);
    }

    /**
     * Tests the constant SHIP_MOVE.
     */
    @Test
    public void testConstantShipMove() {
        assertEquals(0.1, Ship.SHIP_MOVE);
    }

    /**
     * Tests the constant FRICTION.
     */
    @Test
    public void testConstantShipFriction() {
        assertEquals(0.02, Ship.FRICTION);
    }

    /**
     * Tests the position of the Ship.
     */
    @Test
    public void testShipPosition() {
        assertEquals(basePose, ship.getPose());
    }

    /**
     * Tests the velocity of the Ship.
     */
    @Test
    public void testShipVelocity() {
        assertEquals(baseVelocity, ship.getVelocity());
    }

    /**
     * Tests the Left Turn function.
     */
    @Test
    public void testShipTurnLeft() {
        ship.turnLeft();
        ship.update();
    }

    /**
     * Tests the Right Turn function.
     */
    @Test
    public void testShipTurnRight() {
        ship.turnRight();
        ship.update();
    }

    /**
     * Tests the Thrust function.
     */
    @Test
    public void testShipThrust() {
        ship.thrust();
        ship.update();
    }

    /**
     * Tests the Draw function.
     */
    @Test
    public void testShipDraw() {
        ship.draw();
    }

    /**
     * Tests overupdating Ship.
     */
    @Test
    public void testShipOverUpdating() {
        ship.thrust();
        for (int i = 0; i < 20; i++) {
            ship.update();
        }
    }
}
