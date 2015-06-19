package bean17.cha.problem54;

/**
 * Created by chinda on 15/6/18.
 */
class FullHouse extends WrappedHandType {
	final Card threeOfAKind;
	final Card onePair;

	public FullHouse(Card threeOfAKind, Card card) {
		super(HandType.FullHouse);
		this.threeOfAKind = threeOfAKind;
		this.onePair = card;
	}

	@Override
	public int compareTo(WrappedHandType handType) {
		if (type != handType.type) {
			return super.compareTo(handType);
		}

		FullHouse hignCard = (FullHouse) handType;
		if (threeOfAKind.size() != hignCard.threeOfAKind.size()) {
			return threeOfAKind.size() - hignCard.threeOfAKind.size();
		}

		if (onePair.size() != hignCard.onePair.size()) {
			return onePair.size() - hignCard.onePair.size();
		}

		return 0;
	}

	@Override
	public String toString() {
		return super.toString() + " : " + threeOfAKind + " " + onePair;
	}
}
