package bean17.cha;

import java.io.File;

/**
 * Coded triangle numbers
 Problem 42
 The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:

 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

 By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we shall call the word a triangle word.

 Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words, how many are triangle words?
 @author bean17.cha@gmail.com
 */
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

        String name = "files/Problem42.txt";
        File file = new File(name);
        String str = Utils.readString(file);


        String[] array = str.split(",");
        for (String s : array) {
            char[] cs = s.toCharArray();
            int c = 0;
            for (char ch : cs) {
                c += getAlphabeticalPosition(ch);
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
