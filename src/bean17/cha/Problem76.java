package bean17.cha;

/**
 * Counting summations
 * Problem 76
 * It is possible to write five as a sum in exactly six different ways:
 * <p/>
 * 4 + 1
 * 3 + 2
 * 3 + 1 + 1
 * 2 + 2 + 1
 * 2 + 1 + 1 + 1
 * 1 + 1 + 1 + 1 + 1
 * <p/>
 * How many different ways can one hundred be written as a sum of at least two positive integers?
 * /**
 * 动态规划解题的思想，前面的计算成为后面的线索。
 * @author bean17.cha@gmail.com
 */
public class Problem76 {
    final int N = 100;
    final int[][] summations = new int[N + 1][N + 1];

    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        new Problem76().countingSummations();
    }

    private void countingSummations() {
        long start = System.currentTimeMillis();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                summations(i, j);
            }
        }

//        for (int[] summation : summations) {
//            System.out.println(Arrays.toString(summation));
//        }

        System.out.println("summations of " + N + " is " + (summations(N, N) - 1));

        System.out.println("cost time : "
                + (System.currentTimeMillis() - start) + "ms.");
    }

    int summations(final int n, final int m) {
        if (0 != summations[n][m]) {
            return summations[n][m];
        }

//        int i = n;
        int j = m;
        if (j > n) {
            j = n;
        }

        if (1 == j || 0 == j) {
            summations[n][m] = 1;
        } else {
            summations[n][m] = summations(n, j - 1) + summations(n - j, m);
        }
        return summations[n][m];
    }
}
