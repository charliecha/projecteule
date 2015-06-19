package bean17.cha.problem54;

/**
 * Created by chinda on 15/6/18.
 */
public class FourOfAKindRecognize implements IHandTypeRecognize {
	@Override
	public WrappedHandType recognize(HandCard hand) {
		Card[] cards = hand.cards;

		boolean fourOfAKind = true;
		for (int i = cards.length - 1; i >= 2; i--) {
			if (cards[i].size() != cards[i - 1].size()) {
				fourOfAKind = false;
				break;
			}
		}
		if (fourOfAKind) {
			return new FourOfAKind(cards[cards.length - 1], cards[0]);
		}

		fourOfAKind = true;
		for (int i = 0; i <= 2; i++) {
			if (cards[i].size() != cards[i + 1].size()) {
				fourOfAKind = false;
				break;
			}
		}
		if (fourOfAKind) {
			return new FourOfAKind(cards[0], cards[cards.length - 1]);
		}

		return null;
	}
}
