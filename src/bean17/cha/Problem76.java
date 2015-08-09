package bean17.cha;

import java.util.Arrays;

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
 *
 * @author bean17.cha@gmail.com
 */
public class Problem76 {
    final int N = 3;
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
            for (int j = 1; j <= i ; j++) {
                if (1 == j){
                    summations[i][j] = 1;
                }
//                else {
//                    a[i][j] = a[][];
//                }
            }
        }

        for (int[] summation : summations) {
            System.out.println(Arrays.toString(summation));
        }

        System.out.println("cost time : "
                + (System.currentTimeMillis() - start) + "ms.");
    }

}
