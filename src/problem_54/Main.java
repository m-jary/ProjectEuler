package problem_54;
/*Poker Hands
In the card game poker, a hand consists of five cards and are ranked, from lowest to highest, in the following way:
High Card: Highest value card.
One Pair: Two cards of the same value.
Two Pairs: Two different pairs.
Three of a Kind: Three cards of the same value.
Straight: All cards are consecutive values.
Flush: All cards of the same suit.
Full House: Three of a kind and a pair.
Four of a Kind: Four cards of the same value.
Straight Flush: All cards are consecutive values of same suit.
Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.

The cards are valued in the order: 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.

If two players have the same ranked hands then the rank made up of the highest value wins; for example, a pair of
eights beats a pair of fives. But if two ranks tie, for example, both players have a pair of queens, then highest
cards in each hand are compared; if the highest cards tie then the next
highest cards are compared, and so on.

The file, poker.txt, contains one-thousand random hands dealt to two players. Each line of the file contains ten
cards (separated by a single space): the first five are Player 1's cards and the last five are Player 2's cards. You
can assume that all hands are valid (no invalid characters or repeated cards), each player's hand is in no specific
order, and in each hand there is a clear winner.
How many hands does Player 1 win?*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File poker = new File("poker.txt");
        Scanner reader = new Scanner(poker);
        String player1;
        String player2;
        int handNumber = 0;
        int counter = 0;

        while (reader.hasNextLine()) {
            handNumber++;
            String line = reader.nextLine();
            String[] cards = line.split(" ");
            player1 = "";
            player2 = "";

            for (int i = 0; i < cards.length; i++) {
                if  (i < 5) {
                    player1 += cards[i];
                } else {
                    player2 += cards[i];
                }
            }

            HashMap<Character, Integer> player1Hand = PokerHands.countCards(player1);
            HashMap<Character, Integer> player2Hand = PokerHands.countCards(player2);
            System.out.println("Hand " + handNumber);
            System.out.println(player1Hand);
            int player1Score = PokerHands.evaluateHand(player1Hand);
            int player2Score = PokerHands.evaluateHand(player2Hand);

            if (player1Score > player2Score) {
                System.out.println("Player 1 wins!");
                counter++;
            } else if (player1Score < player2Score) {
                System.out.println("Player 2 wins!");
            } else {
                System.out.println("Tie");
            }
            System.out.println();
        }
        System.out.println(counter);
    }
}
