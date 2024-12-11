import java.util.ArrayList;
import java.util.Scanner;
public class Game {
    private double pot;
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
    }
    public void startRound() {
        user.addCard(deck.deal());
        cpu.addCard(deck.deal());
        user.addCard(deck.deal());
        cpu.addCard(deck.deal());
        System.out.println("Your cards are the: " + user.getHand());
        if (isFold()) {
            foldHand();
        }
        else {
            placeBet();
        }
    }
    public boolean isFold() {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Would you like to fold? (Yes or No)");
        String fold = s1.nextLine().toLowerCase();
        return fold.equals("yes");
    }
    public void foldHand() {
        if (isFold()) {
            cpu.addPoints(pot);
            System.out.println("You chose to fold, the cpu gets the pot.");
        }
        pot = 0;
        user.getHand().clear();
        cpu.getHand().clear();
        startRound();
    }
    public void printInstructions() {
        System.out.println("Welcome to Texas Hold 'Em...but a little bit simpler. Both you and the CPU will be dealt "+
                "two cards. After this, you will both bet, or you may fold. If one person folds, the other automatically"+
                " wins that round. If you both choose to bet, a card will be discarded, then 3 cards will be shown to " +
                "both you and the CPU--this is called the flop. You and the CPU will bet again (or one of you may fold");
    }

    public void playGame() {
        printInstructions();
        round1();
    }

    public void round1() {
        user.addCard(deck.deal());
        user.addCard(deck.deal());
        cpu.addCard(deck.deal());
        cpu.addCard(deck.deal());

        if (isFold()) {
            foldHand();
        }
        else {
            placeBet();
            round2();
        }
    }
    public void placeBet() {
        Scanner s1 = new Scanner(System.in);
        double bet = 0;
        System.out.println("How much Would you like to bet?");
        bet = s1.nextDouble();
        while (bet > user.getPoints()) {
            System.out.println("You don't have that much money! Type in your new bet: ");
            bet = s1.nextDouble();
        }
        user.subPoints(bet);
        System.out.println("The CPU calls");
        pot += (bet * 2);
    }
    public void round2() {
        Card flopCard1 = deck.deal();
        Card flopCard2 = deck.deal();
        Card flopCard3 = deck.deal();
        System.out.println("Flop: " + flopCard1 + ", " + flopCard2 + ", " + flopCard3);
        if (isFold()) {
            foldHand();
        }
        else {
            placeBet();
            round3();
        }
    }
    public void round3() {
        Card turnCard = deck.deal();
        System.out.println("The turn: " + turnCard);
        if (isFold()) {
            foldHand();
        }
        else {
            placeBet();
            round4();
        }
    }
    public void round4() {
        Card riverCard = deck.deal();
        System.out.println("The river: " + riverCard);
        if (isFold()) {
            foldHand();
            startRound();
        }
        else {
            placeBet();
            getWinner();
            printWinner();
            startRound();
        }
    }
    public void printWinner() {
        if (getWinner()) {
            System.out.println("You won! You win the pot.");
            user.addPoints(pot);
        }
        else {
            System.out.println("You lost! CPU wins the pot.");
            cpu.addPoints(pot);
        }
    }
    public int handValue(ArrayList<Card> hand) {
        int[] numRank = new int[13];
        int highCard = 0;
        int pairValue = 0;
        boolean hasPair = false;
        for (int i = 0; i < hand.size(); i++) {
            Card temp = hand.get(i);
            numRank[temp.getValue()]++;
        }
        for (int i = 0; i < numRank.length; i++) {
            if (numRank[i] == 2) {
                hasPair = true;
                pairValue = numRank[i];
            }
            // Comparing  high card and value of each card in hand by using math max to
            // compare the current value high card and the value of the card at the current index
            if (numRank[i] >= 1) {
                highCard = Math.max(highCard, i);
            }
        }
        if (hasPair) {
            return 10 + pairValue;
        }
        else {
            return highCard;
        }
    }
    public boolean getWinner() {
        int userPlayHand = handValue(user.getHand());
        int cpuPlayHand = handValue(cpu.getHand());
        if (userPlayHand > cpuPlayHand) {
            return true;
        }
        else {
            return false;
        }
    }
    public static void main(String[] args) {
        Game g1 = new Game();
        g1.playGame();
    }
}
