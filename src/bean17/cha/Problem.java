package bean17.cha;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem {

    public static void main(String[] args) {
        p7PrimeFactor10001st();
    }

    /**
     * Problem 7
     * compute 10001st prime factor
     */
    protected static void p7PrimeFactor10001st() {
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

    /**
     * Problem 6
     * the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
     */
    protected static void p6SumSquareDifference() {
        long start = System.currentTimeMillis();
        long result = 0;
        for (int i = 1; i < 100; i++) {
            for (int j = i + 1; j < 101; j++) {
                result += i * j * 2;
            }
        }
        System.out.println("cost time : " + (System.currentTimeMillis() - start) + "ms.");
        System.out.println("result = " + result);
    }

    /**
     * Problem 5
     * compute smallest multiple in [1, 20]
     */
    protected static void p5SmallestMultiple() {
        long start = System.currentTimeMillis();

        Map<Long, Integer> map = new HashMap<Long, Integer>();
        for (int i = 20; i > 0; i--) {
            Map<Long, Integer> map2 = primeFactor(i);
            for (Long long1 : map2.keySet()) {
                if (!map.containsKey(long1) || map2.get(long1) > map.get(long1)) {
                    map.put(long1, map2.get(long1));
                }
            }
        }

        long result = 1;
        for (Long long1 : map.keySet()) {
            for (int i = 0; i < map.get(long1); i++) {
                result *= long1;
            }
        }

        System.out.println("cost time : " + (System.currentTimeMillis() - start) + "ms.");
        System.out.println("result = " + result);
    }

    /**
     * compute [prime factor, time] set of value
     * 
     * @param value
     * @return
     */
    private static Map<Long, Integer> primeFactor(long value) {
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        List<Long> set = primeFactor(2, value + 1);
        long v = value;
        while (1 != v) {
            for (Long long1 : set) {
                if (0 == v % long1) {
                    v = v / long1;
                    if (map.containsKey(long1)) {
                        map.put(long1, map.get(long1) + 1);
                    } else {
                        map.put(long1, 1);
                    }
                    break;
                }
            }
        }
        return map;
    }

    /**
     * compute prime factor in [start, end)
     * 
     * @param start
     * @param end
     * @return
     */
    private static List<Long> primeFactor(long start, long end) {
        List<Long> primeFactorList = new ArrayList<Long>();
        for (long i = 2; i < end; i++) {
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
            }

            if (0 != i % 2) {
                i++;
            }
        }

        if (start > 2) {
            for (int i = primeFactorList.size() - 1; i >= 0; i--) {
                primeFactorList.remove(i);
            }
        }
        return primeFactorList;
    }
}
