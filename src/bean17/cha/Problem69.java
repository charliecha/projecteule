package bean17.cha;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Totient maximum Problem 69 Euler's Totient function, φ(n) [sometimes called the phi function], is used to determine
 * the number of numbers less than n which are relatively prime to n. For example, as 1, 2, 4, 5, 7, and 8, are all less
 * than nine and relatively prime to nine, φ(9)=6.
 * <p/>
 * n Relatively Prime φ(n) n/φ(n) 2 1 1 2 3 1,2 2 1.5 4 1,3 2 2 5 1,2,3,4 4 1.25 6 1,5 2 3 7 1,2,3,4,5,6 6 1.1666... 8
 * 1,3,5,7 4 2 9 1,2,4,5,7,8 6 1.5 10 1,3,7,9 4 2.5 It can be seen that n=6 produces a maximum n/φ(n) for n ≤ 10.
 * <p/>
 * Find the value of n ≤ 1,000,000 for which n/φ(n) is a maximum.
 * /**
 *
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

    /**
     * http://mathworld.wolfram.com/TotientFunction.html
     * http://www.kylen314.com/archives/4943
     */
    private void totientMaximum() {
        long start = System.currentTimeMillis();

        final long sqrt = Utils.sqrt(N);
        List<Long> lessThanSqrt = Utils.primeFactor(2, sqrt);

        float max = 0F;
        int n = 0;
        float f;

        for (int i = 2; i <= N; i++) {
            Set<Long> set = Utils.primeFactorSet(i, lessThanSqrt);
//            System.out.println("i = " + i + " " + Utils.toString(set));

            List<Long> list = new ArrayList<Long>(set);
            Collections.sort(list);
            int primes = relativelyPrime(list, i);
            f = 1F * i / primes;

//            f = nDivideRelativelyPrime(set);

            if (Float.compare(f, max) > 0) {
                max = f;
                n = i;
//                System.out.println("primes = " + Utils.toString(set));
            }
        }

        System.out.println("n = " + n + " , max = " + max);
        System.out.println("cost time : " + (System.currentTimeMillis() - start) + "ms.");
    }

    //formula
    float nDivideRelativelyPrime(Collection<Long> list) {
        float f = 1F;
        for (Long l : list) {
            f *= (1F * l / (l - 1));
        }
        return f;
    }

    // recursive computation
    int relativelyPrime(List<Long> list, int n1) {
        if (1 == list.size()) {
            long prime = list.get(0);
            int composite = (int) (n1 / prime);
            relativelyPrimes[n1] = n1 - composite;
        } else {
            List<Long> copied = new ArrayList<Long>(list);
            copied.remove(copied.size() - 1);
            
            int composite = n1 - relativelyPrime(copied, n1);
            
            int step = 1;
            for (Long l : copied) {
                step *= l;
            }
            
            long prime = list.get(list.size() - 1);
            long product = prime * step;
            composite += n1 / product * relativelyPrimes[step];
            relativelyPrimes[n1] = n1 - composite;
        }
        return relativelyPrimes[n1];
    }
}
