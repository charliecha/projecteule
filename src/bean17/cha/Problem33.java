package bean17.cha;


public class Problem33 {
	/**
	 * @param args arguments
	 */
	public static void main(String[] args) {
		new Problem33().digitCancellingFractions();
	}

	private void digitCancellingFractions() {
		long start = System.currentTimeMillis();

		for (int i = 10; i < 100; i++){
			for (int j = 10; j < 100; j++){
				boolean flag = isCancellingFractions(i,j);
				if (flag){
					System.out.println(i + " - " + j);
				}
			}
		}

		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
	}

	private boolean isCancellingFractions(int v1, int v2) {
		String s1 = String.valueOf(v1);
		String s2 = String.valueOf(v2);
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		if (c1.length == c2.length && 2 == c1.length && c1[0] != c1[1]){
//			if (c1[0] == c2[1]){
//				return v1*(c2[0]-'0') == v2*(c1[1]-'0');
//			}
			if (c1[1] == c2[0]){
				return v1*(c2[1]-'0') == v2*(c1[0]-'0');
			}
		}
		return false;
	}
}
