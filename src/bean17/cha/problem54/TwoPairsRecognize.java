package bean17.cha.problem54;

/**
 * bean17.cha
 */
public class TwoPairsRecognize implements IHandTypeRecognize {
    @Override
    public WrappedHandType recognize(HandCard hand) {
        Card[] cards = hand.cards;

        if (cards[0].size() == cards[1].size()) {
            if (cards[2].size() == cards[3].size()) {
                return new TwoPair(cards[0], cards[2], cards[4]);
            } else if (cards[3].size() == cards[4].size()) {
                return new TwoPair(cards[0], cards[3], cards[2]);
            }
        }

        if (cards[1].size() == cards[2].size() && cards[3].size() == cards[4].size()) {
            return new TwoPair(cards[1], cards[3], cards[0]);
        }

        return null;
    }
}
