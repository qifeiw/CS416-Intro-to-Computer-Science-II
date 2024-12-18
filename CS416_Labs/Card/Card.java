/**
 * @author Qifei Wang
 * @version 1
 */

public class Card implements Comparable<Card> {
    private String suit;
    private String value;
    private int valueRank;
    /**
     * 
     * @param suit suit
     * @param value value of card
     */

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
        valueRank = getValueOrder(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Card)) {
            return false;
        } else {
            Card c = (Card) obj;
            return this.suit.equals(c.suit) && this.value.equals(c.value);
        }
    }
    /**
     * 
     * @return suit
     */

    public String getSuit() {
        return suit;
    }
    /**
     * 
     * @return value
     */

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getPrintValue(value) + " of " + suit;
    }
    /**
     * 
     * @param value value
     * @return print value
     */

    public static String getPrintValue(String value) {
        switch (value) {
            case "2":
                return "Two";
            case "3":
                return "Three";
            case "4":
                return "Four";
            case "5":
                return "Five";
            case "6":
                return "Six";
            case "7":
                return "Seven";
            case "8":
                return "Eight";
            case "9":
                return "Nine";
            case "10":
                return "Ten";
            case "Jack":
                return "Jack";
            case "Queen":
                return "Queen";
            case "King":
                return "King";
            case "Ace":
                return "Ace";
            default:
                return "";
        }
    }
    /**
     * 
     * @param o o
     * @return -1 0 or 1
     */

    public int compareTo(Card o) {
        return Integer.compare(this.valueRank, o.valueRank);
    }
    /**
     * 
     * @param value value of card
     * @return digital value
     */

    private int getValueOrder(String value) {
        switch (value) {
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
            case "Jack":
                return 11;
            case "Queen":
                return 12;
            case "King":
                return 13;
            case "Ace":
                return 14;
            default:
                return -1;
        }
    }
    /**
     * 
     * @param args input
     */

    public static void main(String[] args) {
        Card c = new Card("Diamonds", "3");
        System.out.println(c);
    }
}