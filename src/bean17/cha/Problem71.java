package bean17.cha;

import java.util.List;

/**
 * Ordered fractions Problem 71 Consider the fraction, n/d, where n and d are
 * positive integers. If n<d and HCF(n,d)=1, it is called a reduced proper
 * fraction.
 * <p/>
 * If we list the set of reduced proper fractions for d ≤ 8 in ascending order
 * of size, we get:
 * <p/>
 * 1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3,
 * 5/7, 3/4, 4/5, 5/6, 6/7, 7/8
 * <p/>
 * It can be seen that 2/5 is the fraction immediately to the left of 3/7.
 * <p/>
 * By listing the set of reduced proper fractions for d ≤ 1,000,000 in ascending
 * order of size, find the numerator of the fraction immediately to the left of
 * 3/7.
 * /**
 *
 * @author bean17.cha@gmail.com
 */
public class Problem71 {
    final int N = 1000000;
    final int NUMERATOR = 3;
    final int DENOMINATOR = 7;

    double max = 0D;
    long n;
    long m;

    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        new Problem71().orderedFractions();
    }

    private void orderedFractions() {
        long start = System.currentTimeMillis();

        for (int i = 1; i <= N; i++) {
            long ni = ((long)i) * NUMERATOR / DENOMINATOR;
            if (0 != ni) {
                while (1 != Utils.gcd(i, ni)) {
                    ni--;
                }

                if (NUMERATOR != ni || DENOMINATOR != i) {
                    double f = 1D * ni / i;
                    if (Double.compare(f, max) > 0) {
                        max = f;
                        this.n = ni;
                        this.m = i;

//					System.out.println("n = " + n + " , m = " + m
//							+ ", fraction = " + max);
                    }
                }
            }
        }

        System.out.println("n = " + n + " , m = " + m + ", fraction = " + max);
        System.out.println("cost time : "
                + (System.currentTimeMillis() - start) + "ms.");
    }

}
