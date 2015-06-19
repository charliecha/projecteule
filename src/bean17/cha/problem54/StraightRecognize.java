package bean17.cha.problem54;

/**
 * Created by chinda on 15/6/18.
 */
public class StraightRecognize implements IHandTypeRecognize {
    @Override
    public WrappedHandType recognize(HandCard hand) {
        Card[] cards = hand.cards;

        for (int i = cards.length - 1; i >= 1; i--) {
            if (cards[i].size() != cards[i - 1].size() + 1) {
                return null;
            }
        }
        return new Straight(cards[cards.length - 1]);
    }
}
