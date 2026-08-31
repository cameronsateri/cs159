/**
 * File containing the Letter class.
 * 
 * @author cameron sateri
 * @version 2/2/23
 */
public class Letter {
    private char letter;
    private int points;

    /**
     * Constructor for the Letter class.
     * 
     * @param letter single letter.
     * @param points the location of the letter class.
     */
    public Letter(char letter, int points) {
        this.letter = letter;
        this.points = points;
    }

    /**
     * Accessor method for letter.
     * 
     * @return this.letter
     */
    public char getLetter() {
        return this.letter;
    }

    /**
     * Accessor method for points.
     * 
     * @return this.points
     */
    public int getPoints() {
        return this.points;
    }

    /**
     * Determines if all aspects of 2 Letter objects are the same.
     * 
     * @param other the other letter object being compared.
     * @return true or false.
     */
    public boolean equals(Letter other) {
        if (this.letter == other.getLetter() && this.points == other.getPoints()) {
            return true;
        }
        return false;
    }

    /**
     * tostring that formats the statement "Letter: _ Points: _".
     * 
     * @return string.
     */
    public String toString() {
        return "Letter: " + this.letter + " Points: " + this.points;
    }

}
