import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Autolab submission tests of the Point class.
 * 
 * @author 159 Instructors
 * @version 1/21/2021
 *
 */
public class PointTest {

    private Point testPoint;

    @BeforeEach
    void setUp() throws Exception {
        testPoint = new Point(5.0, 6.0);
    }

    @Test
    public void testGetX() {
        assertEquals(5.0, testPoint.getX(), .0001);
    }

    @Test
    public void testGetY() {
        assertEquals(6.0, testPoint.getY(), .0001);
    }

    @Test
    public void testSetX() {
        testPoint.setX(21.2);
        assertEquals(21.2, testPoint.getX(), .0001);
    }

    @Test
    public void testSetY() {
        testPoint.setY(19.2);
        assertEquals(19.2, testPoint.getY(), .0001);
    }

    @Test
    public void testToString() {
        assertEquals("(5.0, 6.0)", testPoint.toString());
    }

    @Test
    public void testEquals() {
        Point otherPointEqual = new Point(5.0, 6.0);
        Point p2 = new Point(6.0, 6.0);
        Point p3 = new Point(5.0, 7.0);
        assertTrue(testPoint.equals(otherPointEqual));
        assertFalse(testPoint.equals(p2));
        assertFalse(testPoint.equals(p3));
    }

    @Test
    public void testEqualsNonPoint() {
        assertFalse(testPoint.equals("hello"));
    }

}
