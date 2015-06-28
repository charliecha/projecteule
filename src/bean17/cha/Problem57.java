package bean17.cha;

import java.math.BigInteger;

/**
 * Square root convergents Problem 57 It is possible to show that the square
 * root of two can be expressed as an infinite continued fraction.
 * 
 * �� 2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...
 * 
 * By expanding this for the first four iterations, we get:
 * 
 * 1 + 1/2 = 3/2 = 1.5 1 + 1/(2 + 1/2) = 7/5 = 1.4 1 + 1/(2 + 1/(2 + 1/2)) =
 * 17/12 = 1.41666... 1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...
 * 
 * The next three expansions are 99/70, 239/169, and 577/408, but the eighth
 * expansion, 1393/985, is the first example where the number of digits in the
 * numerator exceeds the number of digits in the denominator.
 * 
 * In the first one-thousand expansions, how many fractions contain a numerator
 * with more digits than denominator?
 * 
 * @author bean17.cha
 */
public class Problem57 {
	final int N = 1000;

	/**
	 * @param args
	 *            arguments
	 */
	public static void main(String[] args) {
		new Problem57().testLychrelNumbers();
	}

	private void testLychrelNumbers() {
		long start = System.currentTimeMillis();

		int c = 0;

		Fraction oldFraction = new Fraction(BigInteger.ONE, BigInteger.ONE);
		Fraction newFraction;
		for (int i = 0; i < N; i++) {
			newFraction = oldFraction.add(1).reverse().add(1);
			oldFraction = newFraction;

			int numerator = String.valueOf(newFraction.numerator).length();
			int denominator = String.valueOf(newFraction.denominator).length();
			if (numerator > denominator) {
				c++;
			}

			// System.out.println(newFraction);
		}

		System.out.println("c = " + c);
		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
	}

	double sqrt(final int n) {
		double old = 1;
		double new1 = 1 + (n - 1) / (1 + old);
		double interval = 0.000001;
		while (Double.compare(Math.abs(old - new1), interval) >= 0) {
			old = new1;
			new1 = 1 + (n - 1) / (1 + old);
		}
		return new1;
	}
}