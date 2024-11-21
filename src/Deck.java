import java.util.ArrayList;
public class Deck {
    ArrayList<Card> deck = new ArrayList<Card>();
    private int cardsLeft = 0;

    public Deck(String[] ranks, String[] suits, int[] values) {
        for (String rank : ranks) {
            for (String suit : suits) {
                for (int value : values) {
                    deck.add(new Card(rank, suit, value));
                }
            }
        }
        cardsLeft = deck.size();
    }
    public boolean isEmpty() {
        return deck.isEmpty();
    }
    public int getCardsLeft() {
        return cardsLeft;
    }
    public Card deal() {
        if (cardsLeft >= 1) {
            cardsLeft--;
            return deck.remove(deck.size() - 1);
        }
        return null;
    }
    public void shuffle() {
        for (int i = cardsLeft; i > 0; i--) {
            int r = (int) (Math.random() * i);
            Card t  = deck.get(i);
            deck.set(i, deck.get(r));
            deck.set(r, t);
        }
    }
}
