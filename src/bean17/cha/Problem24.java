package bean17.cha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem24 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Problem24().permutation();
	}

	private void permutation() {
		long start = System.currentTimeMillis();
		
		int match = 1000000;
		boolean success = false;
		
		final int n = 10;
		List<Integer> list = new ArrayList<Integer>();		
		for (int i = 0; i < n ;i++) {
			list.add(i);
		}
		
		if (match > permutation(n)) {
			System.out.println("fail");
		}
		
	    List<Integer> resultList = new ArrayList<Integer>();
		int count = 0;
		while (list.size() > 1 && !success) {
			final int n1 = list.size() - 1;
			final int p1 = permutation(n1);
			for (int i = 0; i < list.size(); i++) {
				int p2 = p1 * (i + 1);
				if (match == count + p2) {
					// reverse get
					success = true;
					
					count += p1 * i;
					resultList.add(list.get(i));
					list.remove(i);
					break;
				} else if (match < count + p2) {
					count += p1 * i;
					resultList.add(list.get(i));
					list.remove(i);
					break;
				}
			}
		}
		if (success) {
			if (!list.isEmpty()) {
				for (int i = list.size() - 1; i >= 0; i--) {
					resultList.add(list.get(i));
				}
			}
			
			System.out.println(Arrays.toString(resultList.toArray()));
		}
		
		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
	}

	private int permutation(int n) {
		int result = 1;
		for (int i = n; i > 1; i--) {
			result *= i;
		}
		return result;
	}
}
