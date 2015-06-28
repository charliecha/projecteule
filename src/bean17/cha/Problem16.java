package bean17.cha;

import java.math.BigInteger;

public class Problem16 {

	/**
	 * @param args arguments
	 */
	public static void main(String[] args) {
		new Problem16().powerDigitSum();
	}

	private void powerDigitSum(){
		long start = System.currentTimeMillis();
		
		BigInteger bigInteger = BigInteger.ONE;
		bigInteger = bigInteger.shiftLeft(1000);
		
		int digit = 0;
		String s = bigInteger.toString();
		for (int i = 0; i < s.length(); i++) {
			digit += s.charAt(i) - '0';
		}
		
		
		System.out.println("digit = " + digit);
		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
	}
}
