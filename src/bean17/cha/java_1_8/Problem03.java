package bean17.cha.java_1_8;

import java.util.stream.LongStream;

/**
 * Largest prime factor
 * Problem 3
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * <p>
 * What is the largest prime factor of the number 600851475143 ?
 *
 * @author bean17.cha@gmail.com
 */
public class Problem03 {
    static final long N = 600851475143L;

    public static void main(String[] args) {
        FUtils.printLog(Problem03::maxPrime);
    }

    private static long maxPrime() {
        int sqrt = (int) Math.sqrt(N + 1);
        return LongStream.range(2, sqrt).filter(i -> isDivisible(N, i)).peek(
                System.out::println).filter(Problem03::isPrime).max().orElse(N);
    }

    private static boolean isDivisible(long dividend, long divisor) {
        return 0 == dividend % divisor;
    }

    private static boolean isPrime(long v) {
        if (2 > v) {
            return false;
        }

        if (2 == v) {
            return true;
        }

        if (isDivisible(v, 2)) {
            return false;
        }

        boolean isPrime = true;
        int sqrt = (int) Math.sqrt(v + 1);
        for (int i = 3; i <= sqrt; i += 2) {
            if (isDivisible(v, i)) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
