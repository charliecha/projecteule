package bean17.cha;

import java.math.BigInteger;

/**
 * Convergents of e
 * Problem 65
 * The square root of 2 can be written as an infinite continued fraction.
 * <p/>
 * √2 = 1 +
 * 1
 * 2 +
 * 1
 * 2 +
 * 1
 * 2 +
 * 1
 * 2 + ...
 * The infinite continued fraction can be written, √2 = [1;(2)], (2) indicates that 2 repeats ad infinitum. In a similar way, √23 = [4;(1,3,1,8)].
 * <p/>
 * It turns out that the sequence of partial values of continued fractions for square roots provide the best rational approximations. Let us consider the convergents for √2.
 * <p/>
 * 1 +
 * 1
 * = 3/2
 * <p/>
 * 2
 * <p/>
 * 1 +
 * 1
 * = 7/5
 * 2 +
 * 1
 * <p/>
 * 2
 * <p/>
 * 1 +
 * 1
 * = 17/12
 * 2 +
 * 1
 * <p/>
 * 2 +
 * 1
 * <p/>
 * <p/>
 * 2
 * <p/>
 * 1 +
 * 1
 * = 41/29
 * 2 +
 * 1
 * 2 +
 * 1
 * <p/>
 * 2 +
 * 1
 * <p/>
 * <p/>
 * 2
 * <p/>
 * Hence the sequence of the first ten convergents for √2 are:
 * <p/>
 * 1, 3/2, 7/5, 17/12, 41/29, 99/70, 239/169, 577/408, 1393/985, 3363/2378, ...
 * What is most surprising is that the important mathematical constant,
 * e = [2; 1,2,1, 1,4,1, 1,6,1 , ... , 1,2k,1, ...].
 * <p/>
 * The first ten terms in the sequence of convergents for e are:
 * <p/>
 * 2, 3, 8/3, 11/4, 19/7, 87/32, 106/39, 193/71, 1264/465, 1457/536, ...
 * The sum of digits in the numerator of the 10th convergent is 1+4+5+7=17.
 * <p/>
 * Find the sum of digits in the numerator of the 100th convergent of the continued fraction for e.
 * /**
 *
 * @author bean17.cha
 */
public class Problem65 {
    final int N = 99;

    final int[] sequences = new int[(N + 2) / 3 * 3 + 1];

    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        new Problem65().testConvergentsOfE();
    }

    private void testConvergentsOfE() {
        long start = System.currentTimeMillis();

        sequences[0] = 2;
        int index = 1;
        for (int i = 1; i < sequences.length; i++) {
            int mod = i % 3;
            if (0 == mod || 1 == mod) {
                sequences[i] = 1;
            } else {
                sequences[i] = index << 1;
                index++;
            }
        }

        Fraction fraction = new Fraction(BigInteger.valueOf(sequences[N]), BigInteger.ONE);
        for (int i = N; i >= 1; i--) {
            fraction = fraction.reverse().add(sequences[i - 1]);
        }
//        System.out.println(fraction);

        int c = 0;
        char[] cs = fraction.numerator.toString().toCharArray();
        for (char ch : cs) {
            c += ch - '0';
        }

        System.out.println("c = " + c);
        System.out.println("cost time : "
                + (System.currentTimeMillis() - start) + "ms.");
    }

    class Fraction {
        public Fraction(BigInteger numerator, BigInteger denominator) {
            super();
            this.numerator = numerator;
            this.denominator = denominator;
        }

        BigInteger numerator;
        BigInteger denominator;

        Fraction add(int n) {
            // numerator += denominator * n;
            numerator = numerator.add(denominator.multiply(BigInteger
                    .valueOf(n)));
            return this;
        }

        Fraction mutiply(int n) {
            // numerator *= n;
            numerator = numerator.multiply(BigInteger.valueOf(n));
            return this;
        }

        Fraction reverse() {
            BigInteger t = numerator;
            numerator = denominator;
            denominator = t;
            return this;
        }

        @Override
        public String toString() {
            return "Fraction [numerator=" + numerator + ", denominator="
                    + denominator + "]";
        }

    }
}