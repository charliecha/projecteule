package bean17.cha.problem54;

import java.util.Arrays;

/**
 * Created by chinda on 15/6/18.
 */
class ThreeOfAKind extends WrappedHandType {
    final Card threeOfAKind;
    final Card[] cards;

    public ThreeOfAKind(Card threeOfAKind, Card[] cards) {
        super(HandType.ThreeOfAKind);
        this.threeOfAKind = threeOfAKind;
        this.cards = cards;
    }

    @Override
    public int compareTo(WrappedHandType handType) {
        if (type != handType.type) {
            return super.compareTo(handType);
        }

        ThreeOfAKind hignCard = (ThreeOfAKind) handType;
        if (threeOfAKind.size() != hignCard.threeOfAKind.size()){
            return threeOfAKind.size() - hignCard.threeOfAKind.size();
        }

        for (int i = cards.length - 1; i >= 0; i--) {
            if (cards[i].size() != hignCard.cards[i].size()) {
                return cards[i].size() - hignCard.cards[i].size();
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + " : " + threeOfAKind + " " + Arrays.toString(cards);
    }
}
