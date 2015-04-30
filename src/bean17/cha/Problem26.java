package bean17.cha;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem26 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Problem26().testReciprocalCycles();
	}

	private void testReciprocalCycles() {
		long start = System.currentTimeMillis();

		final int n = 1000;
		int max = 0;
		int index = 0;
		for (int i = 2; i < n; i++) {
			int r = reciprocalCycles(i);
			if (r > max) {
				max = r;
				index = i;
			}
		}

		System.out.println("index = " + index + ", longest = " + max);
		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
	}

	private int reciprocalCycles(final int n0) {
		int n = n0;
		while (0 == n % 2) {
			n /= 2;
		}
		while (0 == n % 5) {
			n /= 5;
		}
		if (1 == n) {
			return 0;
		}

		int denominator = 1;
		List<Integer> denominators = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		int current;
		do {
			denominators.add(denominator);
			current = denominator;
			int zero = 0;
			while (current < n0) {
				current *= 10;
				zero++;
			}

			map.put(denominator, zero);
			denominator = current % n0;
		} while (!denominators.contains(denominator));

		int count = 0;
		for (int i = denominators.size() - 1; i >= 0; i--) {
			count += map.get(denominators.get(i));
			if (denominator == denominators.get(i)) {
				break;
			}
		}
		return count;
	}
}
