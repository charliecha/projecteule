package bean17.cha;


/**
 * Summation of primes
 Problem 10
 The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

 Find the sum of all the primes below two million.
 * @author bean17.cha@gmail.com
 */
public class Problem10 {

    static final int N = 2000000;
	/**
	 * @param args arguments
	 */
	public static void main(String[] args) {
		new Problem10().summationOfPrimes();
	}

    /**
     * Problem 10
     * compute sum of prime factor in [2, 1,000,000)
     */
    protected void summationOfPrimes() {
        long start = System.currentTimeMillis();

        long result = 0;
        for (int i = 2; i <= N; ) {
            if (Utils.isPrime(i)){
                result += i;
            }
            if (1 == i % 2){
                i+=2;
            } else {
                i++;
            }
        }

        System.out.println("cost time : " + (System.currentTimeMillis() - start) + "ms.");
        System.out.println("result = " + result);
    }

}
