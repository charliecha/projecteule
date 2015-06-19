package bean17.cha.problem54;

/**
 * Created by chinda on 15/6/18.
 */
public class FlushRecognize implements IHandTypeRecognize {
	@Override
	public WrappedHandType recognize(HandCard hand) {
		Card[] cards = hand.cards;

		for (int i = cards.length - 1; i >= 1; i--) {
			if (cards[i].color != cards[i - 1].color) {
				return null;
			}
		}
		return new Flush(cards);
	}
}
