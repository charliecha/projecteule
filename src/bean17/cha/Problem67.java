package bean17.cha;

import java.io.File;

/**
 * Maximum path sum II
 Problem 67
 By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

 3
 7 4
 2 4 6
 8 5 9 3

 That is, 3 + 7 + 4 + 9 = 23.

 Find the maximum total from top to bottom in triangle.txt (right click and 'Save Link/Target As...'), a 15K text file containing a triangle with one-hundred rows.

 NOTE: This is a much more difficult version of Problem 18. It is not possible to try every route to solve this problem, as there are 299 altogether! If you could check one trillion (1012) routes every second it would take over twenty billion years to check them all. There is an efficient algorithm to solve it. ;o)
 @author bean17.cha@gmail.com
 */
public class Problem67 {
	/**
	 * @param args arguments
	 */
	public static void main(String[] args) {
		new Problem67().MaximumPathSum();
	}

	private void MaximumPathSum() {
		long max = 0;

		File file = new File("files/Problem67.txt");
		String[] lines = Utils.readStringArray(file);
		
		long start = System.currentTimeMillis();
		if (null != lines && 0 != lines.length) {
			final int rowCount = lines.length;
			int[][] data = new int[rowCount][];
			
			for (int i = 0; i < rowCount; i++) {
				String[] col = lines[i].split("\\s");
				final int colCount = col.length;
				data[i] = new int[colCount];
				for (int j = 0; j < colCount; j++) {
					data[i][j] = Integer.parseInt(col[j]);
					
					if (0 != i) {
						if (0 == j) {
							data[i][j] += data[i-1][j];
						} else if (colCount - 1 == j) {
							data[i][j] += data[i-1][j-1];
						} else {
							data[i][j] +=  Math.max(data[i-1][j-1], data[i-1][j]);
						}
					}
				}
			}
			
			for (int i = 0; i < data[rowCount - 1].length; i++) {
				if (data[rowCount - 1][i] > max) {
					max = data[rowCount - 1][i];
				}
			}
		}

		System.out.println("max = " + max);
		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
	}
}
