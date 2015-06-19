package bean17.cha.problem54;


/**
 * bean17.cha
 */
class TwoPair extends WrappedHandType {
    //little pair
    final Card onePair;

    //big pair
    final Card twoPair;

    final Card card;

    public TwoPair(Card onePair, Card twoPair, Card card) {
        super(HandType.TwoPairs);
        this.onePair = onePair;
        this.twoPair = twoPair;
        this.card = card;
    }

    @Override
    public int compareTo(WrappedHandType handType) {
        if (type != handType.type) {
            return super.compareTo(handType);
        }

        TwoPair twoPair1 = (TwoPair) handType;

        if (twoPair.size() != twoPair1.twoPair.size()){
            return twoPair.size() - twoPair1.twoPair.size();
        }

        if (onePair.size() != twoPair1.onePair.size()){
            return onePair.size() - twoPair1.onePair.size();
        }

        if (card.size() != twoPair1.card.size()){
            return card.size() - twoPair1.card.size();
        }
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + " : " + twoPair + " " + onePair + " " + card;
    }
}
