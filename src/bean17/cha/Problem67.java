package bean17.cha;

import java.io.File;

public class Problem67 {
	/**
	 * @param args arguments
	 */
	public static void main(String[] args) {
		new Problem67().MaximumPathSum();
	}

	private void MaximumPathSum() {
		long max = 0;

		File file = new File(
				"/Users/chinda/git/projecteule/files/Problem67.txt");
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
