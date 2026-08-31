import java.awt.Color;
import java.util.ArrayList;

/**
 * Main class for Asteroids.
 * 
 * @author CS159 Instructors
 * @version s23
 */
public class AsteroidsGame implements Playable {

    public static final int LIVES = 3;

    private ArrayList<Drawable> drawElements;
    private ArrayList<Updatable> updateElements;
    private ArrayList<GameElement> shipAndBullets;
    private ArrayList<Enemy> enemies;

    private Ship ship;

    private NumericDisplay score;
    private NumericDisplay lives;

    private Sheild sheild;

    /**
     * Constructs all game elements.
     */
    public AsteroidsGame() {
        StdDraw.setTitle("Generic Space Rock Shooter");

        drawElements = new ArrayList<>();
        updateElements = new ArrayList<>();
        shipAndBullets = new ArrayList<>();
        enemies = new ArrayList<>();

        // add background elements
        final int TOP = GameDriver.SCREEN_HEIGHT;
        score = new NumericDisplay(10, TOP - 20, "Score: ", 0);
        lives = new NumericDisplay(10, TOP - 40, "Lives: ", 3);
        drawElements.add(score);
        drawElements.add(lives);
        // TODO
    }

    /**
     * Adds an enemy to the board.
     * 
     * @param enemy The given enemy to add.
     */
    public void addEnemy(Enemy enemy) {
        this.enemies.add(enemy);
        this.drawElements.add(enemy);
        this.updateElements.add(enemy);
    }

    /**
     * Creates and adds 100 stars with random locations.
     */
    private void newStars() {
        for (int i = 0; i < 100; i++) {
            Star star = new Star(randomXPosition(), randomYPosition());
            drawElements.add(star);
        }
    }

    /**
     * Creates and adds a new enemy to the borad.
     */
    private void newEnemies() {
        for (int i = 0; i < 10; i++) {
            addEnemy(new Asteroid(AsteroidSize.randomSize()));
        }
    }

    /**
     * Creates a new ship object in shipAndBullets, drawElements and updateElements.
     */
    private void newShip() {
        this.ship = new Ship();
        this.updateElements.add(ship);
        this.drawElements.add(ship);
        this.shipAndBullets.add(0, ship);
    }

    /**
     * Creates a sheild to protect the ship.
     */
    private void newSheild() {
        this.sheild = new Sheild(this.ship.getPose(), this.ship.getVelocity());
        this.updateElements.add(sheild);
        this.drawElements.add(sheild);
        this.shipAndBullets.add(0, sheild);
    }

    /**
     * Handles all collisions on the board.
     */
    private void handleCollisions() {
        for (GameElement i : this.shipAndBullets) {
            for (Enemy j : this.enemies) {
                if (i.checkCollision(j)) {
                    i.setDestroyed(true);
                    j.setDestroyed(true);
                }
            }
        }
        if (this.ship.isDestroyed()) {
            this.lives.setValue(this.lives.getValue() - 1);
            this.drawElements.remove(this.ship);
            this.updateElements.remove(this.ship);
            this.shipAndBullets.remove(this.ship);
            this.ship = null;
            newShip();
        }
    }

    /**
     * Removes bullets that have been deployed for 20 updates.
     */
    private void removeDestroyedBullets() {
        for (int i = 1; i < this.shipAndBullets.size(); i++) {
            if (this.shipAndBullets.get(i).isDestroyed()) {
                this.updateElements.remove(this.shipAndBullets.get(i));
                this.drawElements.remove(this.shipAndBullets.get(i));
                this.shipAndBullets.remove(this.shipAndBullets.get(i));
            }
        }
    }

    /**
     * Removes enemies that are destroyed.
     */
    private void removeDestroyedEnemies() {
        for (int i = 0; i < this.enemies.size(); i++) {
            if (this.enemies.get(i).isDestroyed()) {
                this.score.setValue(this.score.getValue() + this.enemies.get(i).getPoints());
                this.updateElements.remove(this.enemies.get(i));
                this.drawElements.remove(this.enemies.get(i));
                this.enemies.remove(this.enemies.get(i));
            }
        }
    }

    /**
     * Starts a new game with 10 asteroids.
     */
    public void startGame() {
        newStars();
        newShip();
        // newSheild();
        newEnemies();
    }

    /**
     * Handle keyboard input from the game and move the ship and shoot bullets if the corresponding keys are pressed.
     */
    private void handleKeyboardInput() {
        if (GameDriver.spacePressed()) {
            Bullet bullet = new Bullet(this.ship.getPose());
            this.updateElements.add(bullet);
            this.drawElements.add(bullet);
            this.shipAndBullets.add(bullet);
        }

        if (GameDriver.leftPressed()) {
            this.ship.turnLeft();
        }

        if (GameDriver.rightPressed()) {
            this.ship.turnRight();
        }

        if (GameDriver.upPressed()) {
            this.ship.thrust();
        }
    }

    @Override
    public void update() {
        // freeze simulation if game is over
        if (lives.getValue() <= 0) {
            return;
        }

        // this.sheild.shipPos(ship);

        // update everything (including newest bullet)
        handleKeyboardInput();
        for (Updatable item : updateElements) {
            item.update();
        }

        // TODO You will need these in Part 3
        handleCollisions();
        removeDestroyedBullets();
        removeDestroyedEnemies();

        // TODO Put your code here
        if (Math.random() <= Saucer.SPAWN_PROB) {
            Saucer saucer = new Saucer();
            addEnemy(saucer);
        }
        if (this.enemies.size() == 0) {
            newEnemies();
        }
    }

    @Override
    public void draw() {
        for (Drawable item : drawElements) {
            StdDraw.setPenColor(Color.WHITE);
            item.draw();
        }
    }

    /**
     * Generates a random X position on the screen.
     * 
     * @return the x position
     */
    protected static double randomXPosition() {
        return GameDriver.GENERATOR.nextDouble() * GameDriver.SCREEN_WIDTH;
    }

    /**
     * Generates a random Y position on the screen.
     * 
     * @return the y position
     */
    protected static double randomYPosition() {
        return GameDriver.GENERATOR.nextDouble() * GameDriver.SCREEN_HEIGHT;
    }

    /**
     * Generates a random heading from the interval [0, 2*PI).
     * 
     * @return the heading
     */
    protected static double randomHeading() {
        return GameDriver.GENERATOR.nextDouble() * 2 * Math.PI;
    }

    private void sheild() {

    }

}
