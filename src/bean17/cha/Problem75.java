package bean17.cha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Digit factorial chains
 * Problem 74
 * The number 145 is well known for the property that the sum of the factorial of its digits is equal to 145:
 * <p/>
 * 1! + 4! + 5! = 1 + 24 + 120 = 145
 * <p/>
 * Perhaps less well known is 169, in that it produces the longest chain of numbers that link back to 169; it turns out that there are only three such loops that exist:
 * <p/>
 * 169 → 363601 → 1454 → 169
 * 871 → 45361 → 871
 * 872 → 45362 → 872
 * <p/>
 * It is not difficult to prove that EVERY starting number will eventually get stuck in a loop. For example,
 * <p/>
 * 69 → 363600 → 1454 → 169 → 363601 (→ 1454)
 * 78 → 45360 → 871 → 45361 (→ 871)
 * 540 → 145 (→ 145)
 * <p/>
 * Starting with 69 produces a chain of five non-repeating terms, but the longest non-repeating chain with a starting number below one million is sixty terms.
 * <p/>
 * How many chains, with a starting number below one million, contain exactly sixty non-repeating terms?
 * /**
 *
 * @author bean17.cha@gmail.com
 */
public class Problem75 {
    final int N = 1500000;
    final int[] counts = new int[N + 1];
    final int TARGET = 1;

    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        new Problem75().digitFactorialChains();
    }

    private void digitFactorialChains() {
        long start = System.currentTimeMillis();

        List<Long> primeList = Utils.primeFactor(2, Utils.sqrt(N));

        final int third = N / 4;
        for (int i = 3; i <= third; i += 2) {
            int max = N / 2;
            int t = (i * i - 1) / 2;
            if (t > 0) {
                if (t < max) {
                    max = t;
                }
            }

//            long i2 = 1L * i * i;
            for (int j = i + 1; j <= max; j += 2) {
                long r2 = (long)i * i + (long)j * j;
                int sqrt = (int) Utils.sqrt(r2);
                if (sqrt + i + j > N) {
                    break;
                } else if ((long)sqrt * sqrt == r2) {
                    Set<Long> set1 = Utils.primeFactorSet(i, primeList);
                    Set<Long> set2 = Utils.primeFactorSet(j, primeList);
                    if (!Utils.intersect(set1, set2)) {
                        int v = i + j + sqrt;
                        for (int k = v; k <= N; k += v) {
                            counts[k] += 1;
                        }
                        System.out.println("i,j,sqrt=" + i + "," + j +"," +sqrt);
                    }
                }
            }
        }

        int c = 0;
        for (int i = 0; i <= N; i++) {
            if (TARGET == counts[i]) {
                c++;
            }
        }
        System.out.println("c = " + c);
//        System.out.println("array = " + Arrays.toString(counts));

        System.out.println("cost time : "
                + (System.currentTimeMillis() - start) + "ms.");
    }

}
