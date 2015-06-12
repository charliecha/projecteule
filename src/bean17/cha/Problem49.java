package bean17.cha;

import java.util.Arrays;

public class Problem49 {
    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        new Problem49().testPrimePermutations();
    }

    final int N = 10000;

    final int[] primes = new int[N];

    private void testPrimePermutations() {
        long start = System.currentTimeMillis();
        int index = 0;
        for (int i = 1000; i < N; i++) {
            if (isPrime(i)) {
                primes[index++] = i;
            }
        }
        final int length = index;
        System.out.println("length = " + length);
        for (int i = 0; i < length; i++) {
            if (1487 != primes[i]) {
                for (int j = i + 1; j < length; j++) {
                    int another = primes[j] * 2 - primes[i];
                    if (N > another && isPrime(another)) {
                        if (hasSameDigits(primes[i], primes[j])
                                && hasSameDigits(primes[i], another)) {
                            System.out.println(primes[i] + "" + primes[j] + "" + another);
                        }
                    }
                }
            }
        }

        System.out.println("cost time : "
                + (System.currentTimeMillis() - start) + "ms.");
    }


    boolean isPrime(int n) {
        if (1 > n) {
            return false;
        }
        boolean isPrime = true;
        for (int i = 2; i * i <= n; i++) {
            if (0 == n % i) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    boolean hasSameDigits(int i1, int i2) {
        char[] cs1 = String.valueOf(i1).toCharArray();
        char[] cs2 = String.valueOf(i2).toCharArray();
        if (cs1.length != cs2.length) {
            return false;
        }
        Arrays.sort(cs1);
        Arrays.sort(cs2);
        boolean isSame = true;
        for (int i = 0; i < cs1.length; i++) {
            if (cs1[i] != cs2[i]) {
                isSame = false;
                break;
            }
        }
        return isSame;
    }
}
