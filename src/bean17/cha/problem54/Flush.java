package bean17.cha.problem54;

import java.util.Arrays;

/**
 * Created by chinda on 15/6/18.
 */
class Flush extends WrappedHandType {
	final Card[] cards;

	public Flush(Card[] cards) {
		super(HandType.Flush);
		this.cards = cards;
	}

	@Override
	public int compareTo(WrappedHandType handType) {
		if (type != handType.type) {
			return super.compareTo(handType);
		}

		Flush hignCard = (Flush) handType;
		for (int i = cards.length - 1; i >= 0; i--) {
			if (cards[i].size() != hignCard.cards[i].size()) {
				return cards[i].size() - hignCard.cards[i].size();
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		return super.toString() + " : " + Arrays.toString(cards);
	}
}
