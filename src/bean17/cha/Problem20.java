package bean17.cha;

import java.math.BigInteger;

public class Problem20 {
	/**
	 * @param args arguments
	 */
	public static void main(String[] args) {
		new Problem20().factorialDigitSum();
	}
	
	private void factorialDigitSum(){
		long start = System.currentTimeMillis();
		
		BigInteger bigInteger = BigInteger.ONE;
		for (int i = 1; i <= 100; i++) {
			bigInteger = bigInteger.multiply(new BigInteger(String.valueOf(i)));
		}
		
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
