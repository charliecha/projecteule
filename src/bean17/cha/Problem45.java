package bean17.cha;

public class Problem45 {
    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        new Problem45().testTriangleNumbers();
    }

    private void testTriangleNumbers() {
        long start = System.currentTimeMillis();
        long result = 0;

        for (int i = 286; ; i++) {
            long triangle = computeTriangle(i);
            if (isHexagonal(triangle) && isPentagonNumber(triangle)) {
                System.out.println("i = " + i);
                result = triangle;
                break;
            }
        }

        System.out.println("result = " + result);
        System.out.println("cost time : "
                + (System.currentTimeMillis() - start) + "ms.");
    }

    long computeTriangle(long i) {
        if (0 < i) {
            return i * (i + 1) / 2;
        }
        return 0;
    }

    /**
     * Pn=n(3n-1)/2
     *
     * @param n
     * @return
     */
    boolean isPentagonNumber(long n) {
        long n2 = n * 24 + 1;
        long sqrt = (long) Math.sqrt(n2 + 0.1);
        if (sqrt * sqrt != n2) {
            return false;
        }
        return 0 == (sqrt + 1) % 6;
    }

    /**
     * Tn=n(n+1)/2
     *
     * @param n
     * @return
     */
    boolean isTriangle(long n) {
        long n2 = n * 8 + 1;
        long sqrt = (long) Math.sqrt(n2 + 0.1);
        if (sqrt * sqrt != n2) {
            return false;
        }
        return 0 == (sqrt - 1) % 2;
    }

    /**
     * Hn=n(2n-1)
     *
     * @param n
     * @return
     */
    boolean isHexagonal(long n) {
        long n2 = n * 8 + 1;
        long sqrt = (long) Math.sqrt(n2 + 0.1);
        if (sqrt * sqrt != n2) {
            return false;
        }
        return 0 == (sqrt + 1) % 4;
    }
}
