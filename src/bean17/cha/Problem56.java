package bean17.cha;

import java.math.BigInteger;


/**
 * Powerful digit sum
 * Problem 56
 * A googol (10100) is a massive number: one followed by one-hundred zeros; 100100 is almost unimaginably large: one followed by two-hundred zeros. Despite their size, the sum of the digits in each number is only 1.
 * <p/>
 * Considering natural numbers of the form, ab, where a, b < 100, what is the maximum digital sum?
 *
 * @author bean17.cha
 */
public class Problem56 {
    final int N = 100;

    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        new Problem56().testLychrelNumbers();
    }

    private void testLychrelNumbers() {
        long start = System.currentTimeMillis();

        int max = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                BigInteger pow = BigInteger.valueOf(i).pow(j);
                char[] cs = pow.toString().toCharArray();
                int c = 0;
                for (int k = 0; k < cs.length; k++) {
                    c += cs[k] - '0';
                }
                if (c > max) {
                    max = c;
                }
            }
        }

        System.out.println("max = " + max);

        System.out.println("cost time : "
                + (System.currentTimeMillis() - start) + "ms.");
    }

}




