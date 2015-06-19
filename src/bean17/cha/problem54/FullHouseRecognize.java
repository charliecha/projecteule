package bean17.cha.problem54;

/**
 * Created by chinda on 15/6/18.
 */
public class FullHouseRecognize implements IHandTypeRecognize {
    @Override
    public WrappedHandType recognize(HandCard hand) {
        Card[] cards = hand.cards;

        boolean fullHouse = true;
        for (int i = cards.length - 1; i >= 3; i--) {
            if (cards[i].size() != cards[i - 1].size()) {
                fullHouse = false;
                break;
            }
        }
        if (cards[1].size() != cards[0].size()) {
            fullHouse = false;
        }

        if (fullHouse) {
            return new FullHouse(cards[cards.length - 1], cards[1]);
        }

        fullHouse = true;
        for (int i = 0; i <= 1; i++) {
            if (cards[i].size() != cards[i + 1].size()) {
                fullHouse = false;
                break;
            }
        }
        if (cards[4].size() != cards[3].size()) {
            fullHouse = false;
        }

        if (fullHouse) {
            return new FullHouse(cards[1], cards[cards.length - 1]);
        }
        return null;
    }
}
