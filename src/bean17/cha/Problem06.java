package bean17.cha;

/**
 *Sum square difference
 Problem 6
 The sum of the squares of the first ten natural numbers is,

 12 + 22 + ... + 102 = 385
 The square of the sum of the first ten natural numbers is,

 (1 + 2 + ... + 10)2 = 552 = 3025
 Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

 Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 * @author bean17.cha@gmail.com
 */
public class Problem06 {

    public static void main(String[] args) {
        new Problem06().sumSquareDifference();
    }


    /**
     * Problem 6
     * the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
     */
    protected void sumSquareDifference() {
        long start = System.currentTimeMillis();
        long result = 0;
        for (int i = 1; i < 100; i++) {
            for (int j = i + 1; j < 101; j++) {
                result += i * j * 2;
            }
        }
        System.out.println("cost time : " + (System.currentTimeMillis() - start) + "ms.");
        System.out.println("result = " + result);
    }
}
