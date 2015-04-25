package bean17.cha;

public class Problem15 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		final int row = 20;
		long[][] path = new long[row + 1][row + 1];
		long count = new Problem15().latticePaths(row, row, path);
		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");

		System.out.println(count);
	}

	private long latticePaths(int row, int col, long[][] path) {
		if (0 == row && 0 == col) {
			return 0;
		} else if (0 == row && col != 0) {
			return 1;
		} else if (0 != row && 0 == col) {
			return 1;
		} else {
			if (path[row][col] > 0) {
				return path[row][col];
			} else {
				long p = latticePaths(row - 1, col, path)
						+ latticePaths(row, col - 1, path);
				path[row][col] = p;
				return p;
			}
		}
	}
}
