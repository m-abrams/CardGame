import java.util.ArrayList;
public class Deck {
    ArrayList<Card> deck = new ArrayList<Card>();
    private int cardsLeft = 0;

    public Deck(String[] ranks, String[] suits, int[] values) {
        for (int i = 0; i < )
    }
    public boolean isEmpty() {
        if (deck.isEmpty()) {
            return true;
        }
        return false;
    }
    public int getCardsLeft() {
        return deck.size();
    }
}
