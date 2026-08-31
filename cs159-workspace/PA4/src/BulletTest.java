import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * File for testing Bullet.
 * 
 * @author cameron sateri
 * @version 4/5/23
 */
public class BulletTest {
    private Bullet bullet;
    private Pose basePose;
    private Vector2D baseVelocity;

    /**
     * Base setup for all Bullet tests.
     */
    @BeforeEach
    public void setUp() {
        this.bullet = new Bullet(new Pose(GameDriver.SCREEN_WIDTH / 2, GameDriver.SCREEN_HEIGHT / 2, Math.PI / 2));
        this.basePose = new Pose(GameDriver.SCREEN_WIDTH / 2, GameDriver.SCREEN_HEIGHT / 2, Math.PI / 2);
        this.baseVelocity = new Vector2D(Math.PI / 2, Bullet.BULLET_SPEED);
    }

    /**
     * Tests the radius of Bullet.
     */
    @Test
    public void testBulletWidth() {
        assertEquals(1.5, Bullet.BULLET_RADIUS);
    }

    /**
     * Tests the velocity of Bullet.
     */
    @Test
    public void testBulletVelocity() {
        assertEquals(baseVelocity, bullet.getVelocity());
    }

    /**
     * Tests the pose of Bullet.
     */
    @Test
    public void testBulletPose() {
        assertEquals(basePose, bullet.getPose());
    }

    /**
     * Tests the destruction of Bullet.
     */
    @Test
    public void testBulletDestroyed() {
        assertEquals(false, bullet.isDestroyed());
    }

    /**
     * Tests Bullet update.
     */
    @Test
    public void testBulletUpdate() {
        bullet.update();
        assertEquals(false, bullet.isDestroyed());
    }

    /**
     * Tests Bullet updating.
     */
    @Test
    public void testBulletUpdating() {
        for (int i = 0; i < 21; i++) {
            bullet.update();
        }
        assertEquals(true, bullet.isDestroyed());
    }

    /**
     * Tests the draw function.
     */
    @Test
    public void testBulletDraw() {
        bullet.draw();
    }
}
