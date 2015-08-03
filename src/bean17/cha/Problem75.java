package bean17.cha;

import java.util.List;
import java.util.Set;

/**
 * Singular integer right triangles
 * Problem 75
 * Published on 30 July 2004 at 06:00 pm [Server Time]
 * It turns out that 12 cm is the smallest length of wire that can be bent to form an integer sided right angle triangle in exactly one way, but there are many more examples.
 * <p/>
 * 12 cm: (3,4,5)
 * 24 cm: (6,8,10)
 * 30 cm: (5,12,13)
 * 36 cm: (9,12,15)
 * 40 cm: (8,15,17)
 * 48 cm: (12,16,20)
 * <p/>
 * In contrast, some lengths of wire, like 20 cm, cannot be bent to form an integer sided right angle triangle, and other lengths allow more than one solution to be found; for example, using 120 cm it is possible to form exactly three different integer sided right angle triangles.
 * <p/>
 * 120 cm: (30,40,50), (20,48,52), (24,45,51)
 * <p/>
 * Given that L is the length of the wire, for how many values of L ≤ 1,500,000 can exactly one integer sided right angle triangle be formed?
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
        new Problem75().singularIntegerRightTriangles();
    }

    private void singularIntegerRightTriangles() {
        long start = System.currentTimeMillis();

        List<Long> primeList = Utils.primeFactor(2, Utils.sqrt(N));
        final int half = N / 2;
        long i2;
        for (int i = 3; i < half; i += 2) {
            i2 = ((long) i) * i;
            Set<Long> set0 = Utils.primeFactorSet(i, primeList);
            Set<Long> set = Utils.factors(Utils.primeFactor((long) i * i, primeList));
            for (Long l : set) {
                if (i > l) {
                    long bc = i2 / l;
                    long b = (bc - l) / 2;
                    long c = ((bc + l) / 2);
                    long abc = bc + i;
                    if (abc <= N) {
                        Set<Long> set2 = Utils.primeFactorSet(b, primeList);
                        if (!Utils.intersect(set0, set2)) {
                            int step = (int) ((long) abc);
                            for (int j = step; j <= N; j += step) {
//                                System.out.println(j + " : " + abc + " : " + i + "," + b + "," + c);
                                counts[j] += TARGET;
                            }
                        }
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
