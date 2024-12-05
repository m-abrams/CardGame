import java.util.ArrayList;
public class Player {
    private String name;
    private double  points;
    private ArrayList<Card> hand;

    // Constructors
    public Player (String theName) {
        name = theName;
        points = 20.0;
    }
    public Player (String theName, ArrayList<Card> theHand) {
        name = theName;
        hand = theHand;
        points = 20.0;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public double getPoints() {
        return points;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
    public void addPoints(double numAdd) {
        points += numAdd;
    }
    public void subPoints(double numSub) {
        points -= numSub;
    }
    public void addCard(Card theCard) {
        hand.add(theCard);
    }
    public String toString() {
        return name + " has " + points + " points\n" + name + "'s: " + hand;
    }
}
