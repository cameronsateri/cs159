import java.awt.Color;

/**
 * An enumeration of all possible AirQuality objects.
 *
 * @author Prof. David Bernstein, James Madison University
 * @version 1.0
 */
public enum AirQuality {
    GOOD("Good", 0, 50, new Color(0, 228, 0)), MODERATE("Moderate", 51, 100, new Color(255, 255, 0)),
    SENSITIVE("Unhealthy for Sensitive Groups", 101, 150, new Color(255, 126, 0)),
    UNHEALTHY("Unhealthy", 151, 200, new Color(255, 0, 0)),
    VERY_UNHEALTHY("Very Unhealthy", 201, 300, new Color(153, 0, 76)),
    HAZARDOUS("Hazardous", 301, 500, new Color(126, 0, 35));

    private final Color color;
    private final int max, min;
    private final String description;

    /**
     * Explicit Value Constructor.
     *
     * @param description A description of this AirQuality object.
     * @param min The minimum AQI for this AirQuality object.
     * @param max The maximum AQI for this AirQuality object.
     * @param color The Color of this AirQuality object
     */
    private AirQuality(String description, int min, int max, Color color) {
        this.description = description;
        this.min = min;
        this.max = max;
        this.color = color;
    }

    public String getDescription() {
        return this.description;
    }

    public Color getColor() {
        return this.color;
    }

    /**
     * Checks if the specific AirQuality object is within the aqi.
     * 
     * @param aqi The value to check between min and max.
     * @return True if its in min and max, false otherwise.
     */
    public boolean contains(int aqi) {
        return this.min <= aqi && this.max >= aqi;
    }

    /**
     * Determines the AirQuality object based on the aqi.
     * 
     * @param aqi The aqi the method is measuring.
     * @return The AirQuality object that the aqi is finding.
     */
    public static AirQuality findAirQuality(int aqi) {
        AirQuality[] all = AirQuality.values();
        for (int i = 0; i < all.length; i++) {
            if (all[i].contains(aqi)) {
                return all[i];
            }
        }
        return null;
    }

}