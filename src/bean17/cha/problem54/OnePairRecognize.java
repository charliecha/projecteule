package bean17.cha.problem54;

/**
 * Created by chinda on 15/6/18.
 */
public class OnePairRecognize implements IHandTypeRecognize {
	@Override
	public WrappedHandType recognize(HandCard hand) {
		Card[] cards = hand.cards;

		if (cards[0].size() == cards[1].size()) {
			return new OnePair(cards[0], new Card[] { cards[2], cards[3],
					cards[4] });
		} else if (cards[1].size() == cards[2].size()) {
			return new OnePair(cards[1], new Card[] { cards[0], cards[3],
					cards[4] });
		} else if (cards[2].size() == cards[3].size()) {
			return new OnePair(cards[2], new Card[] { cards[0], cards[1],
					cards[4] });
		} else if (cards[3].size() == cards[4].size()) {
			return new OnePair(cards[3], new Card[] { cards[0], cards[1],
					cards[2] });
		}

		return null;
	}
}
