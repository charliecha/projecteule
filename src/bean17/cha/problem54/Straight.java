package bean17.cha.problem54;

/**
 * Created by chinda on 15/6/18.
 */
class Straight extends WrappedHandType {
	// hight one
	final Card card;

	public Straight(Card card) {
		super(HandType.Straight);
		this.card = card;
	}

	@Override
	public int compareTo(WrappedHandType handType) {
		if (type != handType.type) {
			return super.compareTo(handType);
		}

		Straight hignCard = (Straight) handType;
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
