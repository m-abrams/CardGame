import java.util.Scanner;
public class Game {

    private Deck deck;
    private Player user;
    private Player cpu = new Player("Geeg");

    public Game() {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        printInstructions();
        deck = new Deck(ranks, suits, values);
        deck.shuffle();
        Scanner s1 = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = s1.nextLine();
        Player user = new Player(name);
        Player cpu = new Player("cpu");
        user.addCard(deck.deal());
        cpu.addCard(deck.deal());
        user.addCard(deck.deal());
        cpu.addCard(deck.deal());
        System.out.println("Your cards are the: " + user.getHand());


    }

    public void printInstructions() {
        System.out.println("Welcome to Texas Hold 'Em...but a little bit simpler. Both you and the CPU will be dealt "+
                "two cards. After this, you will both bet, or you may fold. If one person folds, the other automatically"+
                " wins that round. If you both choose to bet, a card will be discarded, then 3 cards will be shown to " +
                "both you and the CPU--this is called the flop. You and the CPU will bet again (or one of you may fold");
    }

    public void playGame() {

    }

    public static void main(String[] args) {
        Game g1 = new Game();
    }
}
