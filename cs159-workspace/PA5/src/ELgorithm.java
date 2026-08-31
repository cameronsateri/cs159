import java.awt.Point;

/**
 * File for the ELgorithm class.
 * 
 * @author cameron sateri with mason puckett
 * @version 4/21/23
 */
public class ELgorithm {
    private Sensor sensor;

    /**
     * 1 arg constructor for the ELgorithm class.
     * 
     * @param sensor The sensor to be used.
     */
    public ELgorithm(Sensor sensor) {
        this.sensor = sensor;
    }

    /**
     * Indicate a search in a designated area.
     * 
     * @param x The x coordinate to begin searching at.
     * @param y The y coordinate to begin searching at.
     * @param width The width of the serach.
     * @return The location of the
     */
    public Point search(int x, int y, int width) {
        int searchResult = sensor.scan(x, y, width);
        if (searchResult < 0) {
            return null;
        } else if (width == 1) {
            return new Point(x, y);
        } else {
            Point[] quad = { search(x, y, width / 2), search(x + width / 2, y, width / 2),
                    search(x, y + width / 2, width / 2), search(x + width / 2, y + width / 2, width / 2) };
            for (int i = 0; i < 4; i++) {
                if (quad[i] != null) {
                    return quad[i];
                }
            }
            return null;
        }
    }
}
