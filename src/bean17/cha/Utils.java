package bean17.cha;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Utils {
    /**
     * read whole file
     *
     * @param file file
     * @return file content
     */
    public static String readString(File file) {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            while (null != (line = reader.readLine())) {
                builder.append(line.trim());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return builder.toString();
    }

    /**
     * read lines
     *
     * @param file file
     * @return contents
     */
    public static String[] readStringArray(File file) {
        List<String> list = new ArrayList<String>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            while (null != (line = reader.readLine())) {
                list.add(line.trim());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        final int size = list.size();
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    /**
     * is n prime?
     *
     * @param n int value
     * @return is prime?
     */
    public static boolean isPrime(long n) {
        if (2 > n) {
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

    /**
     * next prime after current
     *
     * @param current current value
     * @return next prime
     */
    public static long nextPrime(long current) {
        long next = current + 1;
        while (!Utils.isPrime(next)) {
            next++;
        }
        return next;
    }

    /**
     * compute prime factor in [start, end)
     *
     * @param start start
     * @param end   end
     * @return list of primes
     */
    public static List<Long> primeFactor(long start, long end) {
        List<Long> primeFactorList = new ArrayList<Long>();
        for (long i = 2; i <= end; i++) {
            boolean prime = true;
            for (int j = 0; j < primeFactorList.size(); j++) {
                long value = primeFactorList.get(j);
                long sqrt = sqrt(i);
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

    /**
     * compute [prime factor, time] set of value
     *
     * @param value value
     * @return set of [prime factor, time]
     */
    public static Map<Long, Integer> primeFactor(final long value) {
        final long sqrt = Utils.sqrt(value);
        List<Long> lessThanSqrt = Utils.primeFactor(2, sqrt);

        Map<Long, Integer> map = new HashMap<Long, Integer>();
        long v = value;
        boolean fail = false;
        while (1 != v && !fail) {
            fail = true;
            for (Long prime : lessThanSqrt) {
                while (0 == v % prime) {
                    v = v / prime;
                    if (map.containsKey(prime)) {
                        map.put(prime, map.get(prime) + 1);
                    } else {
                        map.put(prime, 1);
                    }
                    fail = false;
                }
            }
        }
        if (1 != v) {
            map.put(v, 1);
        }
        return map;
    }

    /**
     * compute [prime factor, time] set of value
     *
     * @param value value
     * @return set of [prime factor, time]
     */
    public static Map<Long, Integer> primeFactor(long value, List<Long> primeList) {
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        long v = value;
        boolean fail = false;
        final long sqrt = Utils.sqrt(value);

        while (1 != v && !fail) {
            fail = true;
            for (int i = 0; i < primeList.size(); i++) {
                long prime = primeList.get(i);
                if (prime > sqrt) {
                    break;
                }

                while (0 == v % prime) {
                    v = v / prime;
                    if (map.containsKey(prime)) {
                        map.put(prime, map.get(prime) + 1);
                    } else {
                        map.put(prime, 1);
                    }
                    fail = false;
                }
            }
        }
        if (1 != v) {
            map.put(v, 1);
        }
        return map;
    }

    public static Set<Long> primeFactorSet(long value, List<Long> primeList) {
        Set<Long> set = new HashSet<Long>();
        long v = value;
        boolean fail = false;
        final long sqrt = Utils.sqrt(value);

        while (1 != v && !fail) {
            fail = true;
            for (int i = 0; i < primeList.size(); i++) {
                long prime = primeList.get(i);
                if (prime > sqrt) {
                    break;
                }

                if (0 == v % prime) {
                    set.add(prime);
                    fail = false;

                    while (0 == v % prime) {
                        v = v / prime;
                    }
                }
            }
        }
        if (1 != v) {
            set.add(v);
        }
        return set;
    }

    /**
     * sqrt of i
     *
     * @param i current value
     * @return sqrt of i
     */
    public static long sqrt(long i) {
        return (long) Math.sqrt(i + 0.1);
    }

    /**
     * is i a square?
     *
     * @param i current value
     * @return true: i is a square
     */
    public static boolean isSqrt(long i) {
        long sqrt = sqrt(i);
        return sqrt * sqrt == i;
    }

    /**
     * cs is palindrome?
     *
     * @param cs char array
     * @return true: cs is palindrome
     */
    public static boolean isPalindrome(char[] cs) {
        if (null == cs || 0 == cs.length) {
            return false;
        }

        for (int i = 0; i < cs.length / 2; i++) {
            if (cs[i] != cs[cs.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public static String toString(Collection<?> set) {
        StringBuilder builder = new StringBuilder();
        for (Object key : set) {
            builder.append(" | ").append(key);
        }
        builder.append("\n");
        return builder.toString();
    }

    public static long gcd(long n, long d) {
        long m = d % n;
        if (m == 0) {
            return n;
        }
        if (m == 1) {
            return 1;
        }
        while (m != 0) {
            d = n;
            n = m;
            m = d % n;
        }
        return n;
    }

    /**
     * factorial of 1 * ... * n
     * @param n number
     * @return factorial
     */
    public static long factorial(final int n){
        if (1 > n){
            return 1;
        }
        int f = 1;
        for (int i = 2; i <= n; i++) {
            f *= i;
        }
        return f;
    }

    /**
     * is set1 && set2 intersect ?
     * @param set1 set1
     * @param set2 set2
     * @return intersect
     */
    public static boolean intersect(Set<?> set1, Set<?>set2){
        if (null == set1 || null == set2){
            return false;
        }

        for (Object o : set1){
            if (set2.contains(o)){
                return true;
            }
        }
        return false;
    }

    /**
     * 因数
     * @param map factor map
     * @return 因数
     */
    public static Set<Long> factors(Map<Long, Integer> map){
        Set<Long> set = new HashSet<Long>();
        Set<Long> keys = map.keySet();
        for (Long key : keys){
            int exponent = map.get(key);
            long v = 1;
            Set<Long> set2 = new HashSet<Long>();
            set2.add(v);
            for (int i = 0; i < exponent; i++) {
                v *= key;
                set2.add(v);
            }
            if (set.isEmpty()){
                set.addAll(set2);
            } else {
                Set<Long> set3 = new HashSet<Long>();
                for (Long l : set2){
                    if (1 != l){
                        for (Long s : set){
                            set3.add(s * l);
                        }
                    }
                }
                set.addAll(set3);
            }
        }
        return set;
    }
}
