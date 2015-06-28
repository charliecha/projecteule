package bean17.cha;

import java.io.File;
import java.util.Arrays;


public class Problem22 {
	/**
	 * @param args arguments
	 */
	public static void main(String[] args) {
		new Problem22().namesScores();
	}
	
	private void namesScores(){
		long start = System.currentTimeMillis();
		
		File file = new File("/Users/chinda/git/projecteule/files/Problem22.txt");
		String name = Utils.readString(file);
		String[] names = name.split(",");
		Arrays.sort(names);
		
		long result = 0;
		for (int i = 0; i < names.length; i++) {
			result += alphabeticalValue(names[i]) * (i + 1);
		}
		
//		System.out.println(Arrays.toString(names));
		
		System.out.println("result = " + result);
		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
	}
	
	private int alphabeticalValue(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				count += c - 'A' + 1;
			}
		}
		return count;
	}
}
