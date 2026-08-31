/**
 * File containing the Hand class.
 * 
 * @author cameron sateri
 * @version 2/2/23
 */
public class Hand {
    public static final int MAX_SIZE = 8;
    private Letter[] hand;
    private int size;

    /**
     * The constructor for the Hand class.
     * 
     * @param size size of the hand.
     */
    public Hand(int size) {
        if (size >= Hand.MAX_SIZE) {
            this.size = Hand.MAX_SIZE;
        } else if (size < 0) {
            this.size = 0;
        } else {
            this.size = size;
        }
        this.hand = new Letter[this.size];
    }

    /**
     * Constructor with empty args give the hand MAX_SIZE.
     */
    public Hand() {
        this.size = Hand.MAX_SIZE;
        this.hand = new Letter[this.size];
    }

    /**
     * Returns the object's size.
     * 
     * @return this.size
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Inserts letter into this.hand at index.
     * 
     * @param letter object Letter to be inserted.
     * @param index the location in the array to insert the Letter.
     * @return true or false.
     */
    public boolean insert(Letter letter, int index) {
        if (index >= 0 && index < this.size && this.hand[index] == null) {
            this.hand[index] = letter;
            return true;
        }
        return false;
    }

    /**
     * Resets the letter in this.hand at index to null, returns that letter.
     * 
     * @param index location in this.hand to set to null.
     * @return null OR this.hand[index].
     */
    public Letter remove(int index) {
        if (index >= 0 && index < this.size) {
            Letter ret = this.hand[index];
            this.hand[index] = null;
            return ret;
        }
        return null;
    }

    /**
     * Compiles a string containing all of the letter objects in Hand.
     * 
     * @return ret
     */
    public String toString() {
        String ret = "";
        for (int i = 0; i < this.hand.length; i++) {
            ret = ret + i + ": ";
            if (this.hand[i] == null) {
                ret = ret + "-";
            } else {
                ret = ret + this.hand[i];
            }
            ret = ret + "; ";
        }
        return ret;
    }

    /**
     * Finds the first instance of letter in this.hand.
     * 
     * @param letter letter to search for.
     * @return the index of letter.
     */
    public int indexOf(char letter) {
        for (int i = 0; i < this.hand.length; i++) {
            if (this.hand[i] != null && this.hand[i].getLetter() == letter) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the letter in this.hand at arg index.
     * 
     * @param index the index to find the letter in this.hand.
     * @return the letter in this.hand at index.
     */
    public Letter getLetter(int index) {
        if (this.hand[index] == null) {
            return null;
        }
        return this.hand[index];
    }

}
