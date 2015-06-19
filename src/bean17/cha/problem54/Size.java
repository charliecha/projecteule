package bean17.cha.problem54;

/**
 * Created by chinda on 15/6/18.
 * // 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace
 */
enum Size implements ISize {
    TWO(2, "2"), THREE(3, "3"), FOUR(4, "4"), FIVE(5, "5"), SIX(6, "6"), SEVEN(
            7, "7"), EIGHT(8, "8"), NINE(9, "9"), TEN(10, "T"), JACK(11, "J"), QUEEN(
            12, "Q"), KING(13, "K"), ACE(14, "A");
    private final int size;
    private final String abbreviation;

    private Size(int s, String a) {
        size = s;
        abbreviation = a;
    }

    public static Size valueOfAbbreviation(String a) {
        for (Size size : Size.values()) {
            if (size.abbreviation.equalsIgnoreCase(a)) {
                return size;
            }
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    @Override
    public int size() {
        return size;
    }
}
