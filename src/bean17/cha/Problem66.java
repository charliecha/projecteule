package bean17.cha;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Diophantine equation
 * Problem 66
 * Consider quadratic Diophantine equations of the form:
 * <p/>
 * x2 – Dy2 = 1
 * <p/>
 * For example, when D=13, the minimal solution in x is 6492 – 13×1802 = 1.
 * <p/>
 * It can be assumed that there are no solutions in positive integers when D is square.
 * <p/>
 * By finding minimal solutions in x for D = {2, 3, 5, 6, 7}, we obtain the following:
 * <p/>
 * 32 – 2×22 = 1
 * 22 – 3×12 = 1
 * 92 – 5×42 = 1
 * 52 – 6×22 = 1
 * 82 – 7×32 = 1
 * <p/>
 * Hence, by considering minimal solutions in x for D ≤ 7, the largest x is obtained when D=5.
 * <p/>
 * Find the value of D ≤ 1000 in minimal solutions of x for which the largest value of x is obtained.
 * /**
 *
 * @author bean17.cha@gmail.com
 */
public class Problem66 {
    final int N = 1000;

    final long[][] sequences = new long[N + 1][];

    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        new Problem66().testDiophantineEquation();
    }

    private void testDiophantineEquation() {
        long start = System.currentTimeMillis();

        long m;
        long d;
        long a;
        long a0;
        for (int i = 1; i < sequences.length; i++) {
            if (Utils.isSqrt(i)) {
                continue;
            }

            List<Long> list = new ArrayList<Long>();
            m = 0;
            d = 1;
            a0 = (Utils.sqrt(i) + m) / d;
            a = a0;
            list.add(a);
            while (a != a0 << 1) {
                m = d * a - m;
                d = (i - m * m) / d;
                a = (a0 + m) / d;
                list.add(a);
            }

            sequences[i] = new long[list.size()];
            for (int j = 0; j < sequences[i].length; j++) {
                sequences[i][j] = list.get(j);
            }
        }

//        for (int i = 0; i < sequences.length; i++) {
//            System.out.println(i + " : " + Arrays.toString(sequences[i]));
//        }

        int d2 = 0;
        BigInteger max = BigInteger.ZERO;

        for (int i = 1; i < sequences.length; i++) {
            if (Utils.isSqrt(i)) {
                continue;
            }

            final int circulation = sequences[i].length - 1;

            boolean find = false;
            int offset;
            for (int j = 1; !find; j++) {
                offset = j;
                if (offset > circulation) {
                    offset = (offset - 1) % circulation + 1;
                }

                Fraction fraction = new Fraction(BigInteger.valueOf(sequences[i][offset]), BigInteger.ONE);
                for (int k = j; k >= 1; k--) {
                    offset = k - 1;
                    if (offset > circulation) {
                        offset = (offset - 1) % circulation + 1;
                    }

                    fraction = fraction.reverse().add(sequences[i][offset]);
                }
                BigInteger numerator = fraction.numerator;
                BigInteger denominator = fraction.denominator;
                BigInteger result = numerator.pow(2).subtract(denominator.pow(2).multiply(BigInteger.valueOf(i)));
                if (BigInteger.ONE.compareTo(result) == 0) {
//                    System.out.println("i = " + i  + " ,numerator = " + numerator + " , denominator = " + denominator + " , j = " + j + " , circulation = " + circulation);
                    if (numerator.compareTo(max) > 0) {
                        max = numerator;
                        d2 = i;
                    }
                    find = true;
                }
            }
        }

        System.out.println("max = " + max);
        System.out.println("d = " + d2);

        System.out.println("cost time : "
                + (System.currentTimeMillis() - start) + "ms.");
    }
}