package bean17.cha.problem54;

/**
 * Created by chinda on 15/6/19.
 */
public class HandRecognizeManager {

    private static volatile HandRecognizeManager instance = new HandRecognizeManager();

    public static HandRecognizeManager getInstance() {
        return instance;
    }

    IHandTypeRecognize[] recognizes = new IHandTypeRecognize[]{
            new RoyalFlushRecognize(), new StraightFlushRecognize(), new FourOfAKindRecognize()
            , new FullHouseRecognize(), new FlushRecognize(), new StraightRecognize(),
            new ThreeOfAkindRecognize(), new TwoPairsRecognize(), new OnePairRecognize(), new HighCardRecognize()
    };

    public WrappedHandType recognize(HandCard hand) {
        for (int i = 0; i < recognizes.length; i++) {
            WrappedHandType handType = recognizes[i].recognize(hand);
            if (null != handType) {
                return handType;
            }
        }
        return null;
    }
}
