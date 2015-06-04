package bean17.cha;

public class Problem44 {
    final int N = 1000001;
    long[] pentagonNumbers = new long[N];

    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        new Problem44().testPentagonNumbers();
    }

    private void testPentagonNumbers() {
        long start = System.currentTimeMillis();

        long min = 0;
        for (int i = 1; i < N && 0 == min; i++) {
            if (0 == pentagonNumbers[i]) {
                pentagonNumbers[i] = computePentagonNumber(i);
            }


            for (int j = 1; j < i; j++) {
                long n1 = pentagonNumbers[j] + pentagonNumbers[i];
                if (0 == n1 % 2) {
                    n1 /= 2;
                    if (isPentagonNumber(n1)) {
                        long n2 = (pentagonNumbers[i] - pentagonNumbers[j]) >> 1;
                        if (isPentagonNumber(n2)) {
                            min = pentagonNumbers[j];
                            System.out.println("n1-2 = " + pentagonNumbers[j]
                                    + " ,n2 = " + n2 + " ,n1 = " + n1
                                    + " , n1+2 = " + pentagonNumbers[i]);
                            System.out.println("i = " + i + " , j = " + j);
                            break;
                        }
                    }
                }
            }
        }

        System.out.println("min = " + min);
        System.out.println("cost time : "
                + (System.currentTimeMillis() - start) + "ms.");
    }

    long computePentagonNumber(long i) {
        if (0 < i) {
            return i * (i * 3 - 1) / 2;
        }
        return 0;
    }

    boolean isPentagonNumber(long n) {
        long n2 = n * 24 + 1;
        long sqrt = (long) Math.sqrt(n2 + 0.1);
        if (sqrt * sqrt != n2) {
            return false;
        }
        return 0 == (sqrt + 1) % 6;
    }
}
