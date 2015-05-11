package bean17.cha;

public class Problem39 {
    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        new Problem39().testIntegerRightTriangles();
    }

    private void testIntegerRightTriangles() {
        long start = System.currentTimeMillis();
        final int max = 1000;
        int[] data = new int[max + 1];

        for (int i = 2; i < max / 3; i++) {
            for (int j = i + 1; j < max / 2; j++) {
                int rightTriangle = rightTriangle(i, j);
                if (-1 != rightTriangle) {
                    int p2 = rightTriangle + i + j;
                    if (p2 <= max) {
                        data[p2] = data[p2] + 1;
                    } else {
                        break;
                    }
                }
            }
        }

        int p = 0;
        int index = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > p) {
                p = data[i];
                index = i;
            }
        }

        System.out.println("p = " + index);
        System.out.println("cost time : "
                + (System.currentTimeMillis() - start) + "ms.");
    }

    private int rightTriangle(final int v1, final int v2) {
        final int x2 = v1 * v1 + v2 * v2;
        int i = Math.max(v1, v2) + 1;
        int i2;
        while ((i2 = i * i) <= x2) {
            if (i2 == x2) {
                return i;
            }
            i++;
        }
        return -1;
    }

}
