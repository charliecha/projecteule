package bean17.cha;


/**
 *
 Prime pair sets
 Problem 60
 The primes 3, 7, 109, and 673, are quite remarkable. By taking any two primes and concatenating them in any order the result will always be prime. For example, taking 7 and 109, both 7109 and 1097 are prime. The sum of these four primes, 792, represents the lowest sum for a set of four primes with this property.

 Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.
 * 
 */
public class Problem60 {
	final int N = 10000;
	long[] primes = new long[N];

	/**
	 * @param args argumens
	 */
	public static void main(String[] args) {
		new Problem60().testPrimePairSets();
	}

	private void testPrimePairSets() {
		long start = System.currentTimeMillis();

		long current = 0;
		for (int i = 0; i < 5; i++) {
			primes[i] = nextPrime(current);
			current = primes[i];
		}

		long result = 0;

		boolean find = false;
		for (int i = 5; !find; i++) {
			if (0 == primes[i]) {
				primes[i] = nextPrime(primes[i - 1]);
			}
			// System.out.println("i = " + i + " , prime = " + primes[i]);

			for (int j = i - 1; !find && j >= 0; j--) {
				if (isPrimeAfterConnected(primes[i], primes[j])) {
					for (int j2 = j - 1; !find && j2 >= 0; j2--) {
						if (isPrimeAfterConnected(primes[i], primes[j2])
								&& isPrimeAfterConnected(primes[j], primes[j2])) {
							for (int k = j2 - 1; !find && k >= 0; k--) {
								if (isPrimeAfterConnected(primes[i], primes[k])
										&& isPrimeAfterConnected(primes[j],
												primes[k])
										&& isPrimeAfterConnected(primes[j2],
												primes[k])) {
									for (int k2 = k - 1; /* !find && */ k2 >= 0; k2--) {
										if (isPrimeAfterConnected(primes[i],
												primes[k2])
												&& isPrimeAfterConnected(
														primes[j], primes[k2])
												&& isPrimeAfterConnected(
														primes[j2], primes[k2])
												&& isPrimeAfterConnected(
														primes[k], primes[k2])) {

											System.out
													.println("i = " + i
															+ " , prime = "
															+ primes[i]);
											System.out
													.println("j = " + j
															+ " , prime = "
															+ primes[j]);
											System.out.println("j2 = " + j2
													+ " , prime = "
													+ primes[j2]);
											System.out
													.println("k = " + k
															+ " , prime = "
															+ primes[k]);
											System.out.println("k2 = " + k2
													+ " , prime = "
													+ primes[k2]);

											find = true;
											result = primes[i] + primes[j]
													+ primes[j2] + primes[k]
													+ primes[k2];
											break;
										}
									}
								}
							}
						}
					}
				}
			}
		}

		System.out.println("result = " + result);

		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
	}

	long nextPrime(long current) {
		long next = current + 1;
		while (!Utils.isPrime(next)) {
			next++;
		}
		return next;
	}

	boolean isPrimeAfterConnected(long n1, long n2) {
		long l1 = Long.parseLong(n1 + "" + n2);
		long l2 = Long.parseLong(n2 + "" + n1);
		return Utils.isPrime(l1) && Utils.isPrime(l2);
	}
}
