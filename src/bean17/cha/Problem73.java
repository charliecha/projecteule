package bean17.cha;

import java.util.List;

/**
 Counting fractions in a range
 Problem 73
 Consider the fraction, n/d, where n and d are positive integers. If n<d and HCF(n,d)=1, it is called a reduced proper fraction.

 If we list the set of reduced proper fractions for d ≤ 8 in ascending order of size, we get:

 1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8

 It can be seen that there are 3 fractions between 1/3 and 1/2.

 How many fractions lie between 1/3 and 1/2 in the sorted set of reduced proper fractions for d ≤ 12,000?
 * /**
 * @author bean17.cha@gmail.com
 */
public class Problem73 {
	final int N = 12000;
	final int MAX_NUMERATOR = 1;
	final int MAX_DENOMINATOR = 2;

	final int MIN_NUMERATOR = 1;
	final int MIN_DENOMINATOR = 3;

	/**
	 * @param args
	 *            arguments
	 */
	public static void main(String[] args) {
		new Problem73().countingFractions();
	}

	private void countingFractions() {
		long start = System.currentTimeMillis();

		final long sqrt = Utils.sqrt(N);
		List<Long> lessThanSqrt = Utils.primeFactor(2, sqrt);
		int c = 0;

		for (int i = 2; i <= N; i++) {
			int min = i * MIN_NUMERATOR / MIN_DENOMINATOR - 1;
			int max = i * MAX_NUMERATOR / MAX_DENOMINATOR + 1;

			for (int j = min; j <= max ; j++) {
				if (1 == HCF(lessThanSqrt,i , j)){
					if (j * MIN_DENOMINATOR  > i * MIN_NUMERATOR
							&& j * MAX_DENOMINATOR  < i * MAX_NUMERATOR){
//						System.out.println("j = " + j + ", i = " + i);
						c++;
					}
				}
			}
		}

		System.out.println("count = " + c);
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
