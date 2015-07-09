package bean17.cha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Totient maximum Problem 69 Euler's Totient function, φ(n) [sometimes called the phi function], is used to determine
 * the number of numbers less than n which are relatively prime to n. For example, as 1, 2, 4, 5, 7, and 8, are all less
 * than nine and relatively prime to nine, φ(9)=6.
 * 
 * n Relatively Prime φ(n) n/φ(n) 2 1 1 2 3 1,2 2 1.5 4 1,3 2 2 5 1,2,3,4 4 1.25 6 1,5 2 3 7 1,2,3,4,5,6 6 1.1666... 8
 * 1,3,5,7 4 2 9 1,2,4,5,7,8 6 1.5 10 1,3,7,9 4 2.5 It can be seen that n=6 produces a maximum n/φ(n) for n ≤ 10.
 * 
 * Find the value of n ≤ 1,000,000 for which n/φ(n) is a maximum. 
 * /**
 * @author bean17.cha@gmail.com
 */
public class Problem69 {
    final int N = 1000000;
    final int[] relativelyPrimes = new int[N + 1];

    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        new Problem69().totientMaximum();
    }

    private void totientMaximum() {
        long start = System.currentTimeMillis();

        final long sqrt = Utils.sqrt(N);
        List<Long> lessThanSqrt = Utils.primeFactor(2, sqrt);

        float max = 0F;
        int n = 0;
        float f;

        for (int i = 2; i <= N; i++) {
            Set<Long> setI = Utils.primeFactorSet(i, lessThanSqrt);
//            System.out.println("i = " + i + " " + Utils.toString(setI));

            List<Long> list = new ArrayList<Long>(setI);
            Collections.sort(list);

            int primes = relativelyPrime(list, i);

            f = 1F * i / primes;
            if (Float.compare(f, max) > 0) {
                max = f;
                n = i;
            }
        }

        System.out.println("n = " + n + " , max = " + max);
        System.out.println("cost time : " + (System.currentTimeMillis() - start) + "ms.");
    }

    int relativelyPrime(List<Long> list, int n1) {
        if (1 == list.size()) {
            long prime = list.get(0);
            long e = (n1 - 1) / prime * prime;

            int composite = (int) (e / prime);
            relativelyPrimes[n1] = n1 - 1 - composite;
        } else {
            List<Long> copied = new ArrayList<Long>(list);
            copied.remove(copied.size() - 1);

            int composite = n1 - 1 - relativelyPrime(copied, n1);
            int step = 1;
            for (Long l : copied) {
                step *= l;
            }

            long prime = list.get(list.size() - 1);
            long product = prime * step;
            long e = (n1 - 1) / product * product;
            composite += e / product * relativelyPrimes[step];

            for (long j = e + prime; j < n1; j += prime) {
                boolean isTotient = true;
                for (int k = 0; k < copied.size(); k++) {
                    if (0 == j % copied.get(k)) {
                        isTotient = false;
                        break;
                    }
                }
                if (isTotient) {
                    composite++;
                }
            }
            relativelyPrimes[n1] = n1 - 1 - composite;
        }
        return relativelyPrimes[n1];
    }
}
