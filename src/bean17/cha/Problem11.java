package bean17.cha;

import java.io.File;

public class Problem11 {
	/**
	 * @param args arguments
	 */
	public static void main(String[] args) {
		new Problem11().LargestProduct();
	}

	private void LargestProduct() {
		long max = 0;

		File file = new File(
				"/Users/chinda/git/projecteule/files/Problem11.txt");
		String[] lines = Utils.readStringArray(file);
		
		long start = System.currentTimeMillis();
		if (null != lines && 0 != lines.length) {
			int rowCount = lines.length;
			String[] row = lines[0].split("\\s");
			int colCount;
//			if (null != row) {
				colCount = row.length;
//			}

			if (0 < rowCount && 0 < colCount) {
				int[][] data = new int[rowCount][colCount];
				for (int i = 0; i < rowCount; i++) {
					String[] temp = lines[i].split("\\s");
					if (/*null != temp && */ temp.length == colCount) {
						for (int j = 0; j < colCount; j++) {
							data[i][j] = Integer.parseInt(temp[j]);
						}
					}
				}

				int count = 4;
				for (int i = 0; i < rowCount - count; i++) {
					for (int j = 0; j < colCount - count; j++) {
						long horizon = 1;
						long vertical = 1;
						long diagonal1 = 1;
						long diagonal2 = 1;
						for (int k = 0; k < count; k++) {
							horizon *= data[i][j + k];
							vertical *= data[i + k][j];
							diagonal1 *= data[i + k][j + k];
							diagonal2 *= data[i + k][j + count - k];
						}
						if (horizon > max) {
							max = horizon;
						}
						if (vertical > max) {
							max = vertical;
						}
						if (diagonal1 > max) {
							max = diagonal1;
						}

						if (diagonal2 > max) {
							max = diagonal2;
						}
					}
				}
			}
		}

		System.out.println("max = " + max);
		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
	}
}
