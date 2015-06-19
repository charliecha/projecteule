package bean17.cha.problem54;

/**
 * Created by chinda on 15/6/18.
 */
enum HandType implements ISize {
    HighCard(1), OnePair(2), TwoPairs(3), ThreeOfAKind(4), Straight(5), Flush(6),
    FullHouse(7), FourOfAKind(8), StraightFlush(9), RoyalFlush(10);

    private HandType(int size) {
        this.size = size;
    }

    private final int size;

    public int size() {
        return size;
    }
}
