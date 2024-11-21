import java.util.ArrayList;
public class Player {
    private String name;
    private int  points;
    private ArrayList<Card> hand;

    // Constructors
    public Player (String theName) {
        name = theName;
        points = 0;
    }
    public Player (String theName, ArrayList<Card> theHand) {
        name = theName;
        hand = theHand;
        points = 0;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
    public void addPoints(int numAdd) {
        points += numAdd;
    }
    public void addCard(Card theCard) {
        hand.add(theCard);
    }
    public String toString() {
        return name + " has " + points + " points\n" + name + "'s: " + hand;
    }
}
