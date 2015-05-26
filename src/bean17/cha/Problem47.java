package bean17.cha;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem47 {
    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        new Problem47().testDistinctPrimesFactors();
    }

    private HashMap<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();

    private void testDistinctPrimesFactors() {
        long start = System.currentTimeMillis();

        final int size = 4;
        int count = size;
        int index;
        for (int i = 2; ; i++) {
            Set<Integer> set = distinctPrimesFactors(i);
            if (null != set && size == set.size()) {
                count--;
            } else {
                count = size;
            }

            if (0 == count) {
                index = i - size + 1;
                break;
            }
        }
        System.out.println("start = " + index);
        System.out.println("cost time : "
                + (System.currentTimeMillis() - start) + "ms.");
    }

    Set<Integer> distinctPrimesFactors(final int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        Set<Integer> set = null;
        if (n < 2) {
            set = null;
            map.put(n, set);
            return set;
        }

        for (int i = 2; i * i <= n; i++) {
            if (0 == n % i) {
                if (i * i == n) {
                    set = distinctPrimesFactors(i);
                    map.put(n, set);
                    return set;
                } else {
                    set = contact(distinctPrimesFactors(i), distinctPrimesFactors(n / i));
                    map.put(n, set);
                    return set;
                }
            }
        }

        // prime
        set = new HashSet<Integer>();
        set.add(n);
        map.put(n, set);
        return set;
    }

    private Set<Integer> contact(Set<Integer> set1, Set<Integer> set2) {
        if (null == set1 && null == set2) {
            return null;
        } else if (null == set1) {
            return set2;
        } else if (null == set2) {
            return set1;
        } else {
            Set<Integer> set = new HashSet<Integer>();
            set.addAll(set1);
            set.addAll(set2);
            return set;
        }
    }

}
