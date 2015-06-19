package bean17.cha.problem54;

/**
 * Created by chinda on 15/6/18. // 8C TS KC 9H 4S 7D 2S 5D 3S AC
 */
enum Color {
	SPADE("S"), HEART("H"), DIAMOND("D"), CLUB("C");
	private final String abbreviation;

	private Color(String a) {
		abbreviation = a;
	}

	public static Color valueOfAbbreviation(String a) {
		for (Color color : Color.values()) {
			if (color.abbreviation.equalsIgnoreCase(a)) {
				return color;
			}
		}
		return null;
	}

	public String getAbbreviation() {
		return abbreviation;
	}
}
