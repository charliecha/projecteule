package bean17.cha;

import java.io.File;
import java.util.Arrays;

/**
 * Names scores
 Problem 22
 Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

 For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

 What is the total of all the name scores in the file?
 @author bean17.cha@gmail.com
 */
public class Problem22 {
	/**
	 * @param args arguments
	 */
	public static void main(String[] args) {
		new Problem22().namesScores();
	}
	
	private void namesScores(){
		long start = System.currentTimeMillis();
		
		File file = new File("files/Problem22.txt");
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
