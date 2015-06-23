package bean17.cha;


/**
 * 
 XOR decryption Problem 59 Each character on a computer is assigned a unique
 * code and the preferred standard is ASCII (American Standard Code for
 * Information Interchange). For example, uppercase A = 65, asterisk (*) = 42,
 * and lowercase k = 107.
 * 
 * A modern encryption method is to take a text file, convert the bytes to
 * ASCII, then XOR each byte with a given value, taken from a secret key. The
 * advantage with the XOR function is that using the same encryption key on the
 * cipher text, restores the plain text; for example, 65 XOR 42 = 107, then 107
 * XOR 42 = 65.
 * 
 * For unbreakable encryption, the key is the same length as the plain text
 * message, and the key is made up of random bytes. The user would keep the
 * encrypted message and the encryption key in different locations, and without
 * both "halves", it is impossible to decrypt the message.
 * 
 * Unfortunately, this method is impractical for most users, so the modified
 * method is to use a password as a key. If the password is shorter than the
 * message, which is likely, the key is repeated cyclically throughout the
 * 
 * key for security, but short enough to be memorable.
 * 
 * Your task has been made easy, as the encryption key consists of three lower
 * case characters. Using cipher.txt (right click and 'Save Link/Target As...'),
 * a file containing the encrypted ASCII codes, and the knowledge that the plain
 * text must contain common English words, decrypt the message and find the sum
 * of the ASCII values in the original text.
 * 
 */
public class Problem60 {
	final int N = 10000;
	long[] primes = new long[N];

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Problem60().testXORDecryption();
	}

	private void testXORDecryption() {
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
									for (int k2 = k - 1; !find && k2 >= 0; k2--) {
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
