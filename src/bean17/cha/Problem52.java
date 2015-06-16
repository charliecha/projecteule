package bean17.cha;

import java.util.Arrays;

/**
 * Permuted multiples
 * Problem 52
 * It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.
 * <p/>
 * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
 *
 * @author bean17.cha
 */
public class Problem52 {
    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        new Problem52().testConsecutivePrimeSum();
    }

    private void testConsecutivePrimeSum() {
        long start = System.currentTimeMillis();

        for (int i = 1; ; i++) {
            if (isPermutedMultiples(i)) {
                System.out.println("I = " + i);
                break;
            }
        }

        System.out.println("cost time : "
                + (System.currentTimeMillis() - start) + "ms.");
    }

    boolean isPermutedMultiples(int n) {
        char[] cs = Integer.valueOf(n).toString().toCharArray();
        Arrays.sort(cs);
        for (int i = 2; i <= 6; i++) {
            int result = i * n;
            char[] results = Integer.valueOf(result).toString().toCharArray();
            if (results.length != cs.length) {
                return false;
            } else {
                Arrays.sort(results);
                for (int j = 0; j < cs.length; j++) {
                    if (cs[j] != results[j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
