package bean17.cha;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Digit factorial chains
 * Problem 74
 * The number 145 is well known for the property that the sum of the factorial of its digits is equal to 145:
 * <p/>
 * 1! + 4! + 5! = 1 + 24 + 120 = 145
 * <p/>
 * Perhaps less well known is 169, in that it produces the longest chain of numbers that link back to 169; it turns out that there are only three such loops that exist:
 * <p/>
 * 169 → 363601 → 1454 → 169
 * 871 → 45361 → 871
 * 872 → 45362 → 872
 * <p/>
 * It is not difficult to prove that EVERY starting number will eventually get stuck in a loop. For example,
 * <p/>
 * 69 → 363600 → 1454 → 169 → 363601 (→ 1454)
 * 78 → 45360 → 871 → 45361 (→ 871)
 * 540 → 145 (→ 145)
 * <p/>
 * Starting with 69 produces a chain of five non-repeating terms, but the longest non-repeating chain with a starting number below one million is sixty terms.
 * <p/>
 * How many chains, with a starting number below one million, contain exactly sixty non-repeating terms?
 * /**
 *
 * @author bean17.cha@gmail.com
 */
public class Problem74 {
//    final int N = 258280326;
//    final int[] digitFactorialChains = new int[N + 1];
    final int Max = 1000000;
    final int Target = 60;
    final Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        new Problem74().digitFactorialChains();
    }

    private void digitFactorialChains() {
        long start = System.currentTimeMillis();
        int c = 0;

        for (int i = 0; i <= Max ; i++) {
            if (digitFactorialChains(i) >= Target){
                c++;
            }
        }

        System.out.println("c = " + c);
        System.out.println("cost time : "
                + (System.currentTimeMillis() - start) + "ms.");
    }

    int digitFactorialChains(int n){
//        if (0 != digitFactorialChains[n]){
//            return digitFactorialChains[n];
//        }
        if (map.containsKey(n)){
            return map.get(n);
        }

        int c = 0;
        int v = n;
        List<Integer> list = new ArrayList<Integer>();
        while (!list.contains(v)){
            list.add(v);
            c++;

            int temp = v;
            v = 0;
            while (0 != temp / 10){
                v += Utils.factorial(temp % 10);
                temp /= 10;
            }
            v += Utils.factorial(temp);
//            if (0 != digitFactorialChains[v]){
//                c += digitFactorialChains[v];
//                break;
//            }
            if (map.containsKey(v)){
                c += map.get(v);
                break;
            }
        }

//        digitFactorialChains[n] = c;
        map.put(n,c);
        return c;
    }

}
