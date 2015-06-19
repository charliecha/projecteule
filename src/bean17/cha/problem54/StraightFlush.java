package bean17.cha.problem54;

/**
 * Created by chinda on 15/6/18.
 */
class StraightFlush extends WrappedHandType {
    // hight one
    final Card card;

    public StraightFlush(Card card) {
        super(HandType.StraightFlush);
        this.card = card;
    }

    @Override
    public int compareTo(WrappedHandType handType) {
        if (type != handType.type) {
            return super.compareTo(handType);
        }

        StraightFlush hignCard = (StraightFlush) handType;
        if (card.size() != hignCard.card.size()) {
            return card.size() - hignCard.card.size();
        }

        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + " : " + card;
    }
}
