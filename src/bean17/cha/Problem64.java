package bean17.cha;

/**
 * Odd period square roots
 * Problem 64
 * All square roots are periodic when written as continued fractions and can be written in the form:
 * <p/>
 * √N = a0 +
 * 1
 * a1 +
 * 1
 * a2 +
 * 1
 * a3 + ...
 * For example, let us consider √23:
 * <p/>
 * √23 = 4 + √23 — 4 = 4 +
 * 1
 * = 4 +
 * 1
 * <p/>
 * 1
 * √23—4
 * 1 +
 * √23 – 3
 * 7
 * If we continue we would get the following expansion:
 * <p/>
 * √23 = 4 +
 * 1
 * 1 +
 * 1
 * 3 +
 * 1
 * 1 +
 * 1
 * 8 + ...
 * The process can be summarised as follows:
 * <p/>
 * a0 = 4,
 * 1
 * √23—4
 * =
 * √23+4
 * 7
 * = 1 +
 * √23—3
 * 7
 * a1 = 1,
 * 7
 * √23—3
 * =
 * 7(√23+3)
 * 14
 * = 3 +
 * √23—3
 * 2
 * a2 = 3,
 * 2
 * √23—3
 * =
 * 2(√23+3)
 * 14
 * = 1 +
 * √23—4
 * 7
 * a3 = 1,
 * 7
 * √23—4
 * =
 * 7(√23+4)
 * 7
 * = 8 + 	√23—4
 * a4 = 8,
 * 1
 * √23—4
 * =
 * √23+4
 * 7
 * = 1 +
 * √23—3
 * 7
 * a5 = 1,
 * 7
 * √23—3
 * =
 * 7(√23+3)
 * 14
 * = 3 +
 * √23—3
 * 2
 * a6 = 3,
 * 2
 * √23—3
 * =
 * 2(√23+3)
 * 14
 * = 1 +
 * √23—4
 * 7
 * a7 = 1,
 * 7
 * √23—4
 * =
 * 7(√23+4)
 * 7
 * = 8 + 	√23—4
 * It can be seen that the sequence is repeating. For conciseness, we use the notation √23 = [4;(1,3,1,8)], to indicate that the block (1,3,1,8) repeats indefinitely.
 * <p/>
 * The first ten continued fraction representations of (irrational) square roots are:
 * <p/>
 * √2=[1;(2)], period=1
 * √3=[1;(1,2)], period=2
 * √5=[2;(4)], period=1
 * √6=[2;(2,4)], period=2
 * √7=[2;(1,1,1,4)], period=4
 * √8=[2;(1,4)], period=2
 * √10=[3;(6)], period=1
 * √11=[3;(3,6)], period=2
 * √12= [3;(2,6)], period=2
 * √13=[3;(1,1,1,1,6)], period=5
 * <p/>
 * Exactly four continued fractions, for N ≤ 13, have an odd period.
 * <p/>
 * How many continued fractions for N ≤ 10000 have an odd period?
 /**
 * @author bean17.cha@gmail.com
 */

public class Problem64 {

    final int N = 10;

    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        new Problem64().testOddPeriodSquareRoots();
    }

    /**
     * https://en.wikipedia.org/wiki/Methods_of_computing_square_roots
     * http://www.kylen314.com/archives/4943
     */
    private void testOddPeriodSquareRoots() {
        long start = System.currentTimeMillis();

        int odd = 0;

        long m;
        long d;
        long a;
        long a0;

        for (int i = 1; i <= N; i++) {
            if (isSqrt(i)) {
                continue;
            }

            m = 0;
            d = 1;
            a0 = (sqrt(i) + m) / d;
            a = a0;

            System.out.print(i + " : " + a0 + " " );

            int c = 0;
            while (a != a0 << 1) {
                m = d * a - m;
                d = (i - m * m) / d;
                a = (a0 + m) / d;
                c++;
                System.out.print(a + " ");
            }
            System.out.println();

            if (0 != c % 2) {
                odd++;
            }
        }

        System.out.println("odd = " + odd);
        System.out.println("cost time : "
                + (System.currentTimeMillis() - start) + "ms.");
    }

    long sqrt(long i) {
        return (long) Math.sqrt(i);
    }

    boolean isSqrt(long i) {
        long sqrt = sqrt(i);
        return sqrt * sqrt == i;
    }
}
