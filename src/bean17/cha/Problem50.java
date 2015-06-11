package bean17.cha;

/**
 * 
 * 
 The prime 41, can be written as the sum of six consecutive primes:
 * 
 * 41 = 2 + 3 + 5 + 7 + 11 + 13 This is the longest sum of consecutive primes
 * that adds to a prime below one-hundred.
 * 
 * The longest sum of consecutive primes below one-thousand that adds to a
 * prime, contains 21 terms, and is equal to 953.
 * 
 * Which prime, below one-million, can be written as the sum of the most
 * consecutive primes?
 * 
 * @author bean17.cha
 * 
 */
public class Problem50 {
	final int N = 1000000;
	final int[] primes = new int[N];

	/**
	 * @param args
	 *            arguments
	 */
	public static void main(String[] args) {
		new Problem50().testConsecutivePrimeSum();
	}

	private void testConsecutivePrimeSum() {
		long start = System.currentTimeMillis();

		int max = 0;
		int index = 0;
		int count = 0;

		for (int i = 2; i < N; i++) {
			if (Utils.isPrime(i)) {
				primes[index++] = i;
				count += i;
			}
			if (count > N) {
				break;
			}
		}

		final int len = index;

		System.out.println("len = " + len);
		for (int i = len; i > 0 && 0 == max; i--) {
			for (int j = 0; j <= len - i; j++) {
				count = 0;
				for (int j2 = j; j2 < j + i; j2++) {
					count += primes[j2];
					if (count >= N) {
						break;
					}
				}

				if (count >= N) {
					break;
				} else {
					if (Utils.isPrime(count)) {
						if (i > max) {
							max = i;
							System.out.println("j = " + j + ", i = " + i
									+ " , prime " + count);
							break;
						}
					}
				}
			}
		}

		System.out.println("max = " + max);
		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
	}
}
