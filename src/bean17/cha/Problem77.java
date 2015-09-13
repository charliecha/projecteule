package bean17.cha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Prime summations
 * Problem 77
 * It is possible to write ten as the sum of primes in exactly five different ways:
 * <p/>
 * 7 + 3
 * 5 + 5
 * 5 + 3 + 2
 * 3 + 3 + 2 + 2
 * 2 + 2 + 2 + 2 + 2
 * <p/>
 * What is the first value which can be written as the sum of primes in over five thousand different ways?
 * /*@author bean17.cha@gmail.com
 */
public class Problem77 {
    final int N = 5000;

    /**
     * @param args args
     */
    public static void main(String[] args) {
        new Problem77().primeSummations();
    }

    /**
     * 计算素数之和
     */
    private void primeSummations() {
        long start = System.currentTimeMillis();

        List<Long> primeList = new ArrayList<Long>();
        primeList.add(2L);

        long lastPrime = primeList.get(primeList.size() - 1);
        boolean sucess = false;
        long index = 0;
        while (!sucess) {
            long nextPrime = Utils.nextPrime(lastPrime);
            for (long i = lastPrime; i < nextPrime; i++) {
                long result = primeSummation(i, primeList.size(), primeList);
                if (result >= N) {
                    sucess = true;
                    index = i;
                    break;
                }
            }

            if (!sucess) {
                primeList.add(nextPrime);
                lastPrime = nextPrime;
            }
        }

        System.out.println("index = " + index);
        System.out.println("primeList = " + Arrays.toString(primeList.toArray()));
        System.out.println("cost time : "
                + (System.currentTimeMillis() - start) + "ms.");
    }

    /**
     * 第几个素数
     *
     * @param index     索引值
     * @param primeList 素数列表
     * @return 素数
     */
    long primeInIndex(int index, List<Long> primeList) {
        return primeList.get(index);
    }

    /**
     * 素数组成目标值的组合数
     *
     * @param goal      目标值
     * @param index     索引值
     * @param primeList 素数列表
     * @return 素数之和
     */
    private long primeSummation(long goal, int index, List<Long> primeList) {
        if (0 == goal) {
            return 1;
        } else if (1 == index) {
            if (0 == goal % primeInIndex(0, primeList)) {
                return 1;
            } else {
                return 0;
            }
        } else {
            final long c = (goal / primeInIndex(index - 1, primeList));
            long result = 0;
            for (long i = 0; i <= c; i++) {
                result += primeSummation(goal - primeInIndex(index - 1, primeList) * i, index - 1, primeList);
            }
            return result;
        }
    }
}
