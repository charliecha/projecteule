package bean17.cha;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Poker hands Problem 54 In the card game poker, a hand consists of five cards
 * and are ranked, from lowest to highest, in the following way:
 * 
 * High Card: Highest value card. One Pair: Two cards of the same value. Two
 * Pairs: Two different pairs. Three of a Kind: Three cards of the same value.
 * Straight: All cards are consecutive values. Flush: All cards of the same
 * suit. Full House: Three of a kind and a pair. Four of a Kind: Four cards of
 * the same value. Straight Flush: All cards are consecutive values of same
 * suit. Royal Flush: Ten, Jack, Queen, King, Ace, in same suit. The cards are
 * valued in the order: 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.
 * 
 * If two players have the same ranked hands then the rank made up of the
 * highest value wins; for example, a pair of eights beats a pair of fives (see
 * example 1 below). But if two ranks tie, for example, both players have a pair
 * of queens, then highest cards in each hand are compared (see example 4
 * below); if the highest cards tie then the next highest cards are compared,
 * and so on.
 * 
 * Consider the following five hands dealt to two players:
 * 
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
 * 
 * How many hands does Player 1 win?
 * 
 * @author bean17.cha
 */
public class Problem54 {
	/**
	 * @param args
	 *            arguments
	 */
	public static void main(String[] args) {
		
		new Problem54().testPokerHands();
	}

	private void testPokerHands() {
		long start = System.currentTimeMillis();

		String path = "D:\\github\\projecteule\\files\\Problem54.txt";
		File file = new File(path);
		String[] lines = Utils.readStringArray(file);
		for (String string : lines) {
			// StringBuilder builder = new StringBuilder();

			String[] array = string.split(" ");
			Card[] cards = new Card[array.length];
			for (int i = 0; i < array.length; i++) {
				cards[i] = new Card(array[i]);
			}

			// for (Card card : cards) {
			// builder.append(card.toString() + " - ");
			// }
			// System.out.println(builder.toString());
		}

		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
	}
}

// 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace

enum Size implements ISize {
	TWO(2, "2"), THREE(3, "3"), FOUR(4, "4"), FIVE(5, "5"), SIX(6, "6"), SEVEN(
			7, "7"), EIGHT(8, "8"), NINE(9, "9"), TEN(10, "T"), JACK(11, "J"), QUEEN(
			12, "Q"), KING(13, "K"), ACE(14, "A");
	private Size(int s, String a) {
		size = s;
		abbreviation = a;
	}

	public static Size valueOfAbbreviation(String a) {
		for (Size size : Size.values()) {
			if (size.abbreviation.equalsIgnoreCase(a)) {
				return size;
			}
		}
		return null;
	}

	private final int size;
	private final String abbreviation;

	public int getSize() {
		return size;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	@Override
	public int size() {
		return size;
	}
}

enum Color {
	SPADE("S"), HEART("H"), DIAMOND("D"), CLUB("C");
	private Color(String a) {
		abbreviation = a;
	}

	public static Color valueOfAbbreviation(String a) {
		for (Color color : Color.values()) {
			if (color.abbreviation.equalsIgnoreCase(a)) {
				return color;
			}
		}
		return null;
	}

	private final String abbreviation;

	public String getAbbreviation() {
		return abbreviation;
	}
}

interface ISize {
	int size();
}

class Card implements ISize {
	static Comparator<Card> sizeComparator = new Comparator<Card>() {

		@Override
		public int compare(Card arg0, Card arg1) {
			return arg0.size() - arg1.size();
		}
	};

	Color color;
	Size size;

	Card(String sc) {
		if (null != sc && 2 <= sc.length()) {
			size = Size.valueOfAbbreviation(sc.substring(0, sc.length() - 1));
			color = Color.valueOfAbbreviation(sc.substring(sc.length() - 1));
		}
	}

	@Override
	public int size() {
		return size.getSize();
	}

	@Override
	public String toString() {
		return "the " + size.name().toLowerCase() + " of "
				+ color.name().toLowerCase();
	}
}

enum HandType {
}

class Hand {
	public static final int NUMBER = 5;
	private final Card[] cards;

	public Hand(Card[] cards) {
		super();
		this.cards = cards;
		assert (NUMBER == cards.length);

		Arrays.sort(this.cards, Card.sizeComparator);
	}
}

// 8C TS KC 9H 4S 7D 2S 5D 3S AC