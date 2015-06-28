package bean17.cha;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 Largest prime factor
 Problem 3
 The prime factors of 13195 are 5, 7, 13 and 29.

 What is the largest prime factor of the number 600851475143 ?
 * @author  bean17.cha@gmail.com
 */
public class Problem3 {
    final long N = 600851475143L;

    public static void main(String[] args) {
        new Problem3().largestPrimeFactor();
    }

    protected void largestPrimeFactor() {
        long start = System.currentTimeMillis();

        long value = N;
        long max = 0;

        List<Long> primeList = new ArrayList<Long>();
        for (long i = 2; i <= value; i++) {
            boolean prime = true;
            for (int j = 0; j < primeList.size(); j++) {
                if (0 == i % primeList.get(j)){
                    prime = false;
                    break;
                }
            }

            if (prime){
                if (0 == value % i){
                    value /= i;
                    if (i > max){
                        max = i;
                    }
                }
            }
        }

        System.out.println("max = " + max);
        System.out.println("cost time : " + (System.currentTimeMillis() - start) + "ms.");
    }
}
