package bean17.cha;


public class Problem37 {
    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        new Problem37().testTruncatablePrimes();
    }

    private void testTruncatablePrimes() {
        long start = System.currentTimeMillis();
        int count = 0;
        long sum = 0;

        for (int i = 10; count < 11; i++) {
            if (isPrime(i)) {
                char[] cs = Integer.toString(i).toCharArray();
                boolean truncatablePrime = true;
                int value = 0;
                for (int j = 0; j < cs.length - 1; j++) {
                    value = 10 * value + (cs[j] - '0');
                    if (!isPrime(value)) {
                        truncatablePrime = false;
                        break;
                    }
                }
                if (truncatablePrime) {
                    value = 0;
                    for (int j = cs.length - 1; j > 0; j--) {
                        value = value + (cs[j] - '0') * pow(10, cs.length - 1 - j);
                        if (!isPrime(value)) {
                            truncatablePrime = false;
                            break;
                        }
                    }
                }

                if (truncatablePrime) {
                    count++;
                    sum += i;
                }
            }
        }

        System.out.println("sum = " + sum);
        System.out.println("cost time : "
                + (System.currentTimeMillis() - start) + "ms.");
    }

    private boolean isPrime(final int value) {
        if (value < 2) {
            return false;
        }
        boolean prime = true;
        for (int i = 2; i * i <= value; i++) {
            if (0 == value % i) {
                prime = false;
                break;
            }
        }
        return prime;
    }

    private int pow(final int n, final int m) {
        if (0 == m) {
            return 1;
        } else {
            int product = 1;
            for (int i = 0; i < m; i++) {
                product *= n;
            }
            return product;
        }
    }
}
