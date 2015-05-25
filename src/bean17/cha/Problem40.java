package bean17.cha;

public class Problem40 {
    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        new Problem40().testChampernowneConstant();
    }

    private void testChampernowneConstant() {
        long start = System.currentTimeMillis();

        int currentIndex = 1;
        int currentLength = 0;
        int product = 1;

        for (int i = 0; i < 7; i++) {
            int n = pow10(i);

            char[] cs;
            while ((cs = String.valueOf(currentIndex++).toCharArray()).length + currentLength < n) {
                currentLength += cs.length;
            }

            int offset = cs.length - n + currentLength;
            product *= cs[offset] - '0';
        }

        System.out.println("product = " + product);
        System.out.println("cost time : "
                + (System.currentTimeMillis() - start) + "ms.");
    }

    int pow10(int n) {
        if (n <= 0) {
            return 1;
        }
        int product = 1;
        for (int i = 0; i < n; i++) {
            product *= 10;
        }
        return product;
    }
}
