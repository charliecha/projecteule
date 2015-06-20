package bean17.cha;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bean17.cha.problem54.Card;
import bean17.cha.problem54.HandCard;


/**
 * Lychrel numbers
 * Problem 55
 * If we take 47, reverse and add, 47 + 74 = 121, which is palindromic.
 * <p/>
 * Not all numbers produce palindromes so quickly. For example,
 * <p/>
 * 349 + 943 = 1292,
 * 1292 + 2921 = 4213
 * 4213 + 3124 = 7337
 * <p/>
 * That is, 349 took three iterations to arrive at a palindrome.
 * <p/>
 * Although no one has proved it yet, it is thought that some numbers, like 196, never produce a palindrome. A number that never forms a palindrome through the reverse and add process is called a Lychrel number. Due to the theoretical nature of these numbers, and for the purpose of this problem, we shall assume that a number is Lychrel until proven otherwise. In addition you are given that for every number below ten-thousand, it will either (i) become a palindrome in less than fifty iterations, or, (ii) no one, with all the computing power that exists, has managed so far to map it to a palindrome. In fact, 10677 is the first number to be shown to require over fifty iterations before producing a palindrome: 4668731596684224866951378664 (53 iterations, 28-digits).
 * <p/>
 * Surprisingly, there are palindromic numbers that are themselves Lychrel numbers; the first example is 4994.
 * <p/>
 * How many Lychrel numbers are there below ten-thousand?
 * <p/>
 * NOTE: Wording was modified slightly on 24 April 2007 to emphasise the theoretical nature of Lychrel numbers.
 *
 * @author bean17.cha
 */
public class Problem55 {
    final int N = 10000;
    final int LYCHREL = 1;
    final int NON_LYCHREL = 2;
    final int[] lychrels = new int[N];
    final BigInteger TARGET = java.math.BigInteger.valueOf(10000);

    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        new Problem55().testLychrelNumbers();
    }

    private void testLychrelNumbers() {
        long start = System.currentTimeMillis();

        Arrays.fill(lychrels, 0);

        int c = 0;
        for (int i = 1; i < N; i++) {
            if (isLychrelBelow10000(i)) {
                c++;
            }
        }

        System.out.println("lychrel count is " + c);
        System.out.println("cost time : "
                + (System.currentTimeMillis() - start) + "ms.");
    }

    boolean isLychrelBelow10000(int n) {
        if (N <= n) {
            return false;
        }

        if (0 != lychrels[n]) {
            return LYCHREL == lychrels[n];
        }

        final int c = 50;
        BigInteger sum = BigInteger.valueOf(n);
        List<BigInteger> intermediates = new ArrayList<BigInteger>();

        boolean isPlindrome = false;
        int i = 0;
        for (; i < c; i++) {
            sum = sum.add(reverse(sum));
            if (ispPlindrome(sum)) {
                isPlindrome = true;
                break;
            }
        }

        lychrels[n] = (!isPlindrome) ? LYCHREL : NON_LYCHREL;
        return !isPlindrome;
    }

    BigInteger reverse(BigInteger n) {
        char[] cs = n.toString().toCharArray();
        final int len = cs.length;
        StringBuilder builder = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            builder.append(cs[i]);
        }
        return new BigInteger(builder.toString());
    }

    boolean ispPlindrome(BigInteger n) {
        char[] cs = n.toString().toCharArray();
        final int len = cs.length;
        for (int i = 0; i < len / 2; i++) {
            if (cs[i] != cs[len - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}




