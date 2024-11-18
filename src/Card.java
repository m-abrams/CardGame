// Card Class by Max Abrams
public class Card {
    // Declaring instance variables
    private String rank;
    private String suit;
    private int value;

    // Card Constructor
    public Card(String theRank, String theSuit, int theValue) {
        rank = theRank;
        suit = theSuit;
        value = theValue;
    }

    // Setter Methods
    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // Getter Methods
    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    // ToString Method
    public String toString() {
        return this.rank + " of " + this.suit;
    }
}
