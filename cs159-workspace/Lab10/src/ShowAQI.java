import java.awt.Color;

/**
 * An application that shows air quality index (AQI) information in window.
 *
 * @author Prof. David Bernstein, James Madison University
 * @version 1.0
 */
public class ShowAQI {
    /**
     * The entry-point of the application.
     *
     * @param args The command-line arguments (
     */
    public static void main(String[] args) {
        AirQuality quality;
        Announcement announcement;
        int aqi;
        if ((args == null) || (args.length < 1)) {
            System.out.println("\nUsage: java ShowAQI aqi\n");
        } else {
            aqi = Integer.parseInt(args[0]);
            quality = AirQuality.findAirQuality(aqi);
            if (quality == null) {
                System.out.println("\nInvalid AQI. Please try again.\n");
            } else {
                announcement = new Announcement(quality.getDescription(), quality.getColor());
                announcement.setVisible(true);
            }
        }
    }

    /**
     * Find the Color associated with a particualr air quality index (AQI).
     *
     * @param aqi The air quality index
     * @return The associated Color
     */
    private static Color findColor(int aqi) {
        if (aqi >= 0 && aqi <= 50) {

            return new Color(0, 228, 0);
        } else if (aqi >= 51 && aqi <= 100) {
            return new Color(255, 255, 0);
        } else {
            return new Color(255, 126, 0);
        }

    }

    /**
     * Find the description associated with a particular category.
     *
     * @param aqi The air quality index
     * @return The associated description
     */
    private static String findDescription(int aqi) {
        if (aqi >= 0 && aqi <= 50) {
            return "Good";
        } else if (aqi >= 51 && aqi <= 100) {
            return "Moderate";
        } else {
            return "Unhealthy for Sensative Groups";
        }
    }
}