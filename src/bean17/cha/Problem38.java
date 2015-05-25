package bean17.cha;

import java.util.Arrays;

public class Problem38 {
    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        new Problem38().testPandigitalMultiples();
    }

    private void testPandigitalMultiples() {
        long start = System.currentTimeMillis();
        int max = 0;
        for (int i = 1; i < 100000; i++) {
            StringBuilder build = new StringBuilder();

            int index = 1;
            int current;
            while (build.toString().toCharArray().length < 9) {
                current = i * index;
                index++;
                build.append(current);
            }

            if (isPandigitalMultiples(build.toString().toCharArray())) {
                int temp = Integer.parseInt(build.toString());
                if (temp > max) {
                    max = temp;
                }
            }
        }

        System.out.println("max = " + max);
        System.out.println("cost time : "
                + (System.currentTimeMillis() - start) + "ms.");
    }

    private boolean isPandigitalMultiples(char[] cs) {
        if (null == cs || 9 != cs.length) {
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
