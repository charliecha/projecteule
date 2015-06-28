package bean17.cha;

import java.io.File;

/**
 Special Pythagorean triplet
 Problem 9
 A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

 a2 + b2 = c2
 For example, 32 + 42 = 9 + 16 = 25 = 52.

 There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 Find the product abc.
 * @author bean17.cha@gmail.com
 */
public class Problem9 {
	final int N = 1000;
	/**
	 * @param args arguments
	 */
	public static void main(String[] args) {
		new Problem9().specialPythagoreanTriplet();
	}

	private void specialPythagoreanTriplet(){
		long start = System.currentTimeMillis();

		int b;
		int square;
		int product = 0;

		for (int i = N / 3 + 1; 0 == product && i < N / 2; i++) {
			for (int j = 1; j < N / 3; j++) {
				b = N - i - j;

				if (b >= i){
					continue;
				}

				square = b * b + j * j - i * i;
				if (0 == square){
					product = i * j * b;
					break;
				}
			}
		}

		System.out.println("product = " + product);
		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
	}
}
