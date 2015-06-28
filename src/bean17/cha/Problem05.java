package bean17.cha;

import java.util.HashMap;
import java.util.Map;

/**
 *Smallest multiple
 Problem 5
 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

 What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * @author  bean17.cha@gmail.com
 */
public class Problem05 {

    public static void main(String[] args) {
        new Problem05().smallestMultiple();
    }

    /**
     * Problem 5
     * compute smallest multiple in [1, 20]
     */
    protected void smallestMultiple() {
        long start = System.currentTimeMillis();

        Map<Long, Integer> map = new HashMap<Long, Integer>();
        for (int i = 20; i > 0; i--) {
            Map<Long, Integer> map2 = Utils.primeFactor(i);
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
}
