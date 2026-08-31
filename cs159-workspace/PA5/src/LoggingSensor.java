import java.util.HashMap;
import java.util.Map;

/**
 * File for the LoggingSensor class.
 * 
 * @author cameron sateri
 * @version 4/21/23
 */
public class LoggingSensor extends Sensor {
    private Map<Area, Boolean> scanLog;

    /**
     * 2 arg constructor for the LoggingSensor class.
     * 
     * @param etName The name of the alien.
     * @param scanTime The time it takes for the scan.
     */
    public LoggingSensor(String etName, int scanTime) {
        super(etName, scanTime);
        this.scanLog = new HashMap<>();
    }

    public Map<Area, Boolean> getScanLog() {
        return scanLog;
    }

    @Override
    public int scan(int x, int y, int width) {
        Area a = new Area(x, y, width);
        int s = super.scan(x, y, width);
        this.scanLog.put(a, s == 1);
        return s;
    }

    @Override
    public String toString() {
        return this.scanLog.toString();
    }

}
