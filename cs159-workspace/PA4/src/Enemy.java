/**
 * File for the Enemy abstract class.
 * 
 * @author cameron sateri
 * @version 4//23
 */
public abstract class Enemy extends GameElement {
    protected int points;

    /**
     * 3 arg constructor for the Enemy abstract class.
     * 
     * @param speed The speed of enemy.
     * @param radius The radius (size) of the enemy.
     * @param points The points (score) of the enemy.
     */
    public Enemy(double speed, double radius, int points) {
        super(new Pose(AsteroidsGame.randomXPosition(), AsteroidsGame.randomYPosition(), AsteroidsGame.randomHeading()),
                new Vector2D(AsteroidsGame.randomHeading(), speed), radius);
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
}
