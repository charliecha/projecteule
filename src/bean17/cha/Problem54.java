package bean17.cha;

import java.io.File;

import bean17.cha.Utils;
import bean17.cha.problem54.Card;
import bean17.cha.problem54.HandCard;


/**
 * Poker hands Problem 54 In the card game poker, a hand consists of five cards
 * and are ranked, from lowest to highest, in the following way:
 * <p/>
 * High Card: Highest value card. One Pair: Two cards of the same value. Two
 * Pairs: Two different pairs. Three of a Kind: Three cards of the same value.
 * Straight: All cards are consecutive values. Flush: All cards of the same
 * suit. Full House: Three of a kind and a pair. Four of a Kind: Four cards of
 * the same value. Straight Flush: All cards are consecutive values of same
 * suit. Royal Flush: Ten, Jack, Queen, King, Ace, in same suit. The cards are
 * valued in the order: 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.
 * <p/>
 * If two players have the same ranked hands then the rank made up of the
 * highest value wins; for example, a pair of eights beats a pair of fives (see
 * example 1 below). But if two ranks tie, for example, both players have a pair
 * of queens, then highest cards in each hand are compared (see example 4
 * below); if the highest cards tie then the next highest cards are compared,
 * and so on.
 * <p/>
 * Consider the following five hands dealt to two players:
 * <p/>
 * Hand Player 1 Player 2 Winner 1 5H 5C 6S 7S KD Pair of Fives 2C 3S 8S 8D TD
 * Pair of Eights Player 2 2 5D 8C 9S JS AC Highest card Ace 2C 5C 7D 8S QH
 * Highest card Queen Player 1 3 2D 9C AS AH AC Three Aces 3D 6D 7D TD QD Flush
 * with Diamonds Player 2 4 4D 6S 9H QH QC Pair of Queens Highest card Nine 3D
 * 6D 7H QD QS Pair of Queens Highest card Seven Player 1 5 2H 2D 4C 4D 4S Full
 * House With Three Fours 3C 3D 3S 9S 9D Full House with Three Threes Player 1
 * The file, poker.txt, contains one-thousand random hands dealt to two players.
 * Each line of the file contains ten cards (separated by a single space): the
 * first five are Player 1's cards and the last five are Player 2's cards. You
 * can assume that all hands are valid (no invalid characters or repeated
 * cards), each player's hand is in no specific order, and in each hand there is
 * a clear winner.
 * <p/>
 * How many hands does Player 1 win?
 *
 * @author bean17.cha
 */
public class Problem54 {
    /**
     * @param args arguments
     */
    public static void main(String[] args) {

        new Problem54().testPokerHands();
    }

    private void testPokerHands() {
        long start = System.currentTimeMillis();

        String path = "D:\\github\\projecteule\\files\\Problem54.txt";

        int win1 = 0;

        File file = new File(path);
        String[] lines = Utils.readStringArray(file);

        for (String string : lines) {
            String[] array = string.split(" ");
            Card[] cards = new Card[array.length];
            for (int i = 0; i < array.length; i++) {
                cards[i] = new Card(array[i]);
            }

            if (cards.length == 2 * HandCard.NUMBER) {
                HandCard hand1 = new HandCard(new Card[]{cards[0], cards[1], cards[2], cards[3], cards[4]});
                HandCard hand2 = new HandCard(new Card[]{cards[5], cards[6], cards[7], cards[8], cards[9]});

//                System.out.println("hand1 : " + hand1);
//                System.out.println("hand2 : " +hand2);

                if (hand1.compareTo(hand2) > 0) {
                    win1++;
                }
            }
        }

        System.out.println("hand1 win " + win1);
        System.out.println("cost time : "
                + (System.currentTimeMillis() - start) + "ms.");
    }
}




