package bean17.cha.problem54;

/**
 * Created by chinda on 15/6/18.
 */
public class HighCardRecognize implements IHandTypeRecognize {
	@Override
	public WrappedHandType recognize(HandCard hand) {
		Card[] cards = hand.cards;
		return new HighCard(cards);
	}
}
