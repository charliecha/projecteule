package bean17.cha;

import java.util.ArrayList;
import java.util.List;

public class Problem10 {

	/**
	 * @param args arguments
	 */
	public static void main(String[] args) {
		p10();
	}

    /**
     * Problem 10
     * compute sum of prime factor in [2, 1,000,000)
     */
    protected static void p10() {
        long start = System.currentTimeMillis();

        long result = 0;
        List<Long> primeFactorList = primeFactor(2, 2000000);
        for (long factor : primeFactorList) {
			result += factor;
		}
        
        System.out.println("cost time : " + (System.currentTimeMillis() - start) + "ms.");
        System.out.println("result = " + result);
    }
	
    /**
     * compute prime factor in [start, end)
     * 
     * @param start start
     * @param end end
     * @return primes
     */
    private static List<Long> primeFactor(long start, long end) {
        List<Long> primeFactorList = new ArrayList<Long>();
        for (long i = 2; i < end; ) {
            boolean prime = true;
            for (int j = 0; j < primeFactorList.size(); j++) {
                long value = primeFactorList.get(j);
                long sqrt = (long) Math.sqrt(i) + 1;
                if (0 == i % value) {
                    prime = false;
                    break;
                } else if (value > sqrt) {
                    break;
                }
            }

            if (prime) {
                primeFactorList.add(i);
            }

            if (0 != i % 2) {
                i+=2;
            } else {
            	i++;
            }
        }

        if (start > 2) {
            for (int i = primeFactorList.size() - 1; i >= 0; i--) {
                primeFactorList.remove(i);
            }
        }
        return primeFactorList;
    }
}
