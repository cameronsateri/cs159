/**
 * File for the AsteroidSize enum.
 * 
 * @author cameron sateri
 * @version 4//23
 */
public enum AsteroidSize {
    SMALL(10, 200), MEDIUM(20, 100), LARGE(30, 50);

    private int radius;
    private int points;

    /**
     * 2 arg constructor for the AsteroidSize enum.
     * 
     * @param radius The radius of the asteroid.
     * @param points The points (score) of the asteroid.
     */
    private AsteroidSize(int radius, int points) {
        this.radius = radius;
        this.points = points;
    }

    public int getRadius() {
        return this.radius;
    }

    public int getPoints() {
        return this.points;
    }

    /**
     * Returns one of the AsteroidSize enums. 25% chance for small and medium, 50% for large.
     * 
     * @return One of the 3 AsteroidSize enums.
     */
    public static AsteroidSize randomSize() {
        int random = (int) (Math.random() * 4) + 1;
        switch (random) {
            case 1:
                return AsteroidSize.SMALL;
            case 2:
                return AsteroidSize.MEDIUM;
            default:
                return AsteroidSize.LARGE;
        }
    }
}
