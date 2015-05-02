package bean17.cha;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class Problem29 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Problem29().distinctPowers();
	}

	private void distinctPowers() {
		long start = System.currentTimeMillis();

		final int n = 100;
		ArrayList<BigInteger> list = new ArrayList<BigInteger>();
		for (int i = 2; i <= n; i++) {
			for (int j = 2; j <= n; j++) {
				BigInteger bigInteger = BigInteger.valueOf(i).pow(j);
				int index = Collections.binarySearch(list, bigInteger);
				if (index < 0) {
					list.add(-index - 1, bigInteger);
				}
			}
		}

		System.out.println(list.size());
		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
	}
}
