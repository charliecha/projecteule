package bean17.cha.problem54;

/**
 * Created by chinda on 15/6/18.
 */
public class ThreeOfAkindRecognize implements IHandTypeRecognize {
    @Override
    public WrappedHandType recognize(HandCard hand) {
        Card[] cards = hand.cards;

        boolean threeAKind = true;
        for (int i = cards.length - 1; i >= 3; i--) {
            if (cards[i].size() != cards[i - 1].size()) {
                threeAKind = false;
                break;
            }
        }

        if (threeAKind) {
            return new ThreeOfAKind(cards[cards.length - 1], new Card[]{cards[0], cards[1]});
        }

        threeAKind = true;
        for (int i = 3; i >= 2; i--) {
            if (cards[i].size() != cards[i - 1].size()) {
                threeAKind = false;
                break;
            }
        }

        if (threeAKind) {
            return new ThreeOfAKind(cards[3], new Card[]{cards[0], cards[4]});
        }


        threeAKind = true;
        for (int i = 2; i >= 1; i--) {
            if (cards[i].size() != cards[i - 1].size()) {
                threeAKind = false;
                break;
            }
        }

        if (threeAKind) {
            return new ThreeOfAKind(cards[2], new Card[]{cards[3], cards[4]});
        }
        return null;
    }
}
