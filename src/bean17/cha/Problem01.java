package bean17.cha;

/**
 Multiples of 3 and 5
 Problem 1
 If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

 Find the sum of all the multiples of 3 or 5 below 1000.

 What is the largest prime factor of the number 600851475143 ?
 * @author  bean17.cha@gmail.com
 */
public class Problem01 {

    public static void main(String[] args) {
        new Problem01().multiplesOf3And5();
    }

    protected void multiplesOf3And5() {
        long start = System.currentTimeMillis();

        long sum = 0;
        for (int i = 1; i < 1000; i++) {
            if (0 == i % 3 || 0 == i % 5){
                sum += i;
            }
        }
        System.out.println("sum = " + sum);

        System.out.println("cost time : " + (System.currentTimeMillis() - start) + "ms.");
    }
}
