package bean17.cha;

public class Problem21 {
	/**
	 * @param args arguments
	 */
	public static void main(String[] args) {
		new Problem21().testAmicableNumbers();
	}

	private void testAmicableNumbers() {
		long start = System.currentTimeMillis();

		long result = 0;
		for (int i = 2; i <= 10000; i++) {
			int amicable = amicableNumbers(i);
			if (i != amicable && i == amicableNumbers(amicable)) {
				result += i;		
			}
		}
		
		System.out.println("result = " + result);
		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
	}

	private int amicableNumbers(int v) {
		if (1 >= v) {
			return 0;
		} else {
			int result = 0;
			for (int i = 1; i * i <= v; i++) {
				if (0 == v % i) {
					if (i < v) {
						result += i;
					}
					if (i > 1 && i * i != v) {
						result += v / i;
					}
				}
			}
			return result;
		}
	}

}
