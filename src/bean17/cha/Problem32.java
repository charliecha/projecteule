package bean17.cha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem32 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Problem32().pandigitalProducts();
	}

	private void pandigitalProducts() {
		long start = System.currentTimeMillis();

		int product;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 9; i++) {
			for (int j = 1234; j <= 9876; j++) {
				product = i * j;
				if (pandigital(i, j, product)) {
					if (!list.contains(product)) {
						list.add(product);
					}
				}
			}
		}

		for (int i = 12; i <= 98; i++) {
			for (int j = 123; j <= 987; j++) {
				product = i * j;
				if (pandigital(i, j, product)) {
					if (!list.contains(product)) {
						list.add(product);
					}
				}
			}
		}

		int result = 0;
		for (Integer integer : list) {
			result += integer;
		}
		System.out.println(result);

		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
	}

	private boolean pandigital(int multiplicand, int multiplier, int product) {
		StringBuilder builder = new StringBuilder();
		builder.append(multiplicand).append(multiplier).append(product);
		char[] chars = builder.toString().toCharArray();
		Arrays.sort(chars);

		boolean f = true;
		if (chars.length != 9) {
			f = false;
		} else {
			for (int i = 0; i < chars.length; i++) {
				if (chars[i] - '1' != i) {
					f = false;
					break;
				}
			}
		}
		return f;
	}
}
