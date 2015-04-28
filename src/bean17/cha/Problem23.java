package bean17.cha;

import java.util.Arrays;

/**
 * Non-abundant sums
 * @author chinda
 *
 */
public class Problem23 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Problem23().abundant();
	}

	private void abundant() {
		long start = System.currentTimeMillis();

		final int n = 28123;

		boolean[] abundant = new boolean[n + 1];

		boolean[] twoAbundant = new boolean[n + 1];

		Arrays.fill(abundant, false);
		Arrays.fill(twoAbundant, false);

		for (int i = 12; i <= n; i++) {
			if (factorSum(i) > i) {
				abundant[i] = true;
			}
		}

		for (int i = 12; i <= n; i++) {
			if (abundant[i]) {
				for (int j = i; j <= n; j++) {
					if (abundant[j]) {
						if (i + j <= n) {
							twoAbundant[i + j] = true;
						}
					}
				}
			}
		}

		int result = 0;
		for (int i = 1; i <= n; i++) {
			if (!twoAbundant[i]) {
				result += i;
			}
		}
		System.out.println("result = " + result);

		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
	}

	private int factorSum(int value) {
		int result = 0;
		for (int i = 1; i * i <= value; i++) {
			if (0 == value % i) {
				result += i;

				if (i > 1 && i * i != value) {
					result += value / i;
				}
			}
		}
		return result;
	}
}
