package bean17.cha.problem54;

import java.util.Arrays;

/**
 * Created by chinda on 15/6/18.
 */
public class HandCard implements  Comparable<HandCard>{
    public static final int NUMBER = 5;
    final Card[] cards;
    final WrappedHandType type;

    public HandCard(Card[] cards) {
        super();
        this.cards = cards;
        assert (NUMBER == cards.length);

        Arrays.sort(this.cards, Card.sizeComparator);

        type = HandRecognizeManager.getInstance().recognize(this);
    }

    @Override
    public int compareTo(HandCard hand) {
        return type.compareTo(hand.type);
    }

    @Override
    public String toString() {
        return Arrays.toString(cards) + " " + type;
    }
}
