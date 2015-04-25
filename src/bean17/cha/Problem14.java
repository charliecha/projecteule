package bean17.cha;

import java.util.Arrays;

public class Problem14 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Problem14().largest();
	}
	
	protected void largest() {
		long start = System.currentTimeMillis();
		
		final int max = 1000000;
		final int[] cached = new int[max];
		Arrays.fill(cached, 0);
		
		int largest = 0;
		int startIndex = 0;
		for (int i = 1; i < max; i++) {
			int length = length(i, cached);
			if (length > largest) {
				largest = length;
				startIndex = i;
			}
		}
		System.out.println("largest = " + largest + " ,start = " + startIndex);
		
		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
	}
	
	/**
	 * n ¡ú n/2 (n is even)
     * n ¡ú 3n + 1 (n is odd)
	 * @param n
	 * @return
	 */
	private int length(final int n, final int[] cached){
		if (1 == n) {
			return 0;
		} else {
			if (n < cached.length && cached[n] > 0) {
				return cached[n];
			}
			
			int result = 0;
			long v = n;
			while (1 != v) {
				if (0 == v % 2) {
					v = v / 2;
				} else {
					v = v * 3 + 1;
				}
				result += 1;
				
				if (v < cached.length && cached[(int)v] > 0) {
					result +=  cached[(int)v];
					break;
				}
			}
			
			if (n < cached.length) {
				cached[n] = result;
			}
			return result;
		}
	}

}
