package bean17.cha;

/**
 Largest palindrome product
 Problem 4
 A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

 Find the largest palindrome made from the product of two 3-digit numbers.
 * @author  bean17.cha@gmail.com
 */
public class Problem04 {
    final long N = 600851475143L;

    public static void main(String[] args) {
        new Problem04().largestPalindromeProduct();
    }

    protected void largestPalindromeProduct() {
        long start = System.currentTimeMillis();

        int max = 0;
        int product;

        for (int i = 100; i <= 999 ; i++) {
            for (int j = 100; j <= 999 ; j++) {
                product = i * j;
                char[] cs = String.valueOf(product).toCharArray();
                if (Utils.isPalindrome(cs) && product > max){
                    max = product;
                }
            }
        }

        System.out.println("max = " + max);
        System.out.println("cost time : " + (System.currentTimeMillis() - start) + "ms.");
    }
}
