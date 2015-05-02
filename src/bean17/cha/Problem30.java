package bean17.cha;

import java.util.ArrayList;
import java.util.List;

public class Problem30 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Problem30().digitFifthPowers();
	}

	private void digitFifthPowers() {
		long start = System.currentTimeMillis();

		final int n = 5;
		final int max = pow(10, n + 1);

		List<Integer> list = new ArrayList<Integer>();
		for (int i = 10; i < max; i++) {
			int result = 0;
			
			int value = i;
			int remainder;

			remainder = value % 10;
			value /= 10;

			while (value != 0) {
				result += pow(remainder, n);

				remainder = value % 10;
				value /= 10;
			}

			result += pow(remainder, n);
			if (result == i) {
				list.add(i);
			}
		}

//		System.out.println(Arrays.toString(list.toArray()));

		int result = 0;
		for (int i = 0; i < list.size(); i++) {
			result += list.get(i);
		}

		System.out.println("result = " + result);
		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
	}

	private int pow(int n, int c) {
		if (0 == c) {
			return 1;
		} else {
			int result = 1;
			for (int i = 0; i < c; i++) {
				result *= n;
			}
			return result;
		}
	}
}
