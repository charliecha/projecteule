package bean17.cha;


public class Problem17 {
	private static final int TEN = 10;
	private static final int HUNDRED = 100;
	private static final int THOUSAND = 1000;
	private static final int MILLION = 1000000;
	
	/**
	 * @param args arguments
	 */
	public static void main(String[] args) {
		new Problem17().numberLetterCounts();
	}

	private void numberLetterCounts() {
		long count = 0;
		long start = System.currentTimeMillis();
		
		StringBuilder builder = new StringBuilder();
		for (int i = 1; i <= 1000; i++) {
			builder.append(translate(i));
		}
		
		for (int i = 0; i < builder.length(); i++) {
			char c = builder.charAt(i);
			if (c >= 'a' && c <= 'z') {
				count++;
			}
		}
		
//		System.out.println(builder);
		
		System.out.println("max = " + count);
		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
	}
	
	private String translate(int i){
		if (0 > i) {
			return "minus " + Math.abs(i);
		} else if (0 == i) {
			return "zero";
		} else if (i < HUNDRED) {
			if (i < 20) {
				switch (i) {
				case 1:return "one";
				case 2:return "two";
				case 3:return "three";
				case 4:return "four";
				case 5:return "five";
				case 6:return "six";
				case 7:return "seven";
				case 8:return "eight";
				case 9:return "nine";
				case 10:return "ten";
				case 11:return "eleven";
				case 12:return "twelve";
				case 13:return "thirteen";
				case 14:return "fourteen";
				case 15:return "fifteen";
				case 16:return "sixteen";
				case 17:return "seventeen";
				case 18:return "eighteen";
				case 19:return "nineteen";
				
				default:
					break;
				}
			} else if (0 == i % TEN) {
				switch (i/TEN) {
				case 2: return "twenty";
				case 3: return "thirty";
				case 4: return "forty";
				case 5: return "fifty";
				case 6: return "sixty";
				case 7: return "seventy";
				case 8: return "eighty";
				case 9: return "ninety";
				default:
					break;
				}
			} else {
				int ones = i % TEN;
				return translate(i - ones) + "-" + translate(ones);
			}
			
		} else if (i < THOUSAND) {
			int hundreds = i / HUNDRED;
			StringBuilder builder = new StringBuilder();
			builder.append(translate(hundreds));
			builder.append(" hundred");
			if (0 != i % HUNDRED) {
				builder.append(" and ").append(translate(i%HUNDRED));
			}
			return builder.toString();
		} else if (i < MILLION) {
			int thousands = i / THOUSAND;
			StringBuilder builder = new StringBuilder();
			builder.append(translate(thousands));
			builder.append(" thousand ");
			if (0 != i % THOUSAND) {
				builder.append(" and ").append(translate(i%THOUSAND));
			}
			return builder.toString();
		} else {
			int millions = i / MILLION;
			StringBuilder builder = new StringBuilder();
			builder.append(translate(millions));
			builder.append(" million ");
			if (0 != i % MILLION) {
				builder.append(" and ").append(translate(i%MILLION));
			}
			return builder.toString();
		}
		return "";
	}
}
