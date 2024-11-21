import java.util.Scanner;
public class Game {
    private String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    private Deck deck;
    private Player p1;
    private Player p2 = new Player("Geeg");

    public void printInstructions() {
        System.out.println("Welcome to Texas Hold 'Em...but a little bit simpler. Both you and the CPU will be dealt "+
                "two cards. After this, you will both bet, or you may fold. If one person folds, the other automatically"+
                " wins that round. If you both choose to bet, a card will be discarded, then 3 cards will be shown to " +
                "both you and the CPU--this is called the flop. You and the CPU will bet again (or one of you may fold");
    }
    public String pName() {
        Scanner s1 = new Scanner(System.in);
        String pName = s1.nextLine();
        Player p1 = new Player(pName);
    }

    public void playGame() {
        deck = new Deck(this.ranks, this.suits, this.values);
        deck.shuffle();


    }
}
