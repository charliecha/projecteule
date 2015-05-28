package bean17.cha;

import java.io.File;
import java.util.Arrays;

public class Problem42 {
    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        new Problem42().testCodedTriangleNumbers();
    }

    private void testCodedTriangleNumbers() {
        long start = System.currentTimeMillis();
        int count = 0;

        String name = "/Users/chinda/StudioProjects/projecteule/files/Problem42.txt";
        File file = new File(name);
        String str = Utils.readString(file);


        String[] array = str.split(",");
        for (int i = 0; i < array.length; i++) {
            String s = array[i];
            char[] cs = s.toCharArray();
            int c = 0;
            for (int j = 0; j < cs.length; j++) {
                c += getAlphabeticalPosition(cs[j]);
            }
            if (isTriangle(c)) {
                count++;
//                System.out.println(s + " " + c);
            }
        }

        System.out.println(array.length);

        System.out.println("count = " + count);
        System.out.println("cost time : "
                + (System.currentTimeMillis() - start) + "ms.");
    }

    int getAlphabeticalPosition(char c) {
        char upper = Character.toUpperCase(c);
        if (upper < 'A' || upper > 'Z') {
            return 0;
        }
        return upper - 'A' + 1;
    }

    boolean isTriangle(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Argument Error");
        }

        int sqrt = (int) Math.sqrt(2 * n + 0.1);
        return sqrt * (sqrt + 1) == n * 2;
    }
}
