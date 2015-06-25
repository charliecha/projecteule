package bean17.cha;

import java.math.BigInteger;

/**
 * 
 * Powerful digit counts Problem 63 The 5-digit number, 16807=75, is also a
 * fifth power. Similarly, the 9-digit number, 134217728=89, is a ninth power.
 * 
 * How many n-digit positive integers exist which are also an nth power?
 * 
 * @author bean17.cha@gmail.com
 * 
 */

public class Problem63 {

	final int LESS = 1;
	final int EQUAL = 2;
	final int LARGE = 3;

	/**
	 * @param args
	 *            arguments
	 */
	public static void main(String[] args) {
		new Problem63().testPowerfulDigitCounts();
	}

	private void testPowerfulDigitCounts() {
		long start = System.currentTimeMillis();

		int c = 0;

		int digits = 1;
		boolean exit = false;

		while (!exit) {
			for (int i = 1; i <= 9; i++) {
				BigInteger value = pow(i, digits);
				int compare = compare(value, digits);
				if (EQUAL == compare) {
					c++;
				} else if (9 == i && LESS == compare) {
					exit = true;
					break;
				}
			}
			digits++;
		}

		System.out.println("c = " + c);
		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
	}

	int compare(final BigInteger value, final int digits) {
		int vDigits = String.valueOf(value).length();
		return vDigits == digits ? EQUAL : (vDigits < digits ? LESS : LARGE);
	}

	BigInteger pow(final int n, final int m) {
		BigInteger result = BigInteger.ONE;
		for (int i = 0; i < m; i++) {
			result = result.multiply(BigInteger.valueOf(n));
		}
		return result;
	}
}
