package bean17.cha.problem54;

/**
 * Created by chinda on 15/6/18.
 */
public class StraightFlushRecognize implements IHandTypeRecognize {
	@Override
	public WrappedHandType recognize(HandCard hand) {
		Card[] cards = hand.cards;

		for (int i = cards.length - 1; i >= 1; i--) {
			if (cards[i].color != cards[i - 1].color
					|| cards[i].size() != cards[i - 1].size() + 1) {
				return null;
			}
		}
		return new StraightFlush(cards[cards.length - 1]);
	}
}
