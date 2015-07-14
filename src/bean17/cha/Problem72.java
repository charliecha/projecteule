package bean17.cha;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Counting fractions
 * Problem 72
 * Consider the fraction, n/d, where n and d are positive integers. If n<d and HCF(n,d)=1, it is called a reduced proper fraction.
 * <p/>
 * If we list the set of reduced proper fractions for d ≤ 8 in ascending order of size, we get:
 * <p/>
 * 1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8
 * <p/>
 * It can be seen that there are 21 elements in this set.
 * <p/>
 * How many elements would be contained in the set of reduced proper fractions for d ≤ 1,000,000?
 * /**
 *
 * @author bean17.cha@gmail.com
 */
public class Problem72 {
    final int N = 1000000;

    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        new Problem72().countingFractions();
    }

    private void countingFractions() {
        long start = System.currentTimeMillis();

        final long sqrt = Utils.sqrt(N);
        List<Long> lessThanSqrt = Utils.primeFactor(2, sqrt);

        long count = 0;

        for (int i = 2; i <= N; i++) {
            Set<Long> set = Utils.primeFactorSet(i, lessThanSqrt);
//            System.out.println("i = " + i + " " + Utils.toString(set));

            long primes = relativelyPrime(set, i);
            count += primes;

        }

        System.out.println("count = " + count);
        System.out.println("cost time : " + (System.currentTimeMillis() - start) + "ms.");
    }

    long relativelyPrime(Collection<Long> list, int n) {
        long f = n;
        for (Long l : list) {
            f = f * (l - 1) / l;
        }
        return f;
    }
}
