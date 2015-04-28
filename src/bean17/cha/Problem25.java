package bean17.cha;

import java.math.BigInteger;

public class Problem25 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Problem25().fibonacci();
	}

	private void fibonacci() {
		long start = System.currentTimeMillis();

		BigInteger f1 = BigInteger.ONE;
		BigInteger f2 = BigInteger.ONE;

		int n = 1000;
		BigInteger max = BigInteger.TEN.pow(n - 1);
		int index = 2;

		BigInteger f3 = f1.add(f2);
		while (f3.compareTo(max) < 0) {
			index++;
			f1 = f2;
			f2 = f3;
			f3 = f1.add(f2);
		}

		System.out.println("index = " + (index + 1));
		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
	}
}
