package bean17.cha;

import java.io.File;
import java.util.Arrays;

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

 * key for security, but short enough to be memorable.
 * 
 * Your task has been made easy, as the encryption key consists of three lower
 * case characters. Using cipher.txt (right click and 'Save Link/Target As...'),
 * a file containing the encrypted ASCII codes, and the knowledge that the plain
 * text must contain common English words, decrypt the message and find the sum
 * of the ASCII values in the original text.
 * 
 */
public class Problem59 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Problem59().testXORDecryption();
	}

	private void testXORDecryption() {
		long start = System.currentTimeMillis();

		String path = "D:\\github\\projecteule\\files\\Problem59.txt";
		File file = new File(path);
		String all = Utils.readString(file);
		String[] contents = all.split(",");
		
		byte[] ciphers = new byte[contents.length];
		for (int i = 0; i < ciphers.length; i++) {
			ciphers[i] = new Byte(contents[i].trim());
		}

		final byte bs = 'a';
		final byte be = 'z';
		final byte ls = 'A';
		final byte le = 'Z';

		final int N = 26;
		final int KLEN = 3;
		
		byte[] keys = new byte[KLEN];
		char[] ckeys = new char[KLEN];

		int max = 0;
		int ascii = 0;
		byte[] messages = null;

		for (int i = 0; i < N; i++) {
			keys[0] = (byte) (bs + i);
			for (int j = 0; j < N; j++) {
				keys[1] = (byte) (bs + j);
				for (int j2 = 0; j2 < N; j2++) {
					keys[2] = (byte) (bs + j2);
					
					byte[] temps = XORDecryption(ciphers, keys);
					int c = 0;
					for (int k = 0; k < temps.length; k++) {
						if ((temps[k] >= bs && temps[k] <= be)
								|| (temps[k] >= ls && temps[k] <= le)) {
							c++;
						}
					}

					if (c >= max) {
						max = c;
						messages = temps;
						
						for (int k = 0; k < KLEN; k++) {
							ckeys[k] = (char) keys[k];
						}
					}
				}
			}
		}
		
		ascii = 0;
		for (int k = 0; k < messages.length; k++) {
			ascii += messages[k];
		}

		String message = new String(messages);
		System.out.println(message);
		System.out.println(Arrays.toString(ckeys));


		System.out.println("acsii = " + ascii);
		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
	}

	byte[] XORDecryption(byte[] ciphers, byte[] keys) {
		byte[] messages = new byte[ciphers.length];
		for (int i = 0; i < ciphers.length; i++) {
			messages[i] = (byte) (ciphers[i] ^ keys[i % keys.length]);
		}
		return messages;
	}
}
