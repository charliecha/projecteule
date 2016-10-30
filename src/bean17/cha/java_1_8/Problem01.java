package bean17.cha.java_1_8;

import java.util.stream.IntStream;
/**
 * Multiples of 3 and 5
 * Problem 1
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * <p>
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * <p>
 * What is the largest prime factor of the number 600851475143 ?
 *
 * @author bean17.cha@gmail.com
 */
public class Problem01 {
    public static void main(String[] args) {
        FUtils.printLog(Problem01::multiplesOf3And5);
    }

    private static long multiplesOf3And5() {
        return FUtils.sum(IntStream.range(1, 1000), Problem01::isMultiplesOf3Or5);
    }

    private static boolean isMultiplesOf3Or5(int i) {
        return 0 == i % 3 || 0 == i % 5;
    }
}
