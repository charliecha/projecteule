package bean17.cha.problem54;

import java.util.Comparator;

/**
 * bean17.cha
 */
public class Card implements ISize {
    Color color;
    Size size;
    static Comparator<Card> sizeComparator = new Comparator<Card>() {

        @Override
        public int compare(Card arg0, Card arg1) {
            return arg0.size() - arg1.size();
        }
    };

    public Card(String sc) {
        if (null != sc && 2 <= sc.length()) {
            size = Size.valueOfAbbreviation(sc.substring(0, sc.length() - 1));
            color = Color.valueOfAbbreviation(sc.substring(sc.length() - 1));
        }
    }

    @Override
    public int size() {
        return size.getSize();
    }

    @Override
    public String toString() {
        return size.getAbbreviation() + color.getAbbreviation();
    }
}
