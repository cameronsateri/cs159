public class TheLabratory {

    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        int width = 512;
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
        System.out.println("+-------------------+\n|(" + s[0] + ", " + s[1] + ") + " + s[2] + "   |\n|         (" + s[3]
                + ", " + s[4] + ")|\n+-------------------+");
    }
}
