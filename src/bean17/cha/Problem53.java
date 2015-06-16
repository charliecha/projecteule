package bean17.cha;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Combinatoric selections
 * Problem 53
 * There are exactly ten ways of selecting three from five, 12345:
 * <p/>
 * 123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
 * <p/>
 * In combinatorics, we use the notation, 5C3 = 10.
 * <p/>
 * In general,
 * <p/>
 * nCr =
 * n!
 * r!(n−r)!
 * ,where r ≤ n, n! = n×(n−1)×...×3×2×1, and 0! = 1.
 * It is not until n = 23, that a value exceeds one-million: 23C10 = 1144066.
 * <p/>
 * How many, not necessarily distinct, values of  nCr, for 1 ≤ n ≤ 100, are greater than one-million?
 *
 * @author bean17.cha
 */
public class Problem53 {
    final int N = 101;
    final BigInteger[] arrangements = new BigInteger[N];
    final BigInteger TARGET = BigInteger.valueOf(1000000);

    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        new Problem53().testCombinatoricSelections();
    }

    private void testCombinatoricSelections() {
        long start = System.currentTimeMillis();

        int c = 0;
        for (int n = 1; n < N; n++) {
            for (int r = 0; r <= n / 2; r++) {
                if (combinatoric(n, r).compareTo(TARGET) > 0) {
                    if (r * 2 == n) {
                        c++;
                    } else {
                        c += 2;
                    }
                }
            }
        }
        System.out.println("c = " + c);

        System.out.println("cost time : "
                + (System.currentTimeMillis() - start) + "ms.");
    }

    BigInteger combinatoric(int n, int r) {
        BigInteger result = arrangement(n);
        result = result.divide(arrangement(r));
        result = result.divide(arrangement(n - r));
        return result;
    }

    BigInteger arrangement(int n) {
        if (null != arrangements[n]) {
            return arrangements[n];
        }

        BigInteger product = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            product = product.multiply(BigInteger.valueOf(i));
        }
        arrangements[n] = product;
        return product;
    }
}
