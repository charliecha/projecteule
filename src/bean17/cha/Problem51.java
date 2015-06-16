package bean17.cha;

import java.util.Arrays;

/**
 * 
 * 
By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.

By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the first example having seven primes among the ten generated numbers, yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993. Consequently 56003, being the first member of this family, is the smallest prime with this property.

Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit, is part of an eight prime value family.
 * 
 * @author bean17.cha
 * 
 */
public class Problem51 {
	final int THOUSAND = 1000;
	final int TEN_THOUSAND = THOUSAND * 10;
	final int THUNDRED_THOUSAND = TEN_THOUSAND * 10;
	final int MILLION = THUNDRED_THOUSAND * 10;
	final int TARGET = 8;

	/**
	 * @param args
	 *            arguments
	 */
	public static void main(String[] args) {
		new Problem51().testPrimeDigitReplacements();
	}

	private void testPrimeDigitReplacements() {
		long start = System.currentTimeMillis();

		int s = 1001;
		boolean success = false;
		for (int i = s; !success; i += 2) {
			if (Utils.isPrime(i)) {
				if (has8DigitReplacements(i)) {
					System.out.println("I = " + i);
					success = true;
					break;
				}
			}
		}

		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
	}

	boolean has8DigitReplacements(int n) {
		if (n < THOUSAND) {
			return false;
		} else if (n < TEN_THOUSAND) {
			final char[] cs = Integer.valueOf(n).toString().toCharArray();
			final int length = cs.length;
			
			// check, excluding not satisfled condition
			char last = '#';
			boolean fail = false;
			for (int k = 0; k < length - 1; k++) {
				if ('#' == last) {
					last = cs[k];
				} else {
					if (cs[k] != last || cs[k] > '2') {
						fail = true;
						break;
					}
				}
			}

			if (fail) {
				return false;
			}
			
			char[] copied = Arrays.copyOf(cs, length);
			int c = 0;
			for (int l = 0; l <= 9; l++) {
				for (int k = 0; k < length - 1; k++) {
					copied[k] = (char) (int) ('0' + l);
				}
				
				int intValue = Integer.parseInt(new String(copied));
				if (THOUSAND < intValue && Utils.isPrime(intValue)) {
					c++;
				}
			}

			if (TARGET == c) {
				return true;
			}
			return false;
		} else if (n < THUNDRED_THOUSAND) {
			final char[] cs = Integer.valueOf(n).toString().toCharArray();
			final int length = cs.length;

			char[] copied = Arrays.copyOf(cs, length);
			for (int i = 0; i < length - 1; i++) {
				// check, excluding not satisfled condition
				char last = '#';
				boolean fail = false;
				for (int k = 0; k < length - 1; k++) {
					if (k != i) {
						if ('#' == last) {
							last = cs[k];
						} else {
							if (cs[k] != last || cs[k] > '2') {
								fail = true;
								break;
							}
						}
					}
				}

				if (fail) {
					continue;
				}

				copied[i] = cs[i];
				int c = 0;

				for (int l = 0; l <= 9; l++) {
					for (int k = 0; k < length - 1; k++) {
						if (k != i) {
							copied[k] = (char) (int) ('0' + l);
						}
					}
					int intValue = Integer.parseInt(new String(copied));
					if (TEN_THOUSAND < intValue && Utils.isPrime(intValue)) {
						c++;
					}
				}

				if (TARGET == c) {
					return true;
				}
			}
		} else if (n < MILLION) {
			final char[] cs = Integer.valueOf(n).toString().toCharArray();
			final int length = cs.length;

			char[] copied = Arrays.copyOf(cs, length);

			for (int i = 0; i < length - 1; i++) {
				copied[i] = cs[i];
				for (int j = 0; j < length - 1; j++) {
					if (j != i) {
						// check, excluding not satisfled condition
						char last = '#';
						boolean fail = false;
						for (int k = 0; k < length - 1; k++) {
							if (k != i && k != j) {
								if ('#' == last) {
									last = cs[k];
								} else {
									if (cs[k] != last || cs[k] > '2') {
										fail = true;
										break;
									}
								}
							}
						}

						if (fail) {
							continue;
						}

						copied[j] = cs[j];
						int c = 0;

						for (int l = 0; l <= 9; l++) {
							for (int k = 0; k < length - 1; k++) {
								if (k != i && k != j) {
									copied[k] = (char) (int) ('0' + l);
								}
							}

							int intValue = Integer.parseInt(new String(copied));
							if (THUNDRED_THOUSAND < intValue
									&& Utils.isPrime(intValue)) {
								c++;
							}

						}

						if (TARGET == c) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
