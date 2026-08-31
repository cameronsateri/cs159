/**
 * File for the Area class.
 * 
 * @author cameron sateri
 * @version 4/21/23
 */
public class Area {
    private int x;
    private int y;
    private int width;

    /**
     * 3 arg constructor for the Area class.
     * 
     * @param x The x point of the area.
     * @param y The y point of the area.
     * @param width The width of the area.
     */
    public Area(int x, int y, int width) {
        this.x = x;
        this.y = y;
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public String toString() {
        String[] s = new String[5];
        for (int i = 0; i < s.length; i++) {
            s[i] = "   ";
        }
        s[0] += x;
        s[1] += y;
        s[2] += width;
        s[3] += x + width;
        s[4] += y + width;
        for (int i = 0; i < s.length; i++) {
            s[i] = s[i].substring(s[i].length() - 3);
        }
        return "\n+-------------------+\n|(" + s[0] + ", " + s[1] + ") + " + s[2] + "   |\n|         (" + s[3] + ", "
                + s[4] + ")|\n+-------------------+";
    }
}
