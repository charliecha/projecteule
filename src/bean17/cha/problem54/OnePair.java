package bean17.cha.problem54;

import java.util.Arrays;

/**
 * Created by chinda on 15/6/18.
 */
class OnePair extends WrappedHandType {
	final Card onePair;
	final Card[] cards;

	public OnePair(Card onePair, Card[] cards) {
		super(HandType.OnePair);
		this.onePair = onePair;
		this.cards = cards;
	}

	@Override
	public int compareTo(WrappedHandType handType) {
		if (type != handType.type) {
			return super.compareTo(handType);
		}

		OnePair onePair1 = (OnePair) handType;

		if (onePair.size() != onePair1.onePair.size()) {
			return onePair.size() - onePair1.onePair.size();
		}

		for (int i = cards.length - 1; i >= 0; i--) {
			if (cards[i].size() != onePair1.cards[i].size()) {
				return cards[i].size() - onePair1.cards[i].size();
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		return super.toString() + " : " + onePair + " "
				+ Arrays.toString(cards);
	}
}
