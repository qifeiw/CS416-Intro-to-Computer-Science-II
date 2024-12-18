/**
 * @author Qifei Wang
 * @version 1
 */
public class Card {
    private String suit;
    private String value;

    /**
     * @param suit  of card
     * @param value of card
     */

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    // Getter for the suit
    /**
     * 
     * @return suit
     */

    public String getSuit() {
        return suit;
    }

    // Setter for the suit
    /**
     * 
     * @param suit of card
     */

    public void setSuit(String suit) {
        this.suit = suit;
    }

    // Getter for the value
    /**
     * 
     * @return value
     */

    public String getValue() {
        return value;
    }

    // Setter for the value
    /**
     * 
     * @param value of card
     */
    public void setValue(String value) {
        this.value = value;
    }
}
