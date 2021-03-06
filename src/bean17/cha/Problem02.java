package bean17.cha;

/**
 Even Fibonacci numbers
 Problem 2
 Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:

 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

 By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
 * @author  bean17.cha@gmail.com
 */
public class Problem02 {
    final int max = 4000000;

    public static void main(String[] args) {
        new Problem02().evenFibonacciNumbers();
    }

    protected void evenFibonacciNumbers() {
        long start = System.currentTimeMillis();

        long sum;

        int a0 = 1;
        int a1 = 2;
        sum = a1;

        int a2 = a0 + a1;
        while (a2 <= max){
            if (0 == a2 % 2){
                sum += a2;
            }

            a0 = a1;
            a1 = a2;
            a2 = a0 + a1;
        }

        System.out.println("sum = " + sum);
        System.out.println("cost time : " + (System.currentTimeMillis() - start) + "ms.");
    }
}
