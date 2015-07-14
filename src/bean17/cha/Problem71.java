package bean17.cha;

import java.util.List;

/**
 * Ordered fractions Problem 71 Consider the fraction, n/d, where n and d are
 * positive integers. If n<d and HCF(n,d)=1, it is called a reduced proper
 * fraction.
 * 
 * If we list the set of reduced proper fractions for d ≤ 8 in ascending order
 * of size, we get:
 * 
 * 1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3,
 * 5/7, 3/4, 4/5, 5/6, 6/7, 7/8
 * 
 * It can be seen that 2/5 is the fraction immediately to the left of 3/7.
 * 
 * By listing the set of reduced proper fractions for d ≤ 1,000,000 in ascending
 * order of size, find the numerator of the fraction immediately to the left of
 * 3/7. 
 * /**
 * 
 * @author bean17.cha@gmail.com
 */
public class Problem71 {
	final int N = 1000000;
	final int NUMERATOR = 3;
	final int DENOMINATOR = 7;

	double max = 0D;
	long n;
	long m;

	/**
	 * @param args
	 *            arguments
	 */
	public static void main(String[] args) {
		new Problem71().orderedFractions();
	}

	private void orderedFractions() {
		long start = System.currentTimeMillis();

		final long sqrt = Utils.sqrt(N);
		List<Long> lessThanSqrt = Utils.primeFactor(2, sqrt);

		for (int i = 1; i <= N; i++) {
			long ni = 1L * i * NUMERATOR / DENOMINATOR;
			while (1 != HCF(lessThanSqrt, ni, i)) {
				ni--;
			}

			if (NUMERATOR != ni || DENOMINATOR != i) {
				double f = 1D * ni / i;
				if (Double.compare(f, max) > 0) {
					max = f;
					this.n = ni;
					this.m = i;

//					System.out.println("n = " + n + " , m = " + m
//							+ ", fraction = " + max);
				}
			}
		}

		System.out.println("n = " + n + " , m = " + m + ", fraction = " + max);
		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
	}

	long HCF(List<Long> list, long n1, long n2) {
		long min = Math.min(n1, n2);
		if (0 == min) {
			return 1;
		}

		long max = Math.max(n1, n2);
		if (0 == max % min) {
			return min;
		}

		long sqrt = Utils.sqrt(min);
		for (int i = 0; i < list.size(); i++) {
			long prime = list.get(i);
			if (0 == min % prime) {
				if (0 == max % prime) {
					return prime;
				} else {
					long remains = min / prime;
					if (0 == max % remains) {
						return remains;
					}
				}
			} else if (prime > sqrt) {
				return 1;
			}
		}
		return 1;
	}
}
