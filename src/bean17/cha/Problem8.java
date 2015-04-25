package bean17.cha;

import java.io.File;

public class Problem8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Problem8().largestProduct();
	}

	private void largestProduct(){
		long start = System.currentTimeMillis();
		
		File file = new File("D:\\github\\projecteule-master\\files\\Problem8.txt");
		String source = Utils.readString(file);
		
		int length = source.length();
		
		final int digits  = 13;
		long max = 0;
		long temp = 0;
		int index = 0;
		
		for (int i = 0; i < length - digits ; i++) {
			temp = 1;
			for (int j = 0; j < digits; j++) {
				temp *= source.charAt(i + j) - '0';
			}
			if (temp > max) {
				max = temp;
				index = i;
			}
		}

		
		System.out.println("max = " + max + " ,index = " + index);
		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
	}
}
