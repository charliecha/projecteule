package bean17.cha;

import java.io.File;
import java.math.BigInteger;

public class Problem13 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Problem13().largeSum();
	}

	private void largeSum() {
		long start = System.currentTimeMillis();

		File file = new File(
				"D:\\github\\projecteule-master\\files\\Problem13.txt");
		String[] arr = Utils.readStringArray(file);

		BigInteger sum = BigInteger.ZERO;
		if (null != arr && 0 != arr.length) {
			for (int i = 0; i < arr.length; i++) {
				sum = sum.add(new BigInteger(arr[i]));
			}
		}

		System.out.println("sum = " + sum.toString().substring(0, 10));
		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
	}
}