package bean17.cha;

import java.math.BigInteger;

public class Problem48 {
    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        new Problem48().testSelfPowers();
    }

    private void testSelfPowers() {
        long start = System.currentTimeMillis();

        BigInteger result = BigInteger.ZERO;
        for (int i = 1; i <= 1000; i++) {
            result = result.add(BigInteger.valueOf(i).pow(i));
        }
        String s = result.toString();
        System.out.println(s.substring(s.length() - 10));

        System.out.println("cost time : "
                + (System.currentTimeMillis() - start) + "ms.");
    }
}
