/**
 * File for the Asteroid class.
 * 
 * @author cameron sateri
 * @version 4/14/23
 */
public class Asteroid extends Enemy {
    public static final int ASTEROID_SPEED = 1;

    /**
     * 1 arg constructor for the Asteroid class.
     * 
     * @param size The AsteroidSize enum object to base the Asteroid object on.
     */
    public Asteroid(AsteroidSize size) {
        super(Asteroid.ASTEROID_SPEED, size.getRadius(), size.getPoints());
    }

    @Override
    public void draw() {
        StdDraw.circle(super.pose.getX(), super.pose.getY(), super.radius);
    }
}
