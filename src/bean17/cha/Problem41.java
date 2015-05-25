package bean17.cha;

import java.util.Arrays;

public class Problem41 {
    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        new Problem41().testPandigitalPrime();
    }

    private void testPandigitalPrime() {
        long start = System.currentTimeMillis();
        int max = 0;

        for (int i = 7654321; i >= 12; i--) {
            if (isPrime(i)){
                char[] cs = String.valueOf(i).toCharArray();
                if (isPandigitalMultiples(cs)){
                    if (i > max){
                        max = i;
                    }
                }
            }
        }

        System.out.println("max = " + max);
        System.out.println("cost time : "
                + (System.currentTimeMillis() - start) + "ms.");
    }

    boolean isPrime(int n){
        if (n < 2){
            return false;
        }

        boolean isPrime = true;
        for (int i = 2; i * i <= n; i++) {
            if (0 == n % i){
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    private boolean isPandigitalMultiples(char[] cs) {
        if (null == cs || 9 < cs.length) {
            return false;
        }
        Arrays.sort(cs);
        boolean pandigital = true;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] - '1' != i) {
                pandigital = false;
                break;
            }
        }
        return pandigital;
    }
}
