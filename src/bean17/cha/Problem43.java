package bean17.cha;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem43 {
	final int TEN = 10;
	final Integer[] digits = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	final int[] primes = { 2, 3, 5, 7, 11, 13, 17 };

	/**
	 * @param args
	 *            arguments
	 */
	public static void main(String[] args) {
		new Problem43().testSubstringDivisibility();
	}

	private void testSubstringDivisibility() {
		long start = System.currentTimeMillis();
		final int len = 3;

		int count = 0;
		long sum = 0;
		
		int size;
		int index;
		
		Stack<List<Integer>> stack = new Stack<List<Integer>>();
		for (int i = 1; i <= 9; i++) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(i);
			stack.push(list);
		}


		while (!stack.isEmpty()) {
			List<Integer> popList = stack.pop();
			if (TEN != popList.size()) {
				List<Integer>[] array = generateSubList(popList);
				for (List<Integer> list : array) {
					size = list.size();
					if (size >= 4) {
						index = size - 3;
						if (isDivisible(list, index, len, index - 1)) {
							stack.push(list);
						}
					} else {
						stack.push(list);
					}
				}
			} else {
				StringBuilder builder = new StringBuilder();
				for (int i = 0; i < TEN; i++) {
					builder.append(popList.get(i));
				}
				long value = Long.parseLong(builder.toString());
				sum += value;
				count++;
			}
		}

		System.out.println("count = " + count + " ,sum = " + sum);
		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
	}

	@SuppressWarnings("unchecked")
	List<Integer>[] generateSubList(List<Integer> parent) {
		if (TEN > parent.size()) {
			int subChilds = TEN - parent.size();
			List<Integer>[] array = new List[subChilds];
			for (int i = 0; i < array.length; i++) {
				array[i] = new ArrayList<Integer>(parent);
			}
			int subIndex = 0;
			for (Integer i : digits) {
				if (!parent.contains(i)) {
					array[subIndex++].add(i);
				}
			}
			return array;
		} else {
			return null;
		}
	}

	boolean isDivisible(List<Integer> list, int start, int length, int offset) {
		StringBuilder builder = new StringBuilder();
		for (int i = start; i < start + length; i++) {
			builder.append(list.get(i));
		}
		int value = Integer.parseInt(builder.toString());
		return 0 == value % primes[offset];
	}
}
