package bean17.cha;

import java.util.ArrayList;
import java.util.List;

/**
 * 10001st prime
 Problem 7
 By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

 What is the 10 001st prime number?
 * @author bean17.cha@gmail.com
 */
public class Problem07 {

    public static void main(String[] args) {
        new Problem07().primeFactor10001st();
    }

    /**
     * Problem 7
     * compute 10001st prime factor
     */
    protected void primeFactor10001st() {
        long start = System.currentTimeMillis();

        long result = 0;
        List<Long> primeFactorList = new ArrayList<Long>();
        for (long i = 2; i < Long.MAX_VALUE; i++) {
            boolean prime = true;
            for (int j = 0; j < primeFactorList.size(); j++) {
                long value = primeFactorList.get(j);
                long sqrt = (long) Math.sqrt(i) + 1;
                if (0 == i % value) {
                    prime = false;
                    break;
                } else if (value > sqrt) {
                    break;
                }
            }

            if (prime) {
                primeFactorList.add(i);
                if (10001 <= primeFactorList.size()) {
                    result = i;
                    break;
                }
            }

            if (0 != i % 2) {
                i++;
            }
        }

        System.out.println("cost time : " + (System.currentTimeMillis() - start) + "ms.");
        System.out.println("result = " + result);
    }
}
