package bean17.cha.problem54;

/**
 * bean17.cha
 */
abstract class WrappedHandType implements Comparable<WrappedHandType> {
	final HandType type;

	protected WrappedHandType(HandType t) {
		type = t;
	}

	@Override
	public int compareTo(WrappedHandType handType) {
		return type.size() - handType.type.size();
	}

	@Override
	public String toString() {
		return type.toString();
	}
}
