package bean17.cha;

import java.io.File;

/**
 *Maximum path sum I
 Problem 18
 By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

 3
 7 4
 2 4 6
 8 5 9 3

 That is, 3 + 7 + 4 + 9 = 23.

 Find the maximum total from top to bottom of the triangle below:

 75
 95 64
 17 47 82
 18 35 87 10
 20 04 82 47 65
 19 01 23 75 03 34
 88 02 77 73 07 63 67
 99 65 04 28 06 16 70 92
 41 41 26 56 83 40 80 70 33
 41 48 72 33 47 32 37 16 94 29
 53 71 44 65 25 43 91 52 97 51 14
 70 11 33 28 77 73 17 78 39 68 17 57
 91 71 52 38 17 14 91 43 58 50 27 29 48
 63 66 04 68 89 53 67 30 73 16 69 87 40 31
 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23

 NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. However, Problem 67, is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)
 * @author bean17.cha@gmail.com
 */
public class Problem18 {
	/**
	 * @param args arguments
	 */
	public static void main(String[] args) {
		new Problem18().MaximumPathSum();
	}

	private void MaximumPathSum() {
		long max = 0;

		File file = new File("files/Problem18.txt");
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
