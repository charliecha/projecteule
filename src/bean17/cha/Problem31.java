package bean17.cha;

public class Problem31 {
	final int N = 8;
	final int[] units = new int[] { 1, 2, 5, 10, 20, 50, 100, 200 };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Problem31().coinSums();
	}

	private void coinSums() {
		long start = System.currentTimeMillis();

		int goal = 200;
		int result = coin(N, goal);

		System.out.println("result = " + result);
		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
	}

	/**
	 * 硬币之和
	 * @param index 索引值
	 * @param goal 目标值
	 * @return 硬币组合之和
	 */
	private int coin(int index, int goal) {
		if (1 == index || 0 == goal) {
			return 1;
		} else {
			final int c = goal / units[index - 1];
			int result = 0;
			for (int i = 0; i <= c; i++) {
				result += coin(index - 1, goal - units[index - 1] * i);
			}
			return result;
		}
	}
}
