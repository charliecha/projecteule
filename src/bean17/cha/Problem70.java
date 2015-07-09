package bean17.cha;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Totient permutation
 * Problem 70
 * Euler's Totient function, φ(n) [sometimes called the phi function], is used to determine the number of positive numbers less than or equal to n which are relatively prime to n. For example, as 1, 2, 4, 5, 7, and 8, are all less than nine and relatively prime to nine, φ(9)=6.
 * The number 1 is considered to be relatively prime to every positive number, so φ(1)=1.
 * Interestingly, φ(87109)=79180, and it can be seen that 87109 is a permutation of 79180.
 * Find the value of n, 1 < n < 107, for which φ(n) is a permutation of n and the ratio n/φ(n) produces a minimum.
 * /**
 *
 * @author bean17.cha@gmail.com
 */
public class Problem70 {
    final int N = 10000000;
//    final int[] relativelyPrimes = new int[N + 1];

    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        new Problem70().totientMaximum();
    }

    private void totientMaximum() {
        long start = System.currentTimeMillis();

        final long sqrt = Utils.sqrt(N);
        List<Long> lessThanSqrt = Utils.primeFactor(2, sqrt);

        float min = Float.MAX_VALUE;
        int n = 0;
        float f;

        for (int i = 2; i <= N; i++) {
            Set<Long> set = Utils.primeFactorSet(i, lessThanSqrt);
//            System.out.println("i = " + i + " " + Utils.toString(set));

            if (2 == set.size()) {
                long primes = relativelyPrime(set, i);
                if (isPermutation(i, primes)) {
                    f = 1F * i / primes;
                    if (Float.compare(f, min) < 0) {
                        min = f;
                        n = i;
//                        System.out.println("primes = " + Utils.toString(set));
                    }
                }
            }
        }

        System.out.println("n = " + n + " , min = " + min);
        System.out.println("cost time : " + (System.currentTimeMillis() - start) + "ms.");
    }

    long relativelyPrime(Collection<Long> list, int n) {
        long f = n;
        for (Long l : list) {
            f = f * (l - 1) / l;
        }
        return f;
    }

    boolean isPermutation(long n1, long n2) {
        char[] cs1 = Long.valueOf(n1).toString().toCharArray();
        char[] cs2 = Long.valueOf(n2).toString().toCharArray();
        if (cs1.length != cs2.length) {
            return false;
        }

        Arrays.sort(cs1);
        Arrays.sort(cs2);
        for (int i = 0; i < cs2.length; i++) {
            if (cs1[i] != cs2[i]) {
                return false;
            }
        }
        return true;
    }
}
