package bean17.cha;

import java.util.Arrays;

public class Problem34 {
    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        new Problem34().digitFactorials();
    }

    private void digitFactorials() {
        long start = System.currentTimeMillis();

        int max = factorials(9) * 9;
        System.out.println("max = " + max);
        int[] factorials = new int[10];
        for (int i = 0; i < factorials.length; i++){
            factorials[i] =factorials(i);
        }
        System.out.println(Arrays.toString(factorials));

        int c = 0;
        for (int i = 10; i <= max; i++){
            int result = 0;

            int remaining = i % 10;
            int tens = i / 10;

            while (tens != 0){
                result += factorials[remaining];

                remaining = tens % 10;
                tens = tens / 10;
            }
            result += factorials[remaining];

            if (result == i ){
//                System.out.println(i + " -- > " + result );
                c += i;
            }
        }

        System.out.println("total = " + c);
        System.out.println("cost time : "
                + (System.currentTimeMillis() - start) + "ms.");
    }

    private int factorials(final int value) {
        if (value > 0) {
            int result = 1;
            for (int i = value; i > 0; i--) {
                result *= i;
            }

            return result;
        }
        return 1;
    }
}
