package bean17.cha;

public class Problem44 {
	final int N = 100001;
	long[] pentagonNumbers = new long[N];

	/**
	 * @param args
	 *            arguments
	 */
	public static void main(String[] args) {
		new Problem44().testPentagonNumbers();
	}

	private void testPentagonNumbers() {
		long start = System.currentTimeMillis();

		long min = 0;
		for (int i = 1; i < N && 0 == min; i++) {
			if (0 == pentagonNumbers[i]) {
				pentagonNumbers[i] = computePentagonNumber(i);
			}

/*			int end = 0;
			for (int j = i + 1; j < N; j++) {
				if (0 == pentagonNumbers[j]) {
					pentagonNumbers[j] = computePentagonNumber(j);
				}
				if (pentagonNumbers[j] - pentagonNumbers[j - 1] > pentagonNumbers[i]) {
					end = j;
					break;
				}
			}*/

			for (int j = 1; j < i; j++) {
				long n1 = pentagonNumbers[j] + pentagonNumbers[i];
				if (isPentagonNumber(n1)) {
					long n1_plus_2 = n1 + pentagonNumbers[j];
					if (isPentagonNumber(n1_plus_2)) {
						min = pentagonNumbers[i];
						System.out.println("n1-2 = " + pentagonNumbers[i]
								+ ",n2 = " + pentagonNumbers[j] + ",n1 = " + n1
								+ " , n1+2 = " + n1_plus_2);
						System.out.println("i = " + i +" , j = " + j);
						break;
					}
				}
			}
		}

		System.out.println("min = " + min);
		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
	}

	long computePentagonNumber(long i) {
		if (0 < i) {
			return i * (i * 3 - 1) / 2;
		}
		return 0;
	}

	boolean isPentagonNumber(long n) {
		long n2 = n * 24 + 1;
		long sqrt = (int) Math.sqrt(n2 + 0.1);
		if (sqrt * sqrt != n2) {
			return false;
		}
		return 0 == (sqrt + 1) % 6;
	}
}
