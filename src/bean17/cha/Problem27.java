package bean17.cha;

public class Problem27 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Problem27().testQuadraticPrimes();
	}

	private void testQuadraticPrimes() {
		long start = System.currentTimeMillis();

		int a = 0;
		int b = 0;
		int n = 0;
		int maxPrimes = 0;
		int quadratic;

		for (int i = -1000 + 1; i < 1000; i++) {
			for (int j = -1000 + 1; j < 1000; j++) {
				n = 0;
				quadratic = n * n + i * n + j;
				while (isPrime(quadratic)) {
					n++;
					quadratic = n * n + i * n + j;
				}

				if (n > maxPrimes) {
					a = i;
					b = j;
					maxPrimes = n;
				}
			}
		}

		System.out.println("a = " + a + ", b = " + b + ", maxPrimes = "
				+ maxPrimes + ",ab = " + (a * b));
		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
	}

	private boolean isPrime(final int n) {
		if (n <= 1) {
			return false;
		}

		boolean isPrime = true;
		for (int i = 2; i * i <= n; i++) {
			if (0 == n % i) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
}
