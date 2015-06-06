package bean17.cha;

public class Problem46 {
    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        new Problem46().testGoldbach();
    }

    private void testGoldbach() {
        long start = System.currentTimeMillis();
        long result = 0;

        for (int i = 9; ; i += 2) {
            if (!isPrime(i) && !isGoldbach(i)) {
                result = i;
                break;
            }
        }

        System.out.println("result = " + result);
        System.out.println("cost time : "
                + (System.currentTimeMillis() - start) + "ms.");
    }

    boolean isGoldbach(int n) {
        if (n < 9 || 0 == n % 2) {
            return false;
        }

        boolean isGoldbach = false;
        for (int i = 1; 2 * i * i < n; i++) {
            int remainings = n - 2 * i * i;
            if (isPrime(remainings)) {
                isGoldbach = true;
                break;
            }
        }
        return isGoldbach;
    }

    boolean isPrime(int n) {
        if (1 > n) {
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
}
