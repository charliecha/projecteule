package bean17.cha.problem54;

/**
 * Created by chinda on 15/6/18.
 */
class FourOfAKind extends WrappedHandType {
	final Card fourOfAKind;
	final Card card;

	public FourOfAKind(Card fourOfAKind, Card card) {
		super(HandType.FourOfAKind);
		this.fourOfAKind = fourOfAKind;
		this.card = card;
	}

	@Override
	public int compareTo(WrappedHandType handType) {
		if (type != handType.type) {
			return super.compareTo(handType);
		}

		FourOfAKind hignCard = (FourOfAKind) handType;
		if (fourOfAKind.size() != hignCard.fourOfAKind.size()) {
			return fourOfAKind.size() - hignCard.fourOfAKind.size();
		}

		if (card.size() != hignCard.card.size()) {
			return card.size() - hignCard.card.size();
		}

		return 0;
	}

	@Override
	public String toString() {
		return super.toString() + " : " + fourOfAKind + " " + card;
	}
}
